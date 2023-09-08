import java.util.*;
public class Combination {
    public static void main(String[] args) {
        int[] arr ={0,0,1};
        int k =1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        answer(0,list,arr,k,sub);
        System.out.println(list);
    }
    private static void answer(int i, List<List<Integer>> list, int[] arr, int k, List<Integer> sub) {
        if (i==arr.length) {
            if (k==0) {
                list.add(new ArrayList<>(sub));
            }
            return;
        }
        sub.add(arr[i]);
        answer(i + 1, list, arr, k - arr[i], sub);
        sub.remove(sub.size()-1);
        answer(i+1,list,arr,k,sub);

    }
}
