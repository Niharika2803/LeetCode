import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    // Approach: Sort + 2 pointers approach
    // T.C. = O(n^2), S.C. = O(n)   
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> solutions = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Only consider non-duplicate elements for i
            if (i == 0 || (i > 0 && nums[i]!= nums[i - 1])) { // Check for duplicates
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right]; // Calculate sum of current pair
                    
                    if (sum == target) {
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[left]);
                        solution.add(nums[right]);
                        
                        solutions.add(solution);
                        
                        // Skip duplicate values on both sides
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return solutions;
    }





    // user inputs
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Three Sum combinations: " + ts.threeSum(nums));
    }
}