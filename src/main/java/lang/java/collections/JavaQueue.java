package lang.java.collections;

import lang.java.utils.ComparablePerson;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The LinkedList and PriorityQueue are two implementation classes for the Queue interface.
 * An instance of the LinkedList class can be used as a FIFO queue or a LIFO queue.
 */
public class JavaQueue {
  private static void linkedList() {
    Queue<String> queue = new LinkedList<>();
    queue.add("John");

    // offer() will work the same as add()
    queue.offer("Richard");
    queue.offer("Donna");
    queue.offer("Ken");

    System.out.println("Queue: " + queue);

    // Let’s remove elements until the queuee is empty
    while (queue.peek() != null) {
      System.out.println("Head Element: " + queue.peek());
      queue.remove();
      System.out.println("Removed one element from Queue");
      System.out.println("Queue: " + queue);
    }

    // Now Queue is empty. Try calling the peek(),
    // element(), poll() and remove() methods
    System.out.println("queue.isEmpty(): " + queue.isEmpty());

    System.out.println("queue.peek(): " + queue.peek());
    System.out.println("queue.poll(): " + queue.poll());

    try {
      String str = queue.element();
      System.out.println("queue.element(): " + str);
    } catch (NoSuchElementException e) {
      System.out.println("queue.element(): Queue is empty.");
    }
    try {
      String str = queue.remove();
      System.out.println("queue.remove(): " + str);
    } catch (NoSuchElementException e) {
      System.out.println("queue.remove(): Queue is empty.");
    }
  }

  private static void priorityQueue() {
    Queue<ComparablePerson> pq = new PriorityQueue<>();
    pq.add(new ComparablePerson(1, "John"));
    pq.add(new ComparablePerson(4, "Ken"));
    pq.add(new ComparablePerson(2, "Richard"));
    pq.add(new ComparablePerson(3, "Donna"));
    pq.add(new ComparablePerson(4, "Adam"));

    System.out.println("Priority queue: " + pq);

    while (pq.peek() != null) {
      System.out.println("Head Element: " + pq.peek());
      pq.remove();
      System.out.println("Removed one element from Queue");
      System.out.println("Priority queue: " + pq);
    }
  }

  public static void main(String[] args) {
    linkedList();
    priorityQueue();
  }

}
