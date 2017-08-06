package com.cth.decode.hashtable.Easy;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern="ab";
		String str="dog dog";
		boolean flag=wordPattern(pattern,str);
		System.out.println(flag);
//		String[] a={"hehe","heihei"};
//    	HashMap<String, String> map1=new HashMap<>();
//    	map1.put("hehe", "lala");
//    	map1.put("heihei", "loulou");
//		System.out.println(map1.containsKey(a[0]));
	}
    public static boolean wordPattern(String pattern, String str) {
    	String[] strarray=str.split(" ");
    	if(strarray.length!=pattern.length()){
    		return false;
    	}
    	HashMap<Character, String> map1=new HashMap<>();
    	HashMap<String, Character> map2=new HashMap<>();
    	for(int i=0;i<pattern.length();i++){
    		if(map1.containsKey(pattern.charAt(i))){
    			if(!(map1.get(pattern.charAt(i)).equals(strarray[i]))){
    				return false;
    			}
    			
    		}else if(map2.containsKey((strarray[i]))){
    			if(!(map2.get(strarray[i]).equals(pattern.charAt(i)))){
    				return false;
    			}
			}
    		else{
    			map1.put(pattern.charAt(i), strarray[i]);
    			map2.put(strarray[i],pattern.charAt(i));
    		}
    	}
		return true;
    }
}
