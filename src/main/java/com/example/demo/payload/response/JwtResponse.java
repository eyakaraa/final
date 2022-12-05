package com.example.demo.payload.response;

import java.util.List;

import com.example.demo.models.Modem;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String status;
    private String role;
    private List<Modem> produit;

    public JwtResponse(String accessToken, String firstname,String lastname,String status, Long id, String username, String email, String roles,List<Modem> Produits) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = roles;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
        this.produit = Produits;
    }
    
    public List<Modem> getProduit() {
		return produit;
	}

	public void setProduit(List<Modem> produit) {
		this.produit = produit;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole(String roles) {
		this.role = roles;
	}
    
}
