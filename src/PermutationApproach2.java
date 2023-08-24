import java.util.ArrayList;
import java.util.List;
public class PermutationApproach2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        approach(0 , arr, list );
        System.out.println(list);
    }
    public static void approach(int i ,int[] arr, List<List<Integer>> list){
        if ( i == arr.length){
            List<Integer> ans = new ArrayList<>();
            for (int val : arr){
                ans.add(val);
            }
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(i,j,arr);
            approach(i+1,arr,list);
            swap(i,j,arr);
        }
    }

    private static void swap(int i, int j,int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}






