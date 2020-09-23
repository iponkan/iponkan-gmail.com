/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (31.64%)
 * Likes:    2706
 * Dislikes: 0
 * Total Accepted:    382.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testcase = "abba";
        String answer = solution.longestPalindrome(testcase);
        System.out.println(answer);
    }
}

// @lc code=start
class Solution {

    private String result = "";
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            this.diffusion(s, i, i);
            this.diffusion(s, i, i + 1);
        }

        return result;
    }

    private void diffusion(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                result = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
}
// @lc code=end
