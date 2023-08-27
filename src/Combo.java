import java.util.*;
public class Combo {
    public static void main(String[] args) {
        String digits ="23";
        System.out.println(letterCombinations(digits));
    }
    public  static List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        String res = "";
        solve(0,map,digits,res,ans);
        return ans;
    }
    public static void solve(int i, Map<Integer,String> map , String digits, String res,List<String> ans){
        if (i == digits.length()){
            ans.add(res);
            return;
        }

        String val = map.get(digits.charAt(i) - '0');
        for ( int j=0;j<val.length();j++){
            solve(i+1,map,digits,res.concat(String.valueOf(val.charAt(j))),ans);
        }
    }
}