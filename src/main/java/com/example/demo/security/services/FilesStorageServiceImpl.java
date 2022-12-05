package com.example.demo.security.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Modem;
import com.example.demo.models.User;
import com.example.demo.repository.ModemRepository;
import com.example.demo.repository.UserRepository;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  
 
@Service
public class FilesStorageServiceImpl implements FilesStorageService {
  private final Path root = Paths.get("uploads");  
 @Autowired
 ModemRepository modemRepository;
 @Autowired
 UserRepository userRepository;
 

 String randomString() {
	  String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 10; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	    
	}

 @Override
 public void init() {
   try {
     Files.createDirectories(root);
   } catch (IOException e) {
     throw new RuntimeException("Could not initialize folder for upload!");
   }
 }

  @Override
  public void savea(MultipartFile file,String name) {
        try {
      Files.copy(file.getInputStream(), this.root.resolve(name));
    } catch (Exception e) {
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("A file of that name already exists.");
      }

      throw new RuntimeException(e.getMessage());
    }
    
  }
  @Override
  public List<Modem> save(MultipartFile file,String name) throws IOException, ParseException {
		String names = this.randomString()+"_"+file.getOriginalFilename();
	      try {
	      Files.copy(file.getInputStream(), this.root.resolve(names));
	    } catch (Exception e) {
	      if (e instanceof FileAlreadyExistsException) {
	        throw new RuntimeException("A file of that name already exists.");
	      }

	      throw new RuntimeException(e.getMessage());
	    }
	      String path = this.root.resolve(names).toString();
	  //obtaining input bytes from a file  
	  FileInputStream fis=new FileInputStream(path);  
	  //creating workbook instance that refers to .xls file  
	  HSSFWorkbook wb=new HSSFWorkbook(fis);   
	  //creating a Sheet object to retrieve the object  
	  HSSFSheet sheet=wb.getSheetAt(0);  
	  //evaluating cell type   
	  FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
	 int i = 0;
	  for(Row row: sheet)     //iteration over row using for each loop  
	  {  
		  i++;
	  Modem m = new Modem();
	  if(row.getCell(1)!= null) {
		  
	
 if(i > 1) {
	 DataFormatter dataFormatter = new DataFormatter();
	 String cellStringValue = dataFormatter.formatCellValue(row.getCell(0));
	 String correctDateFormat="";
	 String str[] = cellStringValue.split("/");
	 if (str[1].length() == 1) {
		 correctDateFormat = "0" +str[1]+"/" ;
	  }  else {
			 correctDateFormat = str[1]+"/" ;

	  }
	 if (str[0].length() == 1) {
		 correctDateFormat = correctDateFormat +"0" +str[0] +"/" ;
	  }  else {
			 correctDateFormat = correctDateFormat +str[0] +"/" ;
	  }
	 if (str[2].length() == 2) {
		 correctDateFormat = correctDateFormat +"20" +str[2] ;
	  }  else {
			 correctDateFormat = correctDateFormat +str[2] ;
	  }

  	 Date dateCreation = new SimpleDateFormat("dd/MM/yyyy").parse(correctDateFormat);
 	 User user = userRepository.findByUsername(row.getCell(1).getStringCellValue()).orElse(null);
 	 
 	 m.setDateActivation(dateCreation);
 	 m.setConseiller(row.getCell(1).getStringCellValue());
	 m.setGroupClient(row.getCell(2).getStringCellValue());
	 m.setMSISDN(row.getCell(4).getStringCellValue());
	 m.setNumClient(row.getCell(3).getStringCellValue());
	 m.setOffre(row.getCell(5).getStringCellValue());
 	  modemRepository.save(m);
  	 if(user != null) {
  		 user.addProduit(m);
  	 	 userRepository.save(user);
   	}
}  
 }

	  }  
	  return modemRepository.findAll();
    
  }
  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
}
