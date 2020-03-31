//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself.
//
// Example:
//
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
//
// Related Topics Linked List Math


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    if (l1 === null || l2 === null) return null

    // 使用dummyHead可以简化对链表的处理，dummyHead.next指向新链表
    let dummyHead = new ListNode(0)
    let cur1 = l1
    let cur2 = l2
    let cur = dummyHead // cur用于计算新链表
    let carry = 0 // 进位标志

    while (cur1 !== null || cur2 !== null) {
        let val1 = cur1 !== null ? cur1.val : 0
        let val2 = cur2 !== null ? cur2.val : 0
        let sum = val1 + val2 + carry
        let newNode = new ListNode(sum % 10) // sum%10取模结果范围为0~9，即为当前节点的值
        carry = sum >= 10 ? 1 : 0 // sum>=10，carry=1，表示有进位
        cur.next = newNode
        cur = cur.next

        if (cur1 !== null) {
            cur1 = cur1.next
        }

        if (cur2 !== null) {
            cur2 = cur2.next
        }
    }

    if (carry > 0) {
        // 如果最后还有进位，新加一个节点
        cur.next = new ListNode(carry)
    }

    return dummyHead.next
};
//leetcode submit region end(Prohibit modification and deletion)

require('../util');

const l1 = getListFromArray([2, 4, 3])

const l2 = getListFromArray([5, 6, 4])

logList(addTwoNumbers(l1, l2))
