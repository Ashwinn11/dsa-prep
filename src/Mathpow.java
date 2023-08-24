public class Mathpow {
    public static void main(String[] args) {
        double x =2;
        int n =-2;
        System.out.println(Math.pow(x,n));
        System.out.println(myPow(x,n));

    }
    public static double myPow(double x, int n) {
        double product = 1.0;
        long temp = n;
        if (temp<0) temp = -1* temp;
        while (temp>0){
            if ( temp %2 == 0){
                x*=x;
                temp = temp/2;
            }
            else {
                product*=x;
                temp-=1;
            }
        }
        if ( n<0) product = (double) (1.0)/(double)(product);
        return product;
    }
}
