package com.example.library_management_system.util;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ResponseStructure<T> {
	private String message;
	private T data;
	private int status;
	private LocalDateTime dateTime=LocalDateTime.now();
}
