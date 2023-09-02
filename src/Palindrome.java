import java.util.ArrayList;
import java.util.*;

public class Palindrome{
    public static void main(String[] args) {
        String value = "aaaa";
        List<List<String>> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        solve(0,res,list,value);
        System.out.println(list);
    }
        public static void solve(int i,List<String> res, List<List<String>> list , String value){
            if ( i==value.length()){
                list.add(new ArrayList<>(res));
                return;
            }
            for ( int j=i;j<value.length();j++){
                if ( isValid(i,j,value)){
                    res.add(value.substring(i,j+1));
                    solve(j+1,res,list,value);
                    res.remove(res.size()-1);
                }
            }
        }
        public static boolean isValid(int i , int j , String value){
            while (i<=j){
                if (value.charAt(i++)!= value.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
}