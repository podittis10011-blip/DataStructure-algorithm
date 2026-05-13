package List.List.SingleLinkedList.Try01;

//单链表复习

//实现一个基本的链表
//能够实现最基本的增删改查功能

//初试化操作

public class List {

    //定义一个头节点
    public static Node head;

    public class Node{
        private int value;
        private Node next;

        //无参构造
        public Node(){

        }

        //有参构造
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
            
            //指针指向下一个节点
            //但是下一个节点还没有创建
        }


        //初始化头节点操作
        public void addFirst(int value,Node next){
            head = new Node(value,null);
        }


        //查找尾部节点操作
        //返回的应该是尾部节点
        public Node findLast(){
            Node node;
            
            for(node = head;node.next != null;node = node.next){

            }

            return node;
            // while(node != null){
            //     //指针节点后移
            //     node = node.next;
            // }
            //空指针异常
            //返回的是一个空指针
        }


        //尾部添加节点操作
        public void addlast(int value){
            Node node = findLast();
            node.next = new Node(value,null); 
        }

    }

    public static void main(String[] args) {
        head.addFirst(1,null);
        
    }  


}

