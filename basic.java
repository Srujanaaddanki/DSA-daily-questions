class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // main method to test locally
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        Solution s = new Solution();
        ListNode rev = s.reverseList(n1);

        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
    }
}