import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = {{10,40,70},
                {20,50,80},
                {30,60,90}};
        int n = arr.length;
        int[][] dp = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(max(arr,n-1,3,dp));

    }
    public static int max(int[][] arr , int day , int last ,int[][]dp){
        if (dp[day][last] != -1) return dp[day][last];
        if (day ==0){
           int max =0;
            for ( int i =0;i<arr[0].length;i++){
                if (i!=last) {
                    max = Math.max(arr[day][i],max);
                }
            }
            return dp[day][last]=max;
        }
        int max =0;
        for ( int i =0;i<arr[0].length;i++){
            if (i!=last){
                int activity = arr[day][i] + max(arr,day-1,i,dp);
                max = Math.max(activity,max);
            }
        }
        return dp[day][last]=max;

    }
}
