public class MinCoins {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int target =11;
        System.out.println(mincoins(arr.length-1,target,arr));

    }
    public static int mincoins(int i , int target,int[] arr){
        if ( i ==0){
            if (target%arr[0]==0){
                return target/arr[i];
            }
            else return (int)Math.pow(10,9);
        }

        int nottake = mincoins(i-1,target,arr);
        int take = Integer.MAX_VALUE;
        if ( arr[i]<=target){
            take = 1+ mincoins(i,target-arr[i],arr);
        }
        return Math.min(nottake,take);
    }
}
