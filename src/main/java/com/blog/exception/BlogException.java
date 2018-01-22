package com.blog.exception;

public class BlogException extends Exception {

	private static final long serialVersionUID = -7877335589038435160L;

	private static final String ERROR_GENERICO = "999999";
	
	private String desc;
	private String code;
	private Exception e;

	public BlogException(String code,String desc){
		this.code=code;
		this.desc=desc;
	}
	
	public BlogException(String desc){
		this.code=ERROR_GENERICO;
		this.desc=desc;
		
	}

	public BlogException(Exception ex, String code, String desc) {
		this.code=code;
		this.desc=desc;
		this.e=ex;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

}
