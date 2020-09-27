package q707;
/**
* @Description: leetcode 707
* @Params:
* @Create: 2020/9/3 15:13
* @Return:
*/
class MyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
    }

    int size;
    ListNode head;
    ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        int i = 0;
        ListNode temp = head;
        while (temp != null && i != index) {
            temp = temp.next;
            i++;
        }
        return temp == null ? -1 : temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0) {
            head = new ListNode();
            head.val = val;
            tail = head;
        } else {
            ListNode temp = new ListNode();
            temp.val = val;
            temp.next = head;
            head = temp;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            head = new ListNode();
            head.val = val;
            tail = head;
        } else {
            ListNode temp = new ListNode();
            temp.val = val;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            int i = 1;
            ListNode temp = head;
            while (i < index) {
                i++;
                temp = temp.next;
            }
            ListNode next = temp.next;
            ListNode newNode = new ListNode();
            newNode.val = val;
            temp.next = newNode;
            newNode.next = next;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else {
            ListNode pre = head;
            ListNode target = head.next;
            int i = 1;
            while (i < index) {
                i++;
                pre = pre.next;
                target = target.next;
            }
            if (target == tail) {
                tail = pre;
            } else {
                pre.next = target.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
    }
}
