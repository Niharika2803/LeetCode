import java.util.*;

public class TopKFrequentElements {

        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> count = new HashMap<>();
    
            List<Integer>[] bucket = new ArrayList[nums.length + 1];
            for(int n : nums){
                count.merge(n, 1, Integer::sum);
                //(Integer::sum is a lambda expression)
            }
    
            for(int key : count.keySet()){
                int freq = count.get(key);
                if(bucket[freq] == null){
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }
    
            int idx = 0;
            int res[] = new int[k];
    
            for(int i=nums.length; i>=0; i--){
                if(bucket[i] != null){
                    for(int val:bucket[i]){
                        res[idx++] = val;
                        if(idx == k){
                            return res;
                        }
                    }
                }
            }
            return res;
        }
    }