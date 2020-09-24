import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (35.49%)
 * Likes:    4221
 * Dislikes: 0
 * Total Accepted:    628.5K
 * Total Submissions: 1.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

class Main {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final String testcase = "abcabcbb";
        final int answer = solution.lengthOfLongestSubstring(testcase);
        System.out.printf("%d \n", answer);
    }
}

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(final String s) {
        int maxLength = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hashSet.clear();
            hashSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!hashSet.add(s.charAt(j))) {
                    break;
                }
            }
            if (hashSet.size() > maxLength) {
                maxLength = hashSet.size();
            }
        }

        return maxLength;
    }
}
// @lc code=end
