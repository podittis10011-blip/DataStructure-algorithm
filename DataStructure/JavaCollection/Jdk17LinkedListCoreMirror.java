package DataStructure.JavaCollection;

/**
 * 可执行的 LinkedList 核心路径镜像。
 * 对照源：用户本地 LinkedList.java，SHA-256 7611A67C220AC3236500D0911A336DAB855E9D5B139084594E543A7A36D0BF00。
 * 关键位置：linkLast 144-154；unlink 213-237；add 341-344；node(index) 570-584；Node 974-984。
 * 省略完整 List/Deque API、迭代器、序列化；保留核心控制流。
 */
public final class Jdk17LinkedListCoreMirror<E> {

    transient Node<E> first;
    transient Node<E> last;
    transient int size;
    transient int modCount;

    public int size() {
        return size;
    }

    /** Source LinkedList.java:144-154. */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /** Source LinkedList.java:341-344. */
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    /** Source LinkedList.java:213-237. */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        modCount++;
        return element;
    }

    /** Source LinkedList.java:570-584. */
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /** Source LinkedList.java:974-984. */
    static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
