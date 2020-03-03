package Top100;

public class longSubStringWithoutDuplicateWord {
    public int lengthOfLongestSubstring(String s) {
        // mark the frequency of each word
        int[] count = new int[1000];
        // sliding window left side;
        int left = 0;
        int max = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            count[ch[i]]++;
            while (left < i && count[ch[i]] > 1) {
                count[ch[left]]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
