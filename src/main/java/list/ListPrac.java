package list;

public class ListPrac {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4, 5};
        ListNode head = create(arr);
        ListNode head1 = create(arr1);
        ListNode head2 = create(arr2);
        traverse(head);
//		reverseList(head);
//        traverse(reverseList(head));
        ListNode node = mergeTwoLists(head1, head2);
        traverse(node);
        traverse(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用头结点简化操作
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        length -= n;
        node = dump;
        while (length > 0) {
            node = node.next;
            length--;
        }
        node.next = node.next.next;
        return dump.next;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode node;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    /**
     * @param arr
     * @return
     */
    public static ListNode create(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }
}
