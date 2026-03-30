#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int A,B,C;


int main(){
    cin >> A >> B >> C;

    for(int Avalue = 123;Avalue <= 987;Avalue++){
        int Bvalue = Avalue * (B / A);
        int Cvalue = Avalue * (C / A); 

        if(Avalue,Bvalue,Cvalue <= 987){
            cout << Avalue << Bvalue << Cvalue << endl;
            printf(" ");
        }
    }

    return 0;
}
