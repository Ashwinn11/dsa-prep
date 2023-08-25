import java.util.ArrayList;
import java.util.List;

public class Subarray {
    public static void main(String[] args) {
        int[] a = {1,2,3,1,1,1};
        long k = 3;
        System.out.println(subarraysWithSumK(a,k));

    }
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        List<List<Integer>> ans = new ArrayList<>();
        for ( int i =0;i<a.length;i++){
            List<Integer> list = new ArrayList<>();
            long res =0;
            for ( int j =i;j<a.length;j++){
                res+=a[j];
                list.add(a[j]);
                if (res==k) {
                    ans.add(new ArrayList<>(list));
                }
                if (res>k) break;
            }
        }
        return ans;
    }
}

