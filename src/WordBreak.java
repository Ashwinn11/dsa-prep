import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        dict.add("l");
        System.out.println(wordbreak(s,dict));

    }
    public static List<List<String>> wordbreak(String s,List<String> dict ){
        List<List<String>> list = new ArrayList<>();
        List<String> val = new ArrayList<>();
        solve(0,list,dict,s,val);
        return list;
    }

    private static void solve(int i, List<List<String>> list, List<String> dict, String s,List<String> val) {
        if (i== s.length()){
            list.add(new ArrayList<>(val));
            return;
        }
        for ( int j =i;j<s.length();j++){
            if (dict.contains(s.substring(i,j+1))){
                val.add(s.substring(i,j+1));
                solve(j+1,list,dict,s,val);
                val.remove(val.size()-1);
            }
        }
    }
}
