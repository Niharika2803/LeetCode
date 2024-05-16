import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Approach 1: Hashmap
        // T.C. = O(n), S.C. = O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(curr, i);
            }
        }
        return new int[]{};




        /* Approach 2: Brute Force
           T.C. = O(n^2)

        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        */
    }




    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the size of the array:");
            int n = sc.nextInt();
            int[] nums = new int[n];

            System.out.print("Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.print("Enter the target sum:");
            int target = sc.nextInt();

            int[] result = twoSum(nums, target);
            if (result.length == 0) {
                System.out.println("No pair found.");
            } else {
                System.out.println("Pair found at indices: " + result[0] + ", " + result[1]);
            }
        }
    }
}
