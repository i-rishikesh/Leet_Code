class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            
            carry = temp / 10;
            cur.next = new ListNode(temp % 10);
            
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int temp = l1.val + carry;
            
            carry = temp / 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int temp = l2.val + carry;
            
            carry = temp / 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}