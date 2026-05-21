package Stack.ArrayStack.Try01;


import java.util.*;

//question1:抛出数组越界为什么不需要实现异常接口/继承Exception类

public class arrayStack {
    //使用泛型 — 使用包装类
    // private Stack<Integer> stack;
    // private int[] nums;//存储

    //使用的是Java集合中的动态数组ArrayList
    private ArrayList<Integer> stack;

    //缺省构造器
    //在缺省构造器中创建stack对象
    public arrayStack(){
        // this.stack = stack;
        stack = new ArrayList<>();
    }

    //获取栈的长度、
    public int size(){
        return stack.size();
    }

    //增删改查操作
    //增操作 — 入栈 — push();
    //value — 压栈元素的数值
    public void push(int value){
        stack.add(value);
    }

    public boolean isEmpty(){
        //等于0，栈空 — 返回值为true
        //不等于0，栈不为空 — 返回值为false
        return stack.size() == 0;
        //stack . size() == 0; — 布尔表达式
    }

    //出栈操作时，需要将出栈元素的返回值打印输出出来
    //返回出栈元素
    public int pop(){

        //在进行出栈操作前要判断一下栈是否为空
        //否则就会导致数组索引越界
        if(isEmpty()){
            return -1;
            //异常处理
            // throw new IndexOutOfBoundsException();
            //报数组索引越界异常
        }
        //数组索引
        //获取size()有效元素个数，栈顶元素 — 数组末尾
        //索引从0开始
        return stack.remove(size() - 1);
    }

    public int peek(){
        //获取栈顶元素之前需要判断栈是否为空
        if(isEmpty()){
            // return -1;
            throw new IndexOutOfBoundsException();
        }
        //栈顶元素为数组末尾元素
        return stack.get(size() - 1);
    }

    //将ArrayList转化为Array并返回
    public Object[] toArray(){
        return stack.toArray();
    }

    //删操作 — 出栈 — pop();
    //访问栈顶元素 — peek()

    //栈这个数据结构应该是不存在改的操作的

    //查 find()
    //遍历

    //获取栈的有效元素个数
    //声明一个capacity对象

    public static void main(String[] args) {
        arrayStack stack = new arrayStack();

        //往里面入栈元素
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //数组尾部有效元素（栈顶元素）为：4

        System.out.println(Arrays.toString(stack.toArray()));

        stack.pop();

        System.out.println(Arrays.toString(stack.toArray()));

        System.out.println(stack.peek());
    }
}
