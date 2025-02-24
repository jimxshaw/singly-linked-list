public class IDedLinkedList<T extends IDedObject> {
    private final Link<T> sentinel;

    IDedLinkedList() {
        // The sentinel's ID should not conflict with an actual Link's ID.
        this.sentinel = new Link<>(Integer.MIN_VALUE, null, null);
    }

    // TODO: Implement the class methods.
//    public void makeEmpty() {}

//    public T findID(int ID) {}

//    public boolean insertAtFront(T type) {}

//    T deleteFromFront() {}

//    int printTotal() {}

    private static class Link<T> {
        int ID;
        Link<T> next;
        T data;

        Link(int ID, Link<T> next, T data) {
            this.ID = ID;
            this.next = next;
            this.data = data;
        }
    }
}
