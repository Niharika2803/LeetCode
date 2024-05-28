import java.util.Scanner;

public class ContainerWithMostWater {
    // T.C. = O(n)
    // S.C. = O(1)
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);

            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }




    //user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of containers: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.print("Enter the heights of the containers: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println("The maximum water that can be stored is " + maxArea(height));
    }
}