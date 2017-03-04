package com.cth.decode.hashtable;

import java.util.HashMap;

public class BullsandCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String a="1807";
			String b="7810";
			getHint(a,b);
	}
    public static String getHint(String secret, String guess) {
    	int bull=0;
    	int cow=0;
    	HashMap<Character, Integer> bullmap=new HashMap<>();
    	HashMap<Character, Integer> secretmap=new HashMap<>();
    	HashMap<Character, Integer> cowmap=new HashMap<>();
    	for(int i=0;i<secret.length();i++){
			if(secretmap.containsKey(secret.charAt(i))){
				secretmap.put(secret.charAt(i), secretmap.get(secret.charAt(i))+1);
			}
			else {
				secretmap.put(secret.charAt(i), 1);
			}
			
    		if(secret.charAt(i)==guess.charAt(i)){
    			bull++;
    			if(bullmap.containsKey(secret.charAt(i))){
    				bullmap.put(secret.charAt(i), bullmap.get(secret.charAt(i))+1);
    			}
    			else {
    				bullmap.put(secret.charAt(i), 1);
				}
    		}
    	}
    	for(int i=0;i<guess.length();i++){
    		if(secretmap.containsKey(guess.charAt(i))){
    			if(cowmap.containsKey(guess.charAt(i))){
    				cowmap.put(guess.charAt(i), cowmap.get(guess.charAt(i))+1);
    			}
    			else {
    				cowmap.put(guess.charAt(i), 1);
				}
    		}
    	}
    	for(char ch : cowmap.keySet()){
    		int count=cowmap.get(ch);
    		int secretcount=secretmap.get(ch);
    		if(secretcount<count){
    			count=secretcount;
    		}
    		if(bullmap.containsKey(ch)){
        		int guesscount=bullmap.get(ch);
    			cow+=count-guesscount;
    		}
    		else{
    			cow+=count;
    		}
    	}
		return bull+"A"+cow+"B";
    }
}
