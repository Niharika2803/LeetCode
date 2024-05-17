import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        //base case
        if(strs.length == 0){
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            int[] hash = new int [26];

            //count occ of each char in string
            for(char c : s.toCharArray()){
                hash[c - 'a']++;
            }

            //convert the hash array to a string to use as key in map
            String key = new String(Arrays.toString(hash));

            //computeIfAbsent method will use the pre-existing list, else it'll create a new list
            map.computeIfAbsent(key, k -> new ArrayList<>());

            map.get(key).add(s); // add orig string to the list associated with the key
        }
        
        res.addAll(map.values());

        return res;



        /* Approach 2:

        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if (!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(word);
        }
        return new ArrayList<>(map.values());

         */
    }



    // user inputs
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print("Enter the number of strings:");
            int numStrings = scanner.nextInt();
            String[] strs = new String[numStrings];
            for (int i = 0; i < numStrings; i++) {
                System.out.print("Enter string " + (i+1) + ":");
                strs[i] = scanner.next();
            }
            GroupAnagrams solution = new GroupAnagrams();
            List<List<String>> result = solution.groupAnagrams(strs);
            result.forEach(group -> System.out.print(group));
        } catch (Exception e) {
            System.err.print("Error reading input: " + e.getMessage());
        } finally {
            if (scanner!= null) {
                scanner.close();
            }
        }
    }
}
