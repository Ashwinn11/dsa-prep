import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {3,2,5};
        int[] val = {30,40,60};
        int bag = 6;
        int n = weight.length;
        int ans =solution(weight.length-1,bag,weight,val);
        System.out.println(ans);
        int[][] dp = new int[n][bag+1];
        for ( int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(optimized(n-1,bag,weight,val,dp));
        System.out.println(tabulation(bag,weight,val,dp));

    }

    private static int tabulation(int bag, int[] weight, int[] val, int[][] dp) {
        for ( int w =weight[0];w<=bag;w++){
            dp[0][w] = val[0];
        }
        for ( int i =1;i< weight.length;i++){
            for ( int w =0;w<=bag;w++){
                int notTake = dp[i-1][w];
                int take = Integer.MIN_VALUE;
                if (weight[i]<=w){
                    take = val[i]+dp[i-1][w-weight[i]];
                }
                dp[i][w]= Math.max(notTake,take);
            }
        }
        return dp[weight.length-1][bag];
    }

    private static int solution(int i, int bag,int[] weight , int [] value) {
            if ( i==0){
                if (weight[0]<=bag) return value[0];
                return 0;
            }
            int notTake = solution(i-1,bag,weight,value);
            int take = Integer.MIN_VALUE;
            if (weight[i]<=bag){
                take = value[i]+solution(i-1,bag-weight[i],weight,value);
            }
            return Math.max(notTake,take);

        }
        private static int optimized(int i, int bag, int[] weight , int[] value , int[][]dp){
            if ( i==0){
                if (weight[0]<=bag) return value[0];
                return 0;
            }
            if (dp[i][bag]!=-1) return dp[i][bag];
            int notTake = solution(i-1,bag,weight,value);
            int take = Integer.MIN_VALUE;
            if (weight[i]<=bag){
                take = value[i]+solution(i-1,bag-weight[i],weight,value);
            }
            return dp[i][bag]=Math.max(notTake,take);
        }

}
