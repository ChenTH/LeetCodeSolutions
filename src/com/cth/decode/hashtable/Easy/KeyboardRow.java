package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SherlockTHao on 2017/3/17 0017.
 */
public class KeyboardRow {
    public static void main(String[] args){

    }
    public String[] findWords(String[] words) {
        List<String> result=new ArrayList<String>();
        HashMap<Character,Integer> map=initMap();
        for(String word : words){
            char[] temp=word.toLowerCase().toCharArray();
            boolean res=true;
            int a=0;
            for(char c : temp){
                if(a==0){
                    a=map.get(c);
                }
                else {
                    if(map.get(c)!=a){
                        res=false;
                        break;
                    }
                }
            }
            if(res){
                result.add(word);
            }
        }
        return (String [])result.toArray(new String[result.size()]);
    }
    public HashMap<Character,Integer> initMap(){
        char[] letter1={'q','w','e','r','t','y','u','i','o','p'};
        char[] letter2={'a','s','d','f','g','h','j','k','l'};
        char[] letter3={'z','x','c','v','b','n','m'};
        HashMap<Character,Integer> map=new HashMap<>();
        for(char a : letter1){
            map.put(a,1);
        }
        for(char a : letter2){
            map.put(a,2);
        }
        for(char a : letter3){
            map.put(a,3);
        }
        return map;
    }
}
