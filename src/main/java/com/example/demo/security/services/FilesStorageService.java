package com.example.demo.security.services;
 import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Modem;

public interface FilesStorageService {
	  public void init();

	  public List<Modem> save(MultipartFile file,String name) throws  IOException, ParseException;

	  public Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();

	void savea(MultipartFile file, String name);

}
