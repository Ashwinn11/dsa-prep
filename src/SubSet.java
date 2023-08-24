import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSet {
        public static void main(String[] args) {
            int[] arr = {1,2,3};
            List<Integer> list = new ArrayList<>();
            recursion(0,arr,0 , list);
            Collections.sort(list);
            System.out.println(list);
        }
        private static void recursion(int i, int[] arr,int sum, List<Integer> list) {
            if (i == arr.length){
                list.add(sum);
                return;
            }
            recursion(i+1,arr,sum+arr[i],list);
            recursion(i+1,arr,sum,list);
        }
}
