package q003;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() < 2)
            return s.length();
        HashMap<Character, Integer> charIndexes = new HashMap<>();
        charIndexes.put(s.charAt(0), 0);
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charIndexes.containsKey(s.charAt(i))) {
                //当cache里面有了该char之后，hashmap不删除元素了，现在是取元素跟当前left的值比较，
                //取最右边的元素坐标
                left = Math.max(left, charIndexes.get(s.charAt(i)) + 1);
            }
            charIndexes.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
