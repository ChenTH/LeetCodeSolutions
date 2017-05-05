package com.cth.test;
import java.util.Scanner;

public class thekluck {

    public static void  main(String[] args){  
        
        Scanner input=new Scanner(System.in);  
        //System.out.println("please input test times");  
       int times=input.nextInt();  
        int[] posList=new int[times];  
        for(int i=0;i<times;i++){  
            posList[i]=input.nextInt();  
        }  
        kLuck(times,posList);             
    }  
  
    private static void kLuck(int times, int[] posList) {  
        // TODO Auto-generated method stub  
        if(times!=posList.length||times<=0||posList==null)  
            return;  
         for(int i=0;i<times;i++)  
            {  
               int pos=posList[i];  
               //n为输入的数值  
               char[] resultStr=new char[100];  
              int bit=kLuckAtPos(pos,resultStr);  
              // System.out.println(result);  
              //String s="";  
             // System.out.println();  
              printResult(resultStr,bit);  
                
            }  
           
    }  
  
    private static void printResult(char[] resultStr, int bit) {  
        // TODO Auto-generated method stub  
        if(bit==-1) return;  
        for(int i=bit-1;i>=0;i--)  
            System.out.print(resultStr[i]);  
        System.out.println();  
                    
    }  
  
    private static int kLuckAtPos(int pos, char[] resultStr) {  
        // TODO Auto-generated method stub  
        if(pos<=0) return -1;  
        long ans=0;  
          
        int bit=0;  
        pos=pos+1;  
        //二进制编码等于位置+1 EG：44 对应位置 3 表示成二进制100       
        while(pos>0){   
                if((pos&0x1)>0) {  
                    if((pos&0x3)==3&&pos>>2==0)  
                        pos=pos>>1;  
                        resultStr[bit]='7';  
                    // ans=ans+(int)(7*Math.pow(10,bit));  
                    }  
                  
                 else if((pos&0x0)==0){  
                      if((pos&0x2)==2&&pos>>2==0)  
                         pos=pos>>1;  
                      resultStr[bit]='4';  
                   }  
                 bit=bit+1;  
                 pos=pos>>1;           
        }     
        return bit;  
    }  
}
