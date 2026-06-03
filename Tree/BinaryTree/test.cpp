#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main ()
{   srand((unsigned int)time(NULL));
    int answer =rand()% 100+1;
    int guess;
    printf("====数字猜谜游戏====\n");
    while(1){printf("请输入你猜的数字(1-100) :");
    scanf("%d",&guess);
    if(answer<guess)
    printf("太小了，请继续猜！\n");
    else if(answer>guess)
    printf("太大了,请继续猜!\n");
    else
    printf("恭喜你，猜对了!\n");
    break;}
    
    return 0;
}
