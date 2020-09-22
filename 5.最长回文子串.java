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
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        String testCase = "cbbd";
        // Get the answer
        String answer = solution.longestPalindrome(testCase);
        // Print the answer
        System.out.println(answer);
    }
}

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int i = 0;
        int j = s.length();

        String str1 = "";

        while (i < j) {
            if (isPalindrome(s.substring(i, j))) {
                str1 = s.substring(i, j);
                break;
            } else {
                j--;
                continue;
            }
        }

        i = 0;
        j = s.length();

        String str2 = "";

        while (i < j) {
            if (isPalindrome(s.substring(i, j))) {
                str2 = s.substring(i, j);
                break;
            } else {
                i++;
                continue;
            }
        }

        String str3 = "";

        i = 0;
        j = s.length();

        boolean step1 = false;

        while (i < j) {
            if (isPalindrome(s.substring(i, j))) {
                str3 = s.substring(i, j);
                break;
            } else if (!step1) {
                j--;
                step1 = true;
                continue;
            } else if (step1) {
                i++;
                step1 = false;
                continue;
            }
        }

        if (str1.length() >= str2.length() && str1.length() >= str3.length()) {
            return str1;
        }

        if (str2.length() >= str1.length() && str2.length() >= str3.length()) {
            return str2;
        }

        if (str3.length() >= str1.length() && str3.length() >= str2.length()) {
            return str3;
        }

        return "";
    }

    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
