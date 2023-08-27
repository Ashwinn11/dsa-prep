import java.util.*;

public class Rough {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(0,list,ans,arr);
        System.out.println(list);
    }

    private static void solve(int i, List<List<Integer>> list, List<Integer> ans, int[] arr) {
        if (i==arr.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        //for ( int j =i;j<arr.length;j++) {

            ans.add(arr[i]);
            solve(i + 1, list, ans, arr);
            ans.remove(ans.size() - 1);
       // }
        solve(i+1,list,ans,arr);
    }
}