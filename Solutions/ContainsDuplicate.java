import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {

    //main logic
    public static boolean containsDuplicate(int[] nums) {

        //Approach 1: Hashset 
        // T.C. = O(n), S.C = O(n)
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(visited.contains(nums[i])){
                return true;
            }
            visited.add(nums[i]);
        }
        return false;

        /* 
        Approach 2: Sorting 
        T.C. = O(n log n), S.C = O(1)

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
        */
    }







    // user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        System.out.println("Please enter " + size + " elements of the array:");

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            int nextNum = sc.nextInt();
            nums[i] = nextNum;
        }

        boolean hasDuplicate = containsDuplicate(nums);
        if (hasDuplicate) {
            System.out.println("The array contains duplicate elements.");
        } else {
            System.out.println("The array does not contain duplicate elements.");
        }
    }
}