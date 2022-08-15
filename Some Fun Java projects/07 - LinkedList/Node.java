public class Node<E> {
    //variables
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this(data, null);
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public E setData(E data) {
        return this.data = data;
    }

    public Node<E> setNext(Node<E> next) {
        return this.next = next;
    }


}
