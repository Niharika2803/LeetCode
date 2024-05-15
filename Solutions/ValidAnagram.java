import java.util.Scanner;
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        //Approach 1: Hashmaps
        //T.C. = O(S+T); S.C. = O(S+T)

        if (s.length()!= t.length()){
            return false;
        }

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n!= 0) return false;

        return true;

        /* Approach 2: Sorting 

        char[] s1 = s.toCharArray();
        char[] t2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t2);
        return Arrays.equals(s1, t2);

        */
    }



    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the first string:");
            String s = sc.nextLine();

            System.out.println("Enter the second string:");
            String t = sc.nextLine();

            ValidAnagram validAnagram = new ValidAnagram();
            boolean result = validAnagram.isAnagram(s, t);
            System.out.println(result? "The strings are anagrams." : "The strings are not anagrams.");
        }
        
    }
}
