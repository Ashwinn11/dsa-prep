import java.util.Arrays;
public class TargetSubset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target =5;
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        System.out.println(findWays(arr,target));
        for ( int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(answer(n-1,target,arr,dp));

    }
    public static int answer( int i, int target, int[] arr , int[][] dp){
        if(target==0)
            return 1;
        if(i == 0)
            return arr[0] == target?1:0;
        if (dp[i][target]!=-1) return dp[i][target];
        int not = answer(i-1,target,arr,dp);
        int taken =0;
        if (arr[i]<=target){
            taken = answer(i-1,target-arr[i],arr,dp);
        }
        dp[i][target]=taken + not;
        return dp[i][target];
    }
    public static int findWays(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for ( int i =0;i<n;i++){
            dp[i][0] = 1;
        }
        if ( num[0]<=tar){
            dp[0][num[0]] =1;
        }
        if ( num[0]<=tar){
            dp[0][num[0]] =1;
        }
        for ( int i =1;i<num.length;i++){
            for ( int k =1;k<=tar;k++){
                int not = dp[i-1][k];
                int taken =0;
                if (num[i]<=k){
                    taken = dp[i-1][k-num[i]];
                }
                dp[i][k] = taken +not;
            }
        }
        return dp[n-1][tar];
    }
}

