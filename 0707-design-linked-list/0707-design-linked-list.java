class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    ListNode dummy;
    int size;
    public MyLinkedList() {
        dummy = new ListNode(-1);
        size = 0;
    }
    
    public int get(int index) {
        if (index >= size) return -1;
        ListNode curr = dummy.next;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return; //index == size is allowed, node at size index is null
        ListNode prev = dummy, curr = dummy.next;
        for (int i = 0 ; i < index; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        ListNode node = new ListNode(val);
        prev.next = node;
        node.next = curr;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        ListNode prev = dummy, curr = dummy.next;
        for (int i = 0 ; i < index; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */