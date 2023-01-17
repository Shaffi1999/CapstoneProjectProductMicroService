package com.shopping.product.exception;



import java.util.Date;

public class ErrorResponse {
private Date doe;
private String errorMessage;
private String path;

public ErrorResponse()
{
	
}

public ErrorResponse(Date doe, String errorMessage, String path) {
	super();
	this.doe = doe;
	this.errorMessage = errorMessage;
	this.path = path;
}

public Date getDoe() {
	return doe;
}

public void setDoe(Date doe) {
	this.doe = doe;
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

}
