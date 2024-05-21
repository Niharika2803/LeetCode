import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        
        int ans = 1;
        for(int num : nums){
            set.add(num);
        }
        for(int num:nums){
            if(!set.contains(num-1)){
                int cnt = 1;
                while(set.contains(num+1)){
                    num++;
                    cnt++;
                }
                ans = Math.max(cnt, ans);
            }
        }
        return ans;
    }




    // user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arraySize = sc.nextInt();
        int[] nums = new int[arraySize];

        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < arraySize; i++) {
            nums[i] = sc.nextInt();
        }

        int result = longestConsecutive(nums);
        System.out.println("The longest consecutive sequence is of length: " + result);
    }
}
