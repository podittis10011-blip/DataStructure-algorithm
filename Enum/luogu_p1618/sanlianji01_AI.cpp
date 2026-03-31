#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    int A, B, C;
    if (!(cin >> A >> B >> C)) return 0; // 输入

    bool found = false;

    for (int Avalue = 123; Avalue <= 987; Avalue++) {
        // 先乘后除，确保比例准确
        if ((Avalue * B) % A != 0 || (Avalue * C) % A != 0) continue;

        int Bvalue = Avalue * B / A;
        int Cvalue = Avalue * C / A;

        // 范围检查
        if (Bvalue <= 987 && Cvalue <= 987) {
            
            // --- 简单的排重检查 ---
            string s = to_string(Avalue) + to_string(Bvalue) + to_string(Cvalue);
            sort(s.begin(), s.end()); // 把所有数字排个序
            
            // 检查排序后是不是正好是 "123456789"
            if (s == "123456789") {
                cout << Avalue << " " << Bvalue << " " << Cvalue << endl;
                found = true;
            }
        }
    }

    if (!found) cout << "No!!!" << endl;

    return 0;
}