import java.util.*;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        // Approach 1: Single Pass
        // T.C. = O(n), S.C. = O(1)
        int[] arr = new int[nums.length];
        int r = 1;
        int l = 1;
        for (int i = 0; i < nums.length; i++){
            arr[i] = l;
            l *= nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            arr[i] *= r;
            r *= nums[i];
        }

        return arr;



        /*  Approach 2: Double Pass
            T.C. = O(n), S.C. = O(n)
        
        int[] output = new int[nums.length];
        output[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) output[i + 1] =
            output[i] * nums[i];

        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = nums[i + 1] * output[i];
            nums[i] = nums[i] * nums[i + 1];
        }
        return output;

         */
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        
        int[] nums = new int[size];
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        
        System.out.println("The product of each element with all others except itself is:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
