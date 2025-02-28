public class IDedLinkedList<T extends IDedObject> {
    private final Link<T> sentinel;

    IDedLinkedList() {
        // The sentinel's ID should not conflict with an actual Link's ID.
        this.sentinel = new Link<>(Integer.MIN_VALUE, null, null);
    }

    public void makeEmpty() {
        // Cut off the connection between the
        // sentinel and the first link.
        sentinel.next = null;
    }

    public T findID(int ID) {
        // We always start at first link after the sentinel.
        Link<T> currentLink = sentinel.next;

        // As long as current link exists and the ID doesn't match
        // then we keep going to the next link and do the ID check again.
        while (currentLink != null && currentLink.ID != ID) {
            // The end of the list will mark current link as null.
            currentLink = currentLink.next;
        }

        // We need to check if current link exists or not again in order
        // to differentiate between actually finding the ID (do exist) or
        // reaching the end of the list (doesn't exist).
        if (currentLink != null) {
            return currentLink.data;
        } else {
            return null;
        }
    }

//    public boolean insertAtFront(T type) {}

    T deleteFromFront() {
        if (sentinel.next == null) {
            return null;
        }

        // The second link becomes the new first link.
        // The old first link will be garbage collected.
        Link<T> firstLink = sentinel.next;
        sentinel.next = firstLink.next;

        return firstLink.data;
    }

    int printTotal() {
        if (sentinel.next == null) {
            return -1;
        }

        int sum = 0;
        Link<T> currentLink = sentinel.next;

        // As long as current link exists, add its
        // ID value to the running total.
        while (currentLink != null) {
            sum += currentLink.ID;
            currentLink = currentLink.next;
        }

        return sum;
    }

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
