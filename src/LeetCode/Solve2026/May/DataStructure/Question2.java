package LeetCode.Solve2026.May.DataStructure;

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode((l1.val + l2.val) % 10);

        int upper = l1.val + l2.val >= 10 ? 1 : 0;
        l1 = l1.next;
        l2 = l2.next;
        ListNode tmp = res;
        while (true) {
            if (l1 == null && l2 == null) break;

            int num = upper;
            upper = 0;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }

            if (num >= 10) {
                upper++;
                num -= 10;
            }

            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }

        if (upper > 0) {
            tmp.next = new ListNode(1);
        }

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
