import java.util.Scanner;

public class TrappingRainWater {

    //Approach 1:    T.C. = O(n), S.C. = O(1)
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


    /*  
    Approach 2:    T.C. = O(n), S.C. = O(n)
    
    public int trap(int[] heights) {
        int left[] = new int[heights.length], right[] = new int[heights.length], max = heights[0], c = 0;

        for (int i = 0; i < heights.length; i++) {
            left[i] = Math.max(heights[i], max);
            max = left[i];
        }

        max = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            right[i] = Math.max(heights[i], max);
            max = right[i];
        }

        for (int i = 0; i < heights.length; i++) {
            c = c + Math.min(left[i], right[i]) - heights[i];
        }
        return c;
    }

    */





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