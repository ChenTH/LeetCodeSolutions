package com.cth.test;
 
import java.util.Scanner;
 
/*使用高斯赛德尔迭代法求解线性方程组*/
public class Gauss_Seidel_Iterate {
    /*求下三角*/
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
    /*求原矩阵的负*/
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
    /*原矩阵去掉第i+1行第j+1列后的剩余矩阵*/
    private static float[][] get_complement(float[][] data, int i, int j) {
 
        /* x和y为矩阵data的行数和列数 */
        int x = data.length;
        int y = data[0].length;
 
        /* data2为所求剩余矩阵 */
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
    /* 计算矩阵行列式 */
    private static float cal_det(float[][] data) {
        float ans=0;
        /*若为2*2的矩阵可直接求值并返回*/
        if(data[0].length==2){
             ans=data[0][0]*data[1][1]-data[0][1]*data[1][0];
        }
        else{
            for(int i=0;i<data[0].length;i++){
                /*若矩阵不为2*2那么需求出矩阵第一行代数余子式的和*/
                float[][] data_temp=get_complement(data, 0, i);
                if(i%2==0){
                    /*递归*/
                    ans=ans+data[0][i]*cal_det(data_temp);
                }
                else{
                    ans=ans-data[0][i]*cal_det(data_temp);
                }
            }
        }
        return ans;
 
    }
     
    /*计算矩阵的伴随矩阵*/
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
     
    /*转置矩阵*/
    private static float [][]trans(float[][] data){
        int i=data.length;
        int j=data[0].length;
        float[][] data2=new float[j][i];
        for(int k2=0;k2<j;k2++){
            for(int k1=0;k1<i;k1++){
                data2[k2][k1]=data[k1][k2];
            }
        }
         
        /*将矩阵转置便可得到伴随矩阵*/
        return data2;
         
    }
     
     
     
    /*求矩阵的逆，输入参数为原矩阵*/
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
    /*矩阵加法*/
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
    /*矩阵相乘*/
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
    /*输入参数为原矩阵和一个整数,该整数代表从对角线往上或往下平移的元素个数*/
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
    /*m*n矩阵与n维向量的乘法*/
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
    /*向量加法*/
    private static float[] matrix_add2(float[] data1,float[] data2){
        int M=data1.length;
        float data[]=new float[M];
        for(int i=0;i<M;i++){
                data[i]=data1[i]+data2[i];
        }
        return data;
    }
    /*求两向量之差的二范数（用于检验误差）*/
    private static double cal_error(float[] X1,float[] X2){
        int M=X1.length;
        double temp=0;
        for(int i=0;i<M;i++){
            temp+=Math.pow((X1[i]-X2[i]),2);
        }
        temp=Math.sqrt(temp);
        return temp;
    }
    /*求矩阵的对角矩阵*/
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
    /*高斯赛德尔迭代法*/
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
        System.out.println("输入系数矩阵的行和列数：");
        Scanner scan=new Scanner(System.in);
        int M=scan.nextInt();
        System.out.println("输入方程组右侧方程值的维度：");
        int K=scan.nextInt();
        if(M!=K){
            System.out.println("方程组个数和未知数个数不等！");
            System.exit(0);
        }
         
        System.out.println("输入系数矩阵：");
        float[][] A=new float[M][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                A[i][j]=scan.nextFloat();
            }
        }
         
        System.out.println("输入值向量");
        float[] B=new float[M];
        for(int i=0;i<M;i++){
            B[i]=scan.nextFloat();
        }
         
        System.out.println("输入初始迭代向量：");
        float[] X=new float[M];
        for(int i=0;i<M;i++){
            X[i]=scan.nextFloat();
        }
         
        System.out.println("输入误差限：");
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
        System.out.println("高斯赛德尔计算得到的解向量为：");
        for(int i=0;i<M;i++){
            System.out.println(X[i]+" ");
        }
        System.out.println();
 
    }
 
}