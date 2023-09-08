public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target =1;
        System.out.println(answer(arr.length-1,target,arr));
    }

    private static int answer(int i, int target, int[] arr) {
        if(i ==  0){
            if(target==0 && arr[0]==0)return 2;
            if (target ==0) return 1;
            return 0;
        }
        int not = answer(i-1,target,arr);
        int take =0;
         if (arr[i]<=target){
             take = answer(i-1,target-arr[i],arr);
         }
         return not+take;
    }
}
