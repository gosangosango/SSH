package com.project.ssh.exception;

public class SSHRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String redirectURL;
	
	public SSHRuntimeException(String message){
		
		super(message);
		
	}
	
	public String getRedirectURL(){
		
		return redirectURL;
	}
	
	public void setRedirectURL(String redirectURL){
		this.redirectURL = redirectURL;
	}
	
}
