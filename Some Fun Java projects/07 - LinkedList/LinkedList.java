import java.util.NoSuchElementException;

import javax.lang.model.type.NullType;

public class LinkedList<E> implements List<E> {
    // variables
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // methods
    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void addAtIndex(E data, int index) {
        if (data == null || index > size || index < 0) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        // create this node
        Node<E> node = new Node<E>(data);

        if (isEmpty()) {
            head = node;
            tail = node;
            size++;
        } else if (index == 0) {
            node.setNext(head);
            head = node;
            size++;
        } else if (index == size) {
            tail.setNext(node);
            tail = node;
            size++;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<E> temp = current.getNext();
            current.setNext(node);
            node.setNext(temp);
            size++;
        }
    }

    public E getAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (index == 0) {
            return head.getData();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public E removeAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        // if (isEmpty()) {
        // return null;
        // }
        else if (this.head == this.tail) {
            Node<E> temp = head;
            this.head = null;
            this.tail = null;
            size = 0;
            return temp.getData();
        } else if (index == 0) {
            Node<E> temp = head;
            this.head = head.getNext();
            size--;
            return temp.getData();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<E> temp = current.getNext();
            if (current.getNext().getNext() == null) {
                this.tail = current;
                current.setNext(null);
                size--;
                return temp.getData();
            } else {
                current.setNext(current.getNext().getNext());
                size--;
                return temp.getData();
            }
        }
    }

    public E remove(E data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        Node<E> curr = head;
        int index = 0;
        boolean found = false;

        while ((curr != null) && (!found)) {
            if (data.equals(curr.getData())) {
                found = true;
            } else {
                curr = curr.getNext();
                index++;
            }       
        }

        if (found == false) {
            throw new NoSuchElementException("The data is not present in the list.");
        }
        return removeAtIndex(index);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void toShow() {
        Node<E> temp = head;
        String result = "";
        while (temp != null) {
            result = result + temp.getData() + "\n";
            temp = temp.getNext();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        LinkedList<String> test = new LinkedList<>();
        System.out.println(test.isEmpty());
        test.addAtIndex("first item", 0);
        System.out.println(test.isEmpty());
        // System.out.println(test.getHead().getData());
        test.addAtIndex("second item", 1);
        test.addAtIndex("third item", 2);
        test.addAtIndex("4th item", 2);
        System.out.println("size: " + test.size());
        test.toShow();
        System.out.println("-------");
        // test.getAtIndex(0).getData();
        System.out.println(test.getAtIndex(0));
        System.out.println(test.getAtIndex(1));
        System.out.println(test.getAtIndex(2));
        System.out.println(test.getAtIndex(3));

        System.out.println("-------");
        test.remove("first item");
        test.toShow();
        System.out.println("-------");
        test.remove("third item");
        System.out.println(test.size());
        test.toShow();
        System.out.println("-------");
        test.clear();
        System.out.println(test.size());
        test.toShow();
        // System.out.println("-------");
        // test.removeAtIndex(1);
        // System.out.println(test.size());
        // test.toShow();
        // System.out.println("-------");
        // test.removeAtIndex(0);
        // System.out.println(test.size());
        // test.toShow();
        // System.out.println("-------");
        // test.toShow();

        // System.out.println(test.isEmpty());
    }
}
