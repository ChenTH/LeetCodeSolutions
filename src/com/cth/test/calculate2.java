package com.cth.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class calculate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		ArrayList<Integer[]> R  = new ArrayList<>();
		ArrayList<Integer[]> G  = new ArrayList<>();
		ArrayList<Integer[]> B  = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			String temp1 = scanner.next();
			Integer[] index = new Integer[3];
			index[0]=scanner.nextInt();
			index[1]=scanner.nextInt();
			index[2]=scanner.nextInt();
			if(temp1.equals("R")){
				R.add(index);
			}else if(temp1.equals("G")){
				G.add(index);
			}else if(temp1.equals("B")){
				B.add(index);
			}
		}
		double max = 0;

		if(R.size()>=3){
			for(int i=0;i<R.size();i++){
				for(int j=i+1;j<R.size();j++){
					for(int k=j+1;k<R.size();k++){
						Integer[] index1 = R.get(i);
						Integer[] index2 = R.get(j);
						Integer[] index3 = R.get(k);
						double temp = calculateArea(index1,index2,index3);
						if(temp>max){
							max = temp;
						}
					}
				}
			}
		}

		if(G.size()>=3){
			for(int i=0;i<G.size();i++){
				for(int j=i+1;j<G.size();j++){
					for(int k=j+1;k<G.size();k++){
						Integer[] index1 = G.get(i);
						Integer[] index2 = G.get(j);
						Integer[] index3 = G.get(k);
						double temp = calculateArea(index1,index2,index3);
						if(temp>max){
							max = temp;
						}
					}
				}
			}
		}

		if(R.size()>=3){
			for(int i=0;i<B.size();i++){
				for(int j=i+1;j<B.size();j++){
					for(int k=j+1;k<B.size();k++){
						Integer[] index1 = B.get(i);
						Integer[] index2 = B.get(j);
						Integer[] index3 = B.get(k);
						double temp = calculateArea(index1,index2,index3);
						if(temp>max){
							max = temp;
						}
					}
				}
			}
		}
		if(R.size()>0&&G.size()>0&&B.size()>0){
			for(int i=0;i<R.size();i++){
				for(int j=0;j<G.size();j++){
					for(int k=0;k<B.size();k++){
						Integer[] index1 = R.get(i);
						Integer[] index2 = G.get(j);
						Integer[] index3 = B.get(k);
						double temp = calculateArea(index1,index2,index3);
						if(temp>max){
							max = temp;
						}
					}
				}
			}
		}
		
		java.text.DecimalFormat   df=new  java.text.DecimalFormat("0.00000");
		String answer = df.format(max);
		System.out.println(answer);
		
	}
	
	public static  double calculateArea(Integer[] a,Integer[] b,Integer[] c) {
		double ab=calculateLength(a, b);
		double bc=calculateLength(b, c);
		double ac=calculateLength(a, c);
		double p=(ab+bc+ac)/2;
		return Math.sqrt(p*(p-ab)*(p-bc)*(p-ac));
	}
	public static double calculateLength(Integer[] a,Integer[] b) {	
		int temp=0;
		for(int i=0;i<a.length;i++){
			temp+=Math.pow((a[i]-b[i]),2);
		}
		return Math.sqrt(temp);
	}
	

}

