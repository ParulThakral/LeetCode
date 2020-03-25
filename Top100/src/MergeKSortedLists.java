
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public static void main(String [] args){
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1, new ListNode(4,new ListNode(5, null)) );
        lists[0] = l1;
        ListNode l2 = new ListNode(1, new ListNode(3,new ListNode(4, null)) );
        ListNode l3 = new ListNode(2, new ListNode(6,null) );
        lists[1] = l2;
        lists[2] = l3;

        ListNode result = new MergeKSortedLists().mergeKLists(lists);
        System.out.println(result);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length==0){
            return null;
        }

        if (lists.length == 1){
            return lists[0];
        }

        ListNode resultList = mergeTwoLists(lists[0], lists[1]);
        for (int i=2; i<lists.length;i++){
            resultList = mergeTwoLists(resultList, lists[i]);
        }

        return resultList;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(1, null);

        ListNode head = new ListNode(1, null);
        head = dummyNode;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }
            else{
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        while(l1!=null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while(l2!=null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }

        return dummyNode.next;
    }
}