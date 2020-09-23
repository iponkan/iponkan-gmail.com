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
        String testcase = "abcda";
        String answer = solution.longestPalindrome(testcase);
        System.out.println(answer);
    }
}

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        // 长度为2情况
        String res = s.substring(0, 1);
        if (s.substring(0, 1).equals(s.substring(1, 2))) {
            res = s.substring(0, 2);
            System.out.println(res);
        }

        int maxLength = 0;

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 1; j < s.length(); j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;

    }
}
// @lc code=end
