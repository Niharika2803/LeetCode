import java.util.Scanner;

class ValidPalindrome {

    //T.C. = O(n), S.C. = O(1)
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            Character start = s.charAt(i);
            Character end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }

            if (Character.toLowerCase(start)!= Character.toLowerCase(end)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }





    // user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();
        
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean isPalindrome = validPalindrome.isPalindrome(userInput);
        
        System.out.print(isPalindrome? "The string is a palindrome." : "The string is not a palindrome.");
    }
}
