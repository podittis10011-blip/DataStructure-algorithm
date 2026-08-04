package DataStructure.List.SingleLinkedList;

public class SingleLinkedList {
    //8.3
    //初始化哨兵节点：
    //哨兵节点：单个节点，但是不进行赋值

    //增删改查的操作
    //初始化哨兵节点

    static class Node{
        private Node next;
        private int value;

        public Node(){

        }

        public Node(int value){
            this.value = value;
        }

        public Node(Node node,int value){
            this.next = node;
            this.value = value;
        }
    }

    //增操作：
    //在链表末尾添加节点
    //在链表中间插入节点

    //删操作：
    //链表末尾删除节点
    //链表中间插入节点

    //改查：
    //改的实现基础在查之上，先查后改
    //根据节点存储数值进行查找

    public static void add(Node head){
        Node node = head;
        while(node.next == null){
            node.next = new Node();
        }
    }

    //插入操作也需找到插入的媒介
    public static void insert(Node head,int value){
        Node node = head;

        //插入操作
        while(node.next.value == value){
            node.next = new Node();

        }

    }

    public static void delete(){

    }

    public static void chaxun(){

    }

    public static void main(String[] args) {
        Node sentinal = new Node();

        add(sentinal);
        insert(sentinal);
    }
}
