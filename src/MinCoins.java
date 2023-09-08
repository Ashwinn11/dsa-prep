import java.util.Arrays;

public class MinCoins {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int target =11;
        int[][] dp = new int[arr.length][target+1];
        System.out.println(tabulation(arr,dp,target));
        for ( int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(mincoins(arr.length-1,target,arr,dp));
        System.out.println(optimized(arr,dp,target));

    }
    public static int mincoins(int i , int target,int[] arr,int[][]dp){
        if ( i ==0){
            if (target%arr[0]==0){
                return target/arr[i];
            }
            else return (int)Math.pow(10,9);
        }
        if ( dp[i][target]!=-1){
            return dp[i][target];
        }
        int nottake = mincoins(i-1,target,arr,dp);
        int take = (int)Math.pow(10,9);
        if ( arr[i]<=target){
            take = 1+ mincoins(i,target-arr[i],arr,dp);
        }
        return dp[i][target]=Math.min(nottake,take);
    }
    public static int tabulation(int[] arr, int[][]dp , int target){
        for(int i=0; i<=target; i++){
            if(i%arr[0] == 0)
                dp[0][i] = i/arr[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }
        for ( int i =1;i<arr.length;i++){
            for ( int t =0;t<=target;t++){
                int nottake = dp[i-1][t];
                int take = Integer.MAX_VALUE;
                if (arr[i]<=t){
                    take = 1+dp[i][t-arr[i]];
                }
                dp[i][t] = Math.min(nottake,take);
            }
        }
        return dp[arr.length-1][target];
    }
    public static int optimized(int[] arr, int[][]dp , int target){
        int[] prev = new int[target+1];
        int[] cur = new int[target+1];
        for(int i=0; i<=target; i++){
            if(i%arr[0] == 0)
                prev[i] = i/arr[0];
            else prev[i] = (int)Math.pow(10,9);
        }
        for ( int i =1;i<arr.length;i++){
            for ( int t =0;t<=target;t++){
                int nottake = prev[t];
                int take = (int)Math.pow(10,9);
                if (arr[i]<=t){
                    take = 1+cur[t-arr[i]];
                }
                cur[t] = Math.min(nottake,take);
            }
            prev = cur;
        }
        return prev[target];
    }
}
