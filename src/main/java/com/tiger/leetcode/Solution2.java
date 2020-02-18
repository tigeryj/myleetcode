package com.tiger.leetcode;

/**
 * @auther Jack
 * @date 2020/2/16 21:42
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 */

public class Solution2
{
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode run = head;
        while (l1 != null || l2 != null)
        {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + carry;

            run.next = new ListNode(sum % 10);

            run = run.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            carry = sum / 10;

        }
        if (carry == 1)
        {
            run.next = new ListNode(1);
        }
        return head.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int addition = 0;
        ListNode head = null;
        ListNode run = null;
        while (l1 != null || l2 != null)
        {
            int num = 0;
            if (l1 != null)
            {
                num += l1.val;
            }
            if (l2 != null)
            {
                num += l2.val;
            }

            num += addition;

            if (head == null)
            {
                head = new ListNode(num % 10);
                run = head;
            } else
            {
                run.next = new ListNode(num % 10);
                run = run.next;
            }

            if (num >= 10)
            {
                addition = 1;
            } else
            {
                addition = 0;
            }

            if (l1 != null)
            {
                l1 = l1.next;
            }
            if (l2 != null)
            {
                l2 = l2.next;
            }
        }
        if (addition > 0)
        {
            run.next = new ListNode(1);
        }

        return head;
    }

    public class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }
}
