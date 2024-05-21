import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
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
}
