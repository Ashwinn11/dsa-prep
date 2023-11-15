class Pair{
    int height;
    int index;
    Pair(int height ,int index){
        this.height = height;
        this.index = index;
    }
}
public class LargestRectangle {
  public static void main(String[] args){
    int[] heights ={2,1,5,6,2,3};
    System.out.println(largestRectangleArea(heights));
  }
  public static int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack();
        int max =Integer.MIN_VALUE;
        for (int i =0;i<heights.length;i++){
            int start = i;
            while (!stack.isEmpty()&& stack.peek().height>heights[i]){
                    int height = stack.peek().height;
                    int index = stack.peek().index;
                    stack.pop();
                    max= Math.max(max,height*(i-index));
                    start =index;
            }
            stack.push(new Pair(heights[i],start));
        }
        while (!stack.isEmpty()){
            int height = stack.peek().height;
            int index = stack.peek().index;
            stack.pop();
            max = Math.max(max,height*(heights.length-index));
        }
        return max;
  }
    
}
