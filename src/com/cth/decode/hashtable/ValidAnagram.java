package com.cth.decode.hashtable;

import java.io.IOException;
import java.util.HashMap;
import com.cth.util.ReadFile;

public class ValidAnagram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadFile rFile=new ReadFile();
		String s=ReadFile.readFileContent("D:\\string1.txt");
		String t=ReadFile.readFileContent("D:\\string2.txt");
		boolean flag=isAnagram(s,t);
		System.out.println(flag);
	}
    public static boolean isAnagram(String s, String t) {
    	HashMap<Character, Integer> map1=new HashMap<>();
    	HashMap<Character, Integer> map2=new HashMap<>();
    	for(int i=0;i<s.length();i++){
    		if(map1.containsKey(s.charAt(i))){
    			map1.put(s.charAt(i), map1.get(s.charAt(i))+1);
    		}else{
    			map1.put(s.charAt(i),1);
    		}
    	}
    	
    	for(int i=0;i<t.length();i++){
    		if(map2.containsKey(t.charAt(i))){
    			map2.put(t.charAt(i), map2.get(t.charAt(i))+1);
    		}else{
    			map2.put(t.charAt(i),1);
    		}
    	}
    	
    	
    	if(map1.size()!=map2.size()){
    		return false;
    	}
    	else {
			for(char ch : map1.keySet()){
				if(map2.containsKey(ch)){
					int a = map1.get(ch);
					int b= map2.get(ch);
					if(a!=b){
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
    }
    
}
