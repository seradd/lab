package com.lab.hometask.web.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericResponse<T> implements Serializable{

	private static final long serialVersionUID = 3291325083243033835L;

	private T data;
	
	private String message;
	
	private String status;
	
	
	
	
	
	
	
	
	

}
