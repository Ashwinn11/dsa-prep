import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(0,arr,ans , list);
        System.out.println(ans);
    }
    private static void recursion(int i, int[] arr, List<List<Integer>> ans, List<Integer> list) {
        if (i == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        recursion(i+1,arr,ans,list);
        list.remove(list.size()-1);
        recursion(i+1,arr,ans,list);
    }
}