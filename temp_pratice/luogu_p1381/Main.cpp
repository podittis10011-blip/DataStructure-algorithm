import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //目标单词集合
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(sc.next());
        }


        int m = sc.nextInt();

        String[] article = new String[m];

        for(int i = 0; i < m; i++){
            article[i] = sc.next();
        }


        //窗口中单词出现次数
        HashMap<String,Integer> cnt = new HashMap<>();


        int left = 0;

        //当前窗口包含多少种目标单词
        int have = 0;


        //最大包含数量
        int max = 0;

        //最短长度
        int ans = Integer.MAX_VALUE;


        for(int right = 0; right < m; right++){

            String word = article[right];


            //右边加入窗口
            if(set.contains(word)){

                cnt.put(word,
                        cnt.getOrDefault(word,0)+1);


                //第一次出现
                if(cnt.get(word)==1){
                    have++;
                }
            }



            /*
             * 当前窗口满足条件
             */
            while(have == set.size()){


                //当前包含目标单词数量
                if(have > max){

                    max = have;
                    ans = right-left+1;

                }
                else if(have == max){

                    ans = Math.min(ans,right-left+1);

                }



                //移动左指针

                String remove = article[left];


                if(set.contains(remove)){

                    cnt.put(remove,cnt.get(remove)-1);


                    //窗口中没有该单词了
                    if(cnt.get(remove)==0){
                        have--;
                    }
                }


                left++;
            }

        }


        System.out.println(max);
        System.out.println(ans);


    }
}