package Stack.ListStack.Try01;

import java.util.Arrays;

public class listStack {
    private int stackSize = 0;
    private listNode stackPeek;

    //初始化栈顶节点
    public listStack(){
        stackPeek = null;
    }

    //获取栈中存储的有效元素个数
    public int size(){
        return stackSize;
    }

    public boolean isEmpty(){
        //布尔表达式，为0返回true，不为0返回false
        return size() == 0;
    }

    //压栈操作
    public void push(int value){
        listNode node = new listNode(value);

        //将stackPeek看作哨兵节点
        node.next = stackPeek;

        //新的节点node赋值给栈顶元素
        stackPeek = node;
        stackSize++;
    }

    //获取栈顶元素
    public int peek(){
        if(isEmpty()){
            return -1;
            // throw new IndexOutOfBoundsException();
        }
        return stackPeek.value;
    }

    //弹栈操作
    public int pop(){
        int num = peek();
        stackPeek = stackPeek.next;
        stackSize--;
        return num;
    }

    //list转化为Array并返回
    public int[] toArray(){
        listNode node = stackPeek;
        int[] res = new int[size()];
        for(int i =res.length - 1;i >= 0;i--){
            res[i] = node.value;
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        listStack stack = new listStack();

        stack.push(0);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        System.out.println(Arrays.toString(stack.toArray()));
    }
}


