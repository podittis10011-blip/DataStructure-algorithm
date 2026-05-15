package List.ListModel;

import java.util.Iterator;

import org.w3c.dom.traversal.NodeIterator;

public class List implements Iterable<Integer>{

    private Node head = null;

    //重写iterator;
    public Iterator<Integer> iterator(){
        return new NodeIterator();
    }
    private class NodeIterator implements Iterator<Integer>{
        Node p = head;

        @Override
        public boolean hasNext(){
            return p != null;
        }
        @Override
        public Integer next(){
            Integer v = p.value;
            p = p.next;
            return v;
        }
    }


    //节点类
    public class Node{
        // public Node next;
        private Node next;
        private Integer value;

        //无参构造
        public Node(){
        }

        //有参构造
        public Node(Integer value,Node next){
            this.next = next;
            this.value = value;
        }
    }

    public Node findLast(){

        // while(it.hasNext()){

        // }

        if(head == null){
            return null;
        }
        Node p;
        for(p = head;p.next != null;p = p.next){

        }
        return p;

    }

    //初始化头节点
    public void addFirst(Integer value){
        // this.head = new Node(value,this.head);

        //类变量
        head = new Node(value,head);
    }

    //添加尾节点
    //需要先找到尾节点
    public void addLast(int value){
        Node last = findLast();
        if(last == null){
            addFirst(value);
            return;
        }

    }

    //方法findNode()和方法get()
    //中的索引，索引指的是第i（index）个节点

    //findNode找的是Node,返回的值为Node
    private Node findNode(int index){
        int i = 0;
        for(Node p = head;p != null;p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    //删除尾节点


    //getValue找的是节点的value值，返回的value
    public int getValue(int index){
        Node node = findNode(index);

        return node.value;
    }

    public void removeFirst(){
        head = head.next;   
    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        Node removed = prev.next;
        prev.next = removed.next;
    }


}

class Main{
    
}
