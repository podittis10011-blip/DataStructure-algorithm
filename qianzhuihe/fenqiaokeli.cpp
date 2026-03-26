#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;

const int N = 100010;

int n, k;
int h[N], w[N];

bool check(int mid)
{
    int res = 0;
    for (int i = 0; i < n; i ++ )
    {
        res += (h[i] / mid) * (w[i] / mid);
        if (res >= k) return true;
    }

    return false;
}

int main()
{
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; i ++ ) scanf("%d%d", &h[i], &w[i]);

    int l = 1, r = 1e5;
    while (l < r)
    {
        int mid = l + r + 1 >> 1;
        if (check(mid)) l = mid;
        else r = mid - 1;
    }

    printf("%d\n", r);

    return 0;
}

作者：yxc
链接：https://www.acwing.com/activity/content/code/content/162650/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。