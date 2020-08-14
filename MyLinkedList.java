public class MyLinkedList {
    int count;
    private ListNode head;
    private ListNode tail;

    public int getCount() {
        return count;
    }


    /**
     * append value
     * @param val Value to add
     */
    public void add(String val){
        if (head == null){
            head = new ListNode(null, null, val);
            tail = head;
            count++;
            return;
        }

        tail.setNextNode( new ListNode( tail, null, val) );
        tail = tail.getNextNode();
        count++;
    }

    /**
     * Set value by index or append
     * @param index index of element to set new value
     * @param val value
     */
    public void set(int index, String val) throws IndexExceedsSizeLengthException {
        if (index > count) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s out of bounds (0..%s)", index, count));
        }

        if (index == count) {
            add(val);
            return;
        }
        getNode(index).setValue(val);
    }

    /**
     * Get value by index
     * @param index of element
     */
    public String get(int index){
        return getNode(index).getValue();
    }

    /**
     * Insert value before index
     */
    public void insert(int index, String value) throws IndexExceedsSizeLengthException {
        if (index > count && index < 0) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s out of bounds (0..%s)", index, count));
        }

        if (index == count) {
            add(value);
            return;
        }

        ListNode inserted;
        count++;

        if (index == 0) {
            inserted = new ListNode(value);
            head.setPrevNode(inserted);
            inserted.setNextNode(head);
            head = inserted;
            return;
        }

        ListNode prevNode = getNode(index - 1);
        ListNode nextNode = getNode(index);
        inserted = new ListNode(prevNode, nextNode, value);
        prevNode.setNextNode(inserted);
        nextNode.setPrevNode(inserted);
    }


    private ListNode getNode(int index){
        if ( index >= count || index <= 0 ) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s out of bounds (0..%s)", index, count - 1));
        }

        ListNode current;
        current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current;
    }

    /**
     * get new iterator
     */
    public Iterator getIterator(){
        return new Iterator();
    }

    private class ListNode{
        private ListNode prevNode;
        private ListNode nextNode;
        private String value;

        private ListNode(ListNode prevNode, ListNode nextNode, String value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        private ListNode(String value){
            this.value = value;
        }

        private String getValue() {
            return value;
        }

        private void setValue(String value) {
            this.value = value;
        }

        private ListNode getPrevNode() {
            return prevNode;
        }

        private void setPrevNode(ListNode prevNode) {
            this.prevNode = prevNode;
        }

        private ListNode getNextNode() {
            return nextNode;
        }

        private void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    public class Iterator{
        ListNode current;
        ListNode startNode = head;

        public Iterator(ListNode current) {
            this.current = current;
        }

        private Iterator(){
        }

        public void reset(){
            current = null;
            startNode = head;
        }

        public boolean hasNext(){
            if (head == null) return false;
            if ((current == null) && (startNode == head)) return true;
            return !(current == null);
        }

        public boolean hasPrev(){
            if (head == null) return false;
            if ((current == null) && (startNode == tail)) return true;
            return !(current == null);
        }

        public String getNext(){
            if (current == null && startNode == head) current = head;
            String value = current.getValue();
            current = current.getNextNode();
            if (current == null) startNode = tail;
            return value;
        }

        public String getPrev(){
            if (current == null && startNode == tail) current = tail;
            String value = current.getValue();
            current = current.getPrevNode();
            if (current == null) startNode = head;
            return value;
        }



    }

}
