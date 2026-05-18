package Tree.BinaryTree.helloalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
    //      1
    //     /\
    //    2  3
    //   /\
    //  4  5

        //插入节点的操作
        TreeNode P = new TreeNode(0);
        n1.left = P;
        P.left = n2;
    //      1
    //     /\
    //    0  3
    //   /
    //  2 
    // /\
    //4  5


    }
    
}
