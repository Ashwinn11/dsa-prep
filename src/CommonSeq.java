import java.util.*;
public class CommonSeq {
    public static void main(String[] args) {
        String text1 ="sea";
        String text2 ="eat";
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i+1][j+1];
        System.out.println(another(text1,text2,dp));
        for ( int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(helper(i,j,text1,text2,dp));
    }
    public static int helper(int i , int j , String one, String two,int[][]dp){
        if ( i==0 || j==0){
            return 0;
        }
        if (dp[i][j]!=-1) return dp[i][j];
        if (one.charAt(i-1)==two.charAt(j-1)){
            return dp[i][j]= 1+ helper(i-1,j-1,one,two,dp);
        }
        else {
            return dp[i][j]=Math.max(helper(i-1,j,one,two,dp),helper(i,j-1,one,two,dp));
        }
    }
    public static String another(String one,String two , int[][] dp){
        for ( int i =0 ;i<=two.length();i++){
            dp[0][i]=0;
        }
        for ( int i =0 ;i<=one.length();i++){
            dp[i][0]=0;
        }
        for ( int i =1;i<=one.length();i++){
            for ( int j =1;j<=two.length();j++){
                if(one.charAt(i-1)==two.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int length = dp[one.length()][two.length()];
        int i = one.length(), j = two.length();
        String ans = "";
        while(i>0 && j>0){
            if(one.charAt(i-1) == two.charAt(j-1)){
                ans+= one.charAt(i-1);
                i--;
                j--;
            }
            else if(one.charAt(i-1)> two.charAt(j-1)){
                i--;
            }
            else j--;
        }
        String reverse="";
        for ( int k =0;k<ans.length();k++){
            reverse =ans.charAt(k)+reverse;
        }
        return reverse;
    }

}
