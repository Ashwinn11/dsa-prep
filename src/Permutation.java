import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        permutation(list,ans,arr,freq);
        System.out.println(ans);
    }

    private static void permutation(List<Integer> list, List<List<Integer>> ans, int[] arr,boolean[] freq) {
        if ( list.size() ==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
       for ( int i =0; i<arr.length;i++){
            if (!freq[i]) {
                freq[i] = true;
                list.add(arr[i]);
                permutation(list, ans, arr, freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}
