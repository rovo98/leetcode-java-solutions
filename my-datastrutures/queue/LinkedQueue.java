package datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ADT LinkedQueue, an implement of queue using linked list.
 *
 * Data
 *      Node first              the head of the linked list.
 *      Node last               the tail of the linked list.
 *      int n                   the number of items in queue.
 * Operation
 *      LinkedQueue()           Initial an empty queue.
 *      boolean isEmpty()       Returns true if queue is empty, otherwise false.
 *      int size()              Returns the number of items in queue.
 *      void enqueue(Item item) Add an item to the queue.
 *      Item dequeue()          Remove an item from the queue.
 *      Item peek()             Get the front element.
 *
 * endADT
 * @author rovo98
 */
public class LinkedQueue<Item> implements Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    /**
     * Initial an empty queue.
     */
    public LinkedQueue() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if queue is empty.
     * @return  {@code true} if queue is empty;
     *          {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null; // or n == 0;
    }

    /**
     * Returns the number of items in queue.
     * @return the number of items in queue.
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Add an item to the queue.
     * @param item the item to add to the queue.
     */
    @Override
    public void enqueue(Item item) {
        // insert the item to the tail of linked list.
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * Remove an item from queue.
     * @return the item removed from queue.
     */
    @Override
    public Item dequeue() {
        // remove item from the head of linked list.
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is underflow.");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    /**
     * Get the front element.
     * @return The front element in queue.
     */
    @Override
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is underflow.");
        }
        return first.item;
    }

    /**
     * Returns an iterator to the queue that iterates through items in the queue in LILO order.
     * @return An iterator to the queue that iterates through items in the queue in LILO order.
     */
    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator<>(first);
    }
    private class LinkedQueueIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        private LinkedQueueIterator(Node<Item> first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Unit tests {@code LinkedQueue} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("The input test queue is the following:");
        for (int item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
