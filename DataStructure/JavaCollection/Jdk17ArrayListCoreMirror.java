package DataStructure.JavaCollection;

import java.util.Arrays;
import java.util.Objects;

/**
 * 可执行的 ArrayList 核心路径镜像。
 *
 * <p>对照源：用户本地 ArrayList.java，SHA-256 C97BEBB92CD9E3FBB79BF16B5A009A1C58217A1634CF730113220970A0059830。
 * 关键位置：字段 118-145；grow 231-245；get 426-429；add 452-492；remove 503-510。
 *
 * <p>适配：类名和包名改变；JDK 内部的 ArraysSupport.newLength 被本类的 teachingNewLength 替代。
 * 其余列出的核心流程与源代码保持同一控制流。省略迭代器、SubList、序列化和完整溢出处理。
 */
public final class Jdk17ArrayListCoreMirror<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    //动态数组有效元素长度
    private int size;

    //
    private int modCount;

    //空参构造器
    public Jdk17ArrayListCoreMirror() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    //返回动态数组有效值
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /** Source ArrayList.java:426-429. */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    /** Source ArrayList.java:231-245; only ArraysSupport.newLength is locally adapted. */
    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;

        //原数组中已经有元素的情况
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {

            //长度为原来的1.5倍
            int newCapacity = teachingNewLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1);

            //copyOf()，创建一个容量大小为newCapacity并且长度为原来1.5倍的新数组，并将原数组中的元素拷贝到新数组中
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            //
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private static int teachingNewLength(int oldLength, int minGrowth, int preferredGrowth) {
        return oldLength + Math.max(minGrowth, preferredGrowth);
    }

    /** Source ArrayList.java:452-457. */
    private void add(E e, Object[] elementData, int s) {
        //如果索引的下标
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = e;
        size = s + 1;
    }

    /** Source ArrayList.java:465-469. */
    public boolean add(E e) {
        modCount++;
        add(e, elementData, size);
        return true;
    }

    /** Source ArrayList.java:480-492. */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        modCount++;
        final int s;
        Object[] elementData;
        //检查数组容量是否足够，不足则进行扩容
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
        //jdk中实现的一种高速元素迁移操作
        System.arraycopy(elementData, index, elementData, index + 1, s - index);

        //对插入的位置赋值（覆盖）
        elementData[index] = element;
        size = s + 1;
    }

    /** Source ArrayList.java:503-510. */
    public E remove(int index) {
        //get操作，检查
        Objects.checkIndex(index, size);
        final Object[] es = elementData;
        //保存被删除的元素
        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        //jdk中实现的一种高速移除元素的操作
        fastRemove(es, index);
        //返回被删除的元素
        return oldValue;
    }

    /** Equivalent to the single-index branch of the source's tail-shift removal logic. */
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i) {
            //底层依旧是使用arraycopy做的元素迁移操作
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = null;
    }

    //检查中间插入是否在动态数组有效范围内
    private void rangeCheckForAdd(int index) {
        //不再，抛出索引越界异常
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
