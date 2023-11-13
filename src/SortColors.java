import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,1,0,0,1,2};
        dutchFlag(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void dutchFlag(int[] nums) {
        int low =0;
        int mid =0;
        int high = nums.length-1;
        while (mid<=high){
            if (nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            }
            else if (nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
            else {
              mid++;
            }
        }

    }
    private static void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }

}
