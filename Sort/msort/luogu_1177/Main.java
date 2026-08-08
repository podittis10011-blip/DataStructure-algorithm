package Sort.msort.luogu_1177;
import java.util.Scanner;

public class Main {
    static int[] a,b;
    static int n;
    
    public static void msort(int l, int r){
    if(l==r) return;
    int mid=l+r>>1;
    msort(l,mid);
    msort(mid+1,r); //拆分

    int i=l,j=mid+1,k=l; //合并
    while(i<=mid && j<=r){
        if(a[i]<=a[j]) b[k++]=a[i++];
        else b[k++]=a[j++];
    }
    while(i<=mid) b[k++]=a[i++];
    while(j<=r) b[k++]=a[j++];
    for(i=l; i<=r; i++) a[i]=b[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new int[n];b = new int[n];
        
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }

        msort(0,n - 1);
     
        for(int i = 0;i < n;i++){
            System.out.print(a[i] + " ");
        }
    }
}
