public class IDedLinkedList<T extends IDedObject> {
    // I've decided to use a sentinel in my Linked List
    // in order to simplify error handling.
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

    public boolean insertAtFront(T type) {
        // The item already exists.
        if (findID(type.getID()) != null) {
            return false;
        }

        // If the item doesn't exist then instantiate a link by assigning
        // its next link as the old first link. Make sure the sentinel's next
        // link points to this new first link.
        Link<T> oldFirstLink = sentinel.next;
        sentinel.next = new Link<>(type.getID(), oldFirstLink, type);

        return true;
    }

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

    public T delete(int ID) {
        // See if the list is empty.
        if (sentinel.next == null) {
            return null;
        }

        // Start at the sentinel because there's a possibility
        // the item to be deleted is the first link after sentinel.
        Link<T> currentLink = sentinel;

        while (currentLink.next != null) {
            if (currentLink.next.ID == ID) {
                T deletedItem = currentLink.next.data;

                // Sentinel -> A -> B becomes Sentinel -> B.
                // A is considered "deleted" and will be
                // garbage collected later.
                currentLink.next = currentLink.next.next;

                return deletedItem;
            }

            // Move on to the next link.
            currentLink = currentLink.next;
        }

        // The item doesn't exist.
        return null;
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

    // A Linked List is made of "nodes". A Link is what I decided to
    // call my "nodes". My Linked List is made of "links" like with a chain.
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
