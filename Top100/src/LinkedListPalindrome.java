public class LinkedListPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void main(String [] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, null)));
        System.out.println(new LinkedListPalindrome().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // Traverse List till middle
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if(fastPointer!=null){
            slowPointer = slowPointer.next;
        }
        ListNode copyOfSlowPointer = slowPointer;
        ListNode reversedList = reverseList(slowPointer);
        copyOfSlowPointer = null;
        while (head != null && reversedList != null) {
            if (head.val != reversedList.val) {
                return false;
            }
            head = head.next;
            reversedList = reversedList.next;
        }

        return true;
    }




    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}