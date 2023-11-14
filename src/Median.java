package org.core;
public class Median {
    public static void main(String[] args) {
        int[] num1 = {1,2,4};
        int[] num2 = {3,5,6};
        double result = median(num1,num2);
        System.out.println(result);
    }
    private static double median(int[] num1, int[] num2) {
        int len = num1.length+num2.length;
        int n =0;
        int m =0;
        int i =0;
        int[] sorted = new int[len];
        double ans = 0.0;
        while (n!=num1.length && m!=num2.length){
            if (num1[n]<num2[m]){
                sorted[i]=num1[n];
                n++;
            }
            else {
                sorted[i]=num2[m];
                m++;
            }
            i++;

        }
        while (m!=num2.length){
            sorted[i]=num2[m];
            m++;
        }
        while (n!=num1.length){
            sorted[i]=num1[n];
            n++;
        }

        if (len%2==0){
            ans = (double) (sorted[len / 2] + sorted[len / 2 - 1]) /2;
        }
        else {
            ans = (double) sorted[len / 2] /2;
        }
        return ans;

    }

}
