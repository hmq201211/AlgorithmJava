package q001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return null;
        Map<Integer, Integer> cache = new HashMap<>();
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                toReturn[0] = cache.get(target - nums[i]);
                toReturn[1] = i;
                return toReturn;
            } else {
                cache.put(nums[i], i);
            }
        }
        return toReturn;
    }
}
