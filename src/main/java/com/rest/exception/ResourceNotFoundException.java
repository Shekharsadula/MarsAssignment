package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionDetail;
	private Long fieldValue;

	public ResourceNotFoundException(String exceptionDetail, Long fieldValue) {
		super(exceptionDetail);
		this.exceptionDetail = exceptionDetail;
		this.fieldValue = fieldValue;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public Long getFieldValue() {
		return fieldValue;
	}

}
