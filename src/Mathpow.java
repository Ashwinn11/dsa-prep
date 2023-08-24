public class Mathpow {
    public static void main(String[] args) {
        double x =1;
        int n =10;
        System.out.println(Math.pow(x,n));
        System.out.println(myPow(x,n));

    }
    public static double myPow(double x, int n) {
        double product = 1;
        return solution(product,x,n);
    }
    public static double solution(double product , double x , int n){
        if(n==1) return x;
        product = x * solution(product,x,n-1);
        return product;
    }
}
