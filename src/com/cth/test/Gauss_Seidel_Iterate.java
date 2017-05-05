package com.cth.test;
 
import java.util.Scanner;
 
/*ʹ�ø�˹���¶�������������Է�����*/
public class Gauss_Seidel_Iterate {
    /*��������*/
    private static float[][] find_lower(float data[][],int k){
        int length=data.length;
        float data2[][]=new float[length][length];
        if(k>=0){
            for(int i=0;i<=length-k-1;i++){
                for(int j=0;j<=i+k;j++){
                    data2[i][j]=data[i][j];
                }
            }
            for(int i=length-k;i<length;i++){
                for(int j=0;j<length;j++){
                    data2[i][j]=data[i][j];
                }
            }
        }
        else{
            for(int i=-k;i<length;i++){
                for(int j=0;j<=i+k;j++){
                    data2[i][j]=data[i][j];
                }
            }
        }
        return data2;
    }
    /*��ԭ����ĸ�*/
    private static float[][] opposite_matrix(float[][] data){
        int M=data.length;
        int N=data[0].length;
        float data_temp[][]=new float[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                data_temp[i][j]=-data[i][j];
            }
        }
        return data_temp;
    }
    /*ԭ����ȥ����i+1�е�j+1�к��ʣ�����*/
    private static float[][] get_complement(float[][] data, int i, int j) {
 
        /* x��yΪ����data������������ */
        int x = data.length;
        int y = data[0].length;
 
        /* data2Ϊ����ʣ����� */
        float data2[][] = new float[x - 1][y - 1];
        for (int k = 0; k < x - 1; k++) {
            if (k < i) {
                for (int kk = 0; kk < y - 1; kk++) {
                    if (kk < j) {
                        data2[k][kk] = data[k][kk];
                    } else {
                        data2[k][kk] = data[k][kk + 1];
                    }
                }
 
            } else {
                for (int kk = 0; kk < y - 1; kk++) {
                    if (kk < j) {
                        data2[k][kk] = data[k + 1][kk];
                    } else {
                        data2[k][kk] = data[k + 1][kk + 1];
                    }
                }
            }
        }
        return data2;
 
    }
    /* �����������ʽ */
    private static float cal_det(float[][] data) {
        float ans=0;
        /*��Ϊ2*2�ľ����ֱ����ֵ������*/
        if(data[0].length==2){
             ans=data[0][0]*data[1][1]-data[0][1]*data[1][0];
        }
        else{
            for(int i=0;i<data[0].length;i++){
                /*������Ϊ2*2��ô����������һ�д�������ʽ�ĺ�*/
                float[][] data_temp=get_complement(data, 0, i);
                if(i%2==0){
                    /*�ݹ�*/
                    ans=ans+data[0][i]*cal_det(data_temp);
                }
                else{
                    ans=ans-data[0][i]*cal_det(data_temp);
                }
            }
        }
        return ans;
 
    }
     
    /*�������İ������*/
    private static float[][] ajoint(float[][] data) {
        int M=data.length;
        int N=data[0].length;
        float data2[][]=new float[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
            if((i+j)%2==0){
                data2[i][j]=cal_det(get_complement(data, i, j));
            }
            else{
                data2[i][j]=-cal_det(get_complement(data, i, j));
            }
            }
        }
         
        return trans(data2);
         
 
    }
     
    /*ת�þ���*/
    private static float [][]trans(float[][] data){
        int i=data.length;
        int j=data[0].length;
        float[][] data2=new float[j][i];
        for(int k2=0;k2<j;k2++){
            for(int k1=0;k1<i;k1++){
                data2[k2][k1]=data[k1][k2];
            }
        }
         
        /*������ת�ñ�ɵõ��������*/
        return data2;
         
    }
     
     
     
    /*�������棬�������Ϊԭ����*/
    private static float[][] inv(float [][] data){
        int M=data.length;
        int N=data[0].length;
        float data2[][]=new float[M][N];
        float det_val=cal_det(data);
        data2=ajoint(data);
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                data2[i][j]=data2[i][j]/det_val;
            }
        }
         
        return data2;
    }
    /*����ӷ�*/
    private static float[][] matrix_add(float[][] data1,float[][] data2){
        int M=data1.length;
        int N=data1[0].length;
        float data[][]=new float[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                data[i][j]=data1[i][j]+data2[i][j];
            }
        }
        return data;
    }
    /*�������*/
    private static float[][] multiply(float[][] data1,float[][] data2){
        int M=data1.length;
        int N=data1[0].length;
        int K=data2[0].length;
        float[][] data3=new float[M][K];
        for(int i=0;i<M;i++){
            for(int j=0;j<K;j++){
                for(int k=0;k<N;k++){
                    data3[i][j]+=data1[i][k]*data2[k][j];
                }
            }
        }
        return data3;
    }
    /*�������Ϊԭ�����һ������,����������ӶԽ������ϻ�����ƽ�Ƶ�Ԫ�ظ���*/
    private static float[][] find_upper(float[][] data,int k){
        int length=data.length;
        int M=length-k;
        float[][] data2=new float[length][length];
        if(k>=0){
            for(int i=0;i<M;i++){
                for(int j=k;j<length;j++){
                    data2[i][j]=data[i][j];
                }
                k+=1;
            }
        }
        else {
            for(int i=0;i<-k;i++){
                for(int j=0;j<length;j++){
                    data2[i][j]=data[i][j];
                }
            }
            for(int i=-k;i<length;i++){
                for(int j=i+k;j<length;j++){
                    data2[i][j]=data[i][j];
                }
            }
        }
        return data2;
    }
    /*m*n������nά�����ĳ˷�*/
    private static float[] multiply2(float[][] data1,float[] data2){
        int M=data1.length;
        int N=data1[0].length;
        float[] data3=new float[M];
        for(int k=0;k<M;k++){
                for(int j=0;j<N;j++){
                    data3[k]+=data1[k][j]*data2[j];
                }
        }
        return data3;
    }
    /*�����ӷ�*/
    private static float[] matrix_add2(float[] data1,float[] data2){
        int M=data1.length;
        float data[]=new float[M];
        for(int i=0;i<M;i++){
                data[i]=data1[i]+data2[i];
        }
        return data;
    }
    /*��������֮��Ķ����������ڼ�����*/
    private static double cal_error(float[] X1,float[] X2){
        int M=X1.length;
        double temp=0;
        for(int i=0;i<M;i++){
            temp+=Math.pow((X1[i]-X2[i]),2);
        }
        temp=Math.sqrt(temp);
        return temp;
    }
    /*�����ĶԽǾ���*/
    private static float[][] find_diagnal(float A[][]) {
        int m = A.length;
        int n = A[0].length;
        float B[][] = new float[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    B[i][j] = A[i][j];
                }
            }
        }
        return B;
 
    }
    /*��˹���¶�������*/
    private static float[] Gauss_Seidel_method(float[][] A,float[] B,float[] X){
        float D[][]=find_diagnal(A);
        float L[][]=find_lower(A, -1);
        float U[][]=find_upper(A, 1);
        float temp1[][]=inv(matrix_add(D, L));
        float temp2[][]=opposite_matrix(temp1);
        float B0[][]=multiply(temp2, U);
        float F[]=multiply2(temp1, B);
         
        return matrix_add2(multiply2(B0, X), F);
     
         
    }
     
    public static void main(String[] args) {
        System.out.println("����ϵ��������к�������");
        Scanner scan=new Scanner(System.in);
        int M=scan.nextInt();
        System.out.println("���뷽�����Ҳ෽��ֵ��ά�ȣ�");
        int K=scan.nextInt();
        if(M!=K){
            System.out.println("�����������δ֪���������ȣ�");
            System.exit(0);
        }
         
        System.out.println("����ϵ������");
        float[][] A=new float[M][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                A[i][j]=scan.nextFloat();
            }
        }
         
        System.out.println("����ֵ����");
        float[] B=new float[M];
        for(int i=0;i<M;i++){
            B[i]=scan.nextFloat();
        }
         
        System.out.println("�����ʼ����������");
        float[] X=new float[M];
        for(int i=0;i<M;i++){
            X[i]=scan.nextFloat();
        }
         
        System.out.println("��������ޣ�");
        float er=scan.nextFloat();
        float temp[]=new float[M];
        while(cal_error((temp=Gauss_Seidel_method(A, B, X)), X)>=er){
            X=temp;
        }
//      while(cal_error((temp=Gauss_Seidel_method(A, B, X)), X)>=er){
//          X=temp;
//          
//      }
        X=temp;
        System.out.println("��˹���¶�����õ��Ľ�����Ϊ��");
        for(int i=0;i<M;i++){
            System.out.println(X[i]+" ");
        }
        System.out.println();
 
    }
 
}