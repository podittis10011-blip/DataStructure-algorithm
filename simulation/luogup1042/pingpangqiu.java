package simulation.luogup1042;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class pingpangqiu {

    public void simulation(ArrayList<Character> arr,int limit){
        int a = 0,b = 0;
        for(char c : arr){
            if(c == 'W'){
                a ++;
            }
            if(c == 'L'){
                b ++;
            }

            if((a >= limit || b >= limit) && abs(a - b) >= 2){
                System.out.println(a + ":" + b);
                a = 0;
                b = 0;
            }
        }
        System.out.println(a + ":" + b);
        
    }
    public static void main(String args[]){
    String line;
    Collection<Character> arr =new ArrayList<>();

    // arr.add('a');
    // while(getline(cin,line)){
    //获取迭代器
    // Iterator<Character> it = arr.iterator();

    // while(it.hasNext()){
    //     // char c = it.next();
    //     char c = it.next();
    // }

    // while(){
    //     // for(char c : line){

    //     // }
    //     //Java中似乎必须使用迭代器
        

    // }

    //多行输入
    while(){
        for(char c : arr){
            if(c == 'W' || c == 'L'){
                arr.add(c);
            }
            if(c == 'E'){
                break;
            }
        }
        if(arr.contains('E')){
            break;
        };
    }

    simulation(arr,11);
    }

}
