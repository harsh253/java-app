package com.sapient.utils;

public class Filename {
	
	public static String getFileExtension(String file) {
		String extension = file.substring(file.lastIndexOf('.')+1);
		return extension;
	}

}
