
/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (46.22%)
 * Likes:    277
 * Dislikes: 0
 * Total Accepted:    163.6K
 * Total Submissions: 352.8K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */

class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        String testCase = "tenet";
        // Get the answer
        boolean answer = solution.isPalindrome(testCase);
        // Print the answer
        System.out.println(answer);
    }
}

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        s = s.toLowerCase();
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

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
