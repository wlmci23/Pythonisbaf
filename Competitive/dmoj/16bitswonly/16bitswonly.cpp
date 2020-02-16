#include <cstdio>
#include <vector>

int main() {
    int n, a, b, p;
    std::vector<bool> result;
    std::scanf("%d", &n);
    for (int i=0; i<n; i++) {
        scanf("%d %d %d", &a, &b, &p);
        result.push_back(a * b == p);
    }
    for (bool i:result) {
        if (i) {
            printf("POSSIBLE DOUBLE SIGMA\n");
        } else {
            printf("16 BIT S/W ONLY\n");
        }
    }
}
