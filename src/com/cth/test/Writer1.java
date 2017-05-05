package com.cth.test;

import java.io.*;  
  
public class Writer1{  
    public static void main(String[] args){  
        int i;  
        String s = new String("Just a testing for writer stream!\n");  
        File fl = new File("d://testwriter1.txt");  
        if (fl.exists()){  
            fl.delete();  
        }  
          
        try{  
            fl.createNewFile();  
        }catch(IOException e){  
            System.out.println("File created failed!");  
        }  
        System.out.println("File created!");  
  
         
        FileWriter fw = null;  
        try{  
           fw = new FileWriter(fl);   
        }catch(IOException e){  
            System.out.println("Create filewriter failed!");  
            if (null != fw){  
                try{  
                    fw.close();  
                }catch(IOException e1){  
                    System.out.println("Close the filewriter failed!");  
                    return;  
                }  
                System.out.println("Close the filewriter successfully!");  
            }  
            return;  
        }   
  
        for (i=0; i<s.length(); i++){  
            try{  
                fw.write((int)s.charAt(i));  
            }catch(IOException e){  
                System.out.println("error occurs in fw.write()!");  
            }  
        }  
          
        System.out.println("done!");  
    }      
}  
