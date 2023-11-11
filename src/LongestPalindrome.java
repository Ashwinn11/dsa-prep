public class LongestPalindrome {
    public static void main(String[] args) {
        String input = "ashhwin";
        String result = longestPalindrome(input);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        if (s.length()<=1) return s;
        String result = s.substring(0,1);
        for (int i =0 ;i<s.length()-1;i++){
            String odd = palindrome(s,i,i);
            String even = palindrome (s,i,i+1);
            if (odd.length()>result.length()){
                result = odd;
            }
            if(even.length()>result.length()){
                result = even;
            }
        }
        return result;
    }
    public static String palindrome(String s , int left , int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right++;
        }
        return s.substring(left+1,right);
    }

}
