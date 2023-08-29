import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        int[] height = {30,10,60 , 10 , 60 , 50};
        int n = height.length;
        int k =2;
        System.out.println(minimizeCost(n,k,height));
    }
    public static int minimizeCost(int n, int k, int []height){
        int[] dp = new int [n];
        Arrays.fill(dp,-1);
        return answer(n-1,k,dp,height);
    }
    public static int answer( int n , int k , int[] dp , int[] height){
        if ( n ==0) return n;
        if (dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for ( int j = 1;j<=k;j++){
            if (n-j>=0) {
                int jump = answer(n - j, k, dp, height) + Math.abs(height[n] - height[n - j]);
                min = Math.min(jump,min);
            }
        }
        return dp[n]=min;

    }


}
