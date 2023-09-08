import java.util.*;
public class Sub {
    public static void main(String[] args) {
        String s = "001";
        System.out.println(generateSubsequences(s));
    }
    public static List<String> generateSubsequences(String s) {
        List<String> ans = new ArrayList<>();
        String res ="";
        generation(0,ans,s,res);
        return ans;

    }
    public static void generation(int i, List<String> ans, String s , String res){
        if ( i == s.length()){
            ans.add(res);
            return;
        }
        generation(i+1,ans,s,res+(s.charAt(i)));
        generation(i+1,ans,s,res);
    }
}
