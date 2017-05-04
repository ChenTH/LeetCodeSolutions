package com.cth.test;

public class FileProblemSloution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("/Users");
		System.out.println(file.listFiles());
		System.out.println(file.size());
		System.out.println(file.isDirectory());
	}

}
