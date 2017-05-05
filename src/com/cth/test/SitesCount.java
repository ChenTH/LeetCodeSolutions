package com.cth.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SitesCount {
	public static void name(String[] args) throws Exception {
		HashMap<String, Set<String>> map=new HashMap<>();
		Set<String> sites=null;
		String line=null;
		String phone=null;
		String site=null;
		BufferedReader bReader=new BufferedReader(new FileReader(" "));
		while (null!=(line=bReader.readLine())) {
			String[] fields =line.split("\t");
			if(fields.length<28) break;
			phone=fields[6];
			site=fields[27];
			sites=map.get(phone);
			if(site==null){
				sites=new HashSet<String>();
			}
			sites.add(site);
			map.put(phone, sites);
		}
		System.out.println(map.size());
	}
}
