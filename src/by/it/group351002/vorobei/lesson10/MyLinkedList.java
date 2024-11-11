package by.it.group351002.vorobei.lesson10;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class MyLinkedList<E> implements Deque<E> {
    class  MyLinkedListNode<E> {
        public E data;
        public  MyLinkedListNode<E> next;
        public  MyLinkedListNode<E> prev;
        public MyLinkedListNode(E inputdata){
            this.data = inputdata;
        }
    }

    MyLinkedListNode<E> head;
    MyLinkedListNode<E> last;
    int size;
    MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        MyLinkedListNode<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp != null) {
                sb.append(temp.data);

                if (i < size - 1) {
                    sb.append(", ");
                }
                temp = temp.next;
            }
        }
        sb.append(']');
        return sb.toString();
    }
    @Override
    public void addFirst(E e) {
        MyLinkedListNode<E> node = new MyLinkedListNode<>(e);
        if (head != null){
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (last == null) {
            last = node;
        }
        // возможно добавить
        size++;
    }

    @Override
    public boolean add(E e) {
        MyLinkedListNode<E> node = new MyLinkedListNode<>(e);
        if (last != null) {
            last.next = node;
            node.prev = last;
        }
        last = node;
        if (head == null) {
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public boolean remove(Object o) {
        MyLinkedListNode tempNode = head;
        while (tempNode != null) {
            if (tempNode.data.equals(o)) {
                tempNode.prev.next = tempNode.next;
                tempNode.next.prev = tempNode.prev;
                size--;
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public E remove(int index){
        MyLinkedListNode tempNode = head;
        for (int i = 0; i != index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;
        size--;
        E e = (E) tempNode.data;
        return e;
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        if (size == 0) {
            return null;
        }
        E e = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null;
        }
        else {
            last = null;
        }

        size--;
        return e;
    }

    @Override
    public E pollLast() {
        if (size == 0) {
            return null;
        }
        E e = last.data;
        last = last.prev;

        if (last != null) {
            last.next = null;
        }
        else {
            head = null;
        }

        size--;
        return e;
    }

    @Override
    public E getFirst() {
        if (head == null){
            return null;
        }
        return head.data;
    }

    @Override
    public E getLast() {
        if (last == null){
            return null;
        }
        return last.data;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}