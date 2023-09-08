import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {3, 2, 5};
        int[] val = {30, 40, 60};
        int bag = 6;
        int n = weight.length;
        int[][] dp = new int[n][bag + 1];
        System.out.println(tabulation(bag, weight, val, dp));
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(unbounded(n - 1, bag, weight, val, dp));
    }

    private static int unbounded(int i, int bag, int[] weight, int[] value, int[][] dp) {
        if (i == 0) {
            return (bag / weight[0]) * value[0];
        }
        if (dp[i][bag] != -1) return dp[i][bag];
        int notTake = unbounded(i - 1, bag, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if (weight[i] <= bag) {
            take = value[i] + unbounded(i, bag - weight[i], weight, value, dp);
        }
        return dp[i][bag] = Math.max(notTake, take);
    }

    private static int tabulation(int bag, int[] weight, int[] val, int[][] dp) {
        for (int w = weight[0]; w <= bag; w++) {
            dp[0][w] = val[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int w = 0; w <= bag; w++) {
                int notTake = dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= w) {
                    take = val[i] + dp[i - 1][w - weight[i]];
                }
                dp[i][w] = Math.max(notTake, take);
            }
        }
        return dp[weight.length - 1][bag];
    }
}