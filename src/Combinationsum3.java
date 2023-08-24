import java.util.LinkedList;
import java.util.List;

public class Combinationsum3 {
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        int target = 45;
        int limit =9;
        bruteforce(1,list,ans,target, limit);
        System.out.println(list);
    }

    private static void bruteforce(int i, List<List<Integer>> list, List<Integer> ans, int target, int limit) {
        if (limit ==0){
            if (target == 0) {
                list.add(new LinkedList<>(ans));
            }
            return;
        }
            for (int j = i; j <=9; j++) {
                ans.add(j);
                bruteforce(j + 1, list, ans, target - j, limit - 1);
                ans.remove(ans.size() - 1);
            }

    }
}
