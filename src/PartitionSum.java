import java.util.*;
public class PartitionSum {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        int target = 20/2;
        Set<List<Integer>> list = new HashSet<>();
        answer(arr.length-1,arr,target,list,new ArrayList<>());
        System.out.println(list);

    }
    public static void answer (int i ,int[] arr , int target , Set<List<Integer>> list ,List<Integer> ans){
        if(i<0) {
            if(target ==0) list.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        answer(i-1,arr,target-arr[i],list,ans);
        ans.remove(ans.size()-1);
        answer(i-1,arr,target,list,ans);

    }

}
