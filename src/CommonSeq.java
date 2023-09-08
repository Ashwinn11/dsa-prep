import java.util.*;
public class CommonSeq {
    public static void main(String[] args) {
        String text1 ="abc";
        String text2 ="abcde";
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i][j];
        for ( int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(helper(i-1,j-1,text1,text2,dp));
    }
    public static int helper(int i , int j , String one, String two,int[][]dp){
        if ( i<0 || j<0){
            return 0;
        }
        if (dp[i][j]!=-1) return dp[i][j];
        if (one.charAt(i)==two.charAt(j)){
            return dp[i][j]= 1+ helper(i-1,j-1,one,two,dp);
        }
        else {
            return dp[i][j]=Math.max(helper(i-1,j,one,two,dp),helper(i,j-1,one,two,dp));
        }
    }
}
