import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int n = arr.length;
        int target =5;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        coinchange(n-1,arr,ans,list,target);
        System.out.println(ans);
        System.out.println(findways(n-1,arr,target));
    }

    private static void coinchange(int i, int[] arr, List<List<Integer>> ans, List<Integer> list,int target) {
        if (i<0){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        coinchange(i-1,arr,ans,list,target);
        if(arr[i]<=target) {
            list.add(arr[i]);
            coinchange(i, arr, ans, list, target - arr[i]);
            list.remove(list.size()-1);
        }
    }
    private static int findways(int i ,int[] arr, int target){
        if ( i ==0){
            return target%arr[0]==0?1:0;
        }
        int not = findways(i-1,arr,target);
        int take =0;
        if (arr[i]<=target){
            take = findways(i,arr,target-arr[i]);
        }
        return not+take;
    }
}