package com.example.demo.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;





@Entity
@Table(name="roles")
public class Roles implements GrantedAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public void setAuthority() {
		// TODO Auto-generated method stub
		 this.name = name;
	}
	public Roles(String authority){
        this.name = authority;
    }

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Roles(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
