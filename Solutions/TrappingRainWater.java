import java.util.Scanner;

public class TrappingRainWater {


    // T.C. = O(n)
    // S.C. = O(1)
    public int trap(int[] heights) {
        if (heights.length == 0) return 0;
        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }
        return res;
    }





    // user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height values: ");
        String input = sc.nextLine();
        String[] strArray = input.split("\\s+");
        int[] heights = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            heights[i] = Integer.parseInt(strArray[i]);
        }

        TrappingRainWater tr = new TrappingRainWater();
        int result = tr.trap(heights);
        System.out.println("The trapped rainwater is: " + result);
    }
}