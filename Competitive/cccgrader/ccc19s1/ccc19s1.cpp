#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    int hor;
    int ver;
    string input;
    
    getline(cin, input);
    ver = count(input.begin(), input.end(), 'H');
    hor = count(input.begin(), input.end(), 'V');
    
    hor = hor % 2;
    ver %= 2; 
    if (ver == 0 && hor == 0) {
        cout << "1 2\n3 4" << endl;
    } else if (ver == 1 && hor == 0) {
        cout << "3 4\n1 2" << endl;
    } else if (ver == 0 && hor == 1) {
        cout << "2 1\n4 3" << endl;
    } else {
        cout << "4 3\n2 1" << endl;
    }
}
