package com.java5;

public enum EnumHolder {
	STR("String Value"),
	INT("Integer Value");
	
	private String value;
	
	private EnumHolder(String value) {
		this.value = value;
	}

	public String toString()
	{
		return this.value;
	}
}
