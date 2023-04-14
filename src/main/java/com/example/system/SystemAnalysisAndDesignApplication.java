package com.example.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Math.max;


@SpringBootApplication
public class SystemAnalysisAndDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAnalysisAndDesignApplication.class, args);
    }
//
////        int array1[] = {2,1,1,2,5,6,1,1,1,1,1,1,1,1,1,1};
////        int array2[] = {2,1,1,2,5,6,1,1,1,1,1,1,1,1,1,1};
////        int array1[] = {2,1};
////        int array2[] = {2,1};
//
////        System.out.println(LCS(randomArray(100),randomArray(100)));
////        int array1[] = {1,1,1,1,1,1,1,1,1,1,1};
////        int array2[] = {1,1,1,1,1,1,1,1,1,1,1};
//        int array1[] = {2,3,4,5,11,1,6};
//        int array2[] = {1,6,7,8,9};
//        System.out.println(LCS(array1,array2));
//    }
//    public static int[] randomArray(int size){
//
//        int[] array = new int[size];
//        for(int i = 0; i<array.length;i++){
//            array[i] = (int)(Math.random()*10);//0~1乘数1000，内容变为0~1000，强转为整型
//        }
//        return array;
//    }
//    public static int LCS(int[] array1, int[] array2) {
//        for(int i = 0;i<array1.length;i++){
//            System.out.println(array1[i]);
//        }
//        System.out.println(" ");
//        for (int i = 0;i< array2.length;i++){
//            System.out.println(array2[i]);
//        }
//        int[][] dp = new int[array1.length + 1][array2.length + 1];
//        int[] a = new int[array1.length+1];
//        int m=0;
//        int i=0 ,j=0;
//        for ( i = 1; i <= array1.length; i++) {
//            for (j = 1; j <= array2.length; j++) {
//                dp[i][j] = dp[i-1][j];
//                if(array1[i-1]==array2[j-1]){
//                    for(int k=0;k<j;k++){
//                        if(k == 0){
//                            dp[i][j]=max(1,dp[i][j]);
//                        }else if(array2[j-1]>=array2[k-1]){
//                            dp[i][j]=max(dp[i-1][k]+1,dp[i][j]);
//                        }
//                    }
//                }
//            }
//        }
//        int max = 0;
//        for(int k = 1 ;  k<=array2.length;k++){
//            if(max<dp[i-1][k])
//                max = dp[i-1][k];
//        }
//        return max;
// //       return max(dp[i-1]);
//    }
//    public static boolean judge(int i,int[] array1,int j ,int[] array2,int [][][] dp){
//        if(((j==1)||(i==1))&&(array1[i-1] == array2[j-1]))
//            return true;
//        if (i>1&&array1[i-1]==array2[j-1]&&array1[i-1]>=dp[i-1][j-1][1])
//            return true;
//        return false;
//    }
}
