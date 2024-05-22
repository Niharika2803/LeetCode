import java.util.Scanner;

public class TwoSum2 {

    //T.C. = O(n), S.C. = O(1)
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int num_l;
        int num_r;

        while(l < r){
            num_l = numbers[l];
            num_r = numbers[r];

            if(num_l + num_r == target) {
                break;
            }

            if(num_l + num_r < target){
                l++;
            }
            if(num_l + num_r > target){
                r--;
            }
        }
        return new int [] {l+1, r+1};
    }





    // user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] numbers = new int[n];
        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();
        
        TwoSum2 solver = new TwoSum2();
        int[] result = solver.twoSum(numbers, target);
        
        System.out.println("The indices of the two numbers that add up to the target are: " + result[0] + ", " + result[1]);
    }
}
