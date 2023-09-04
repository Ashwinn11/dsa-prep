import java.util.*;
public class SubSet {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        int k =4;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        answer(0,list,arr,k,sub);
        System.out.println(list);
    }

    private static void answer(int i, List<List<Integer>> list, int[] arr, int k, List<Integer> sub) {
           if (k==0) {
                   list.add(new ArrayList<>(sub));
                   return;
           }
        for ( int j =i;j< arr.length;j++) {
            if (j!=i && arr[j]== arr[j-1]) continue;
            if (arr[j]> k) break;
            sub.add(arr[j]);
            answer(j + 1, list, arr, k - arr[j], sub);
            sub.remove(sub.size() - 1);
        }
    }
}
