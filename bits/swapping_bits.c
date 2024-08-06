#include <stdio.h>

unsigned char swap(unsigned char n) {
    unsigned char lower_mask = ~(-1 << 4);
    unsigned char lower_nibble = (n & lower_mask) << 4;
    unsigned char upper_nibble = (n & (lower_mask << 4)) >> 4;

    return lower_nibble | upper_nibble;
}

void print_binary(unsigned char n) {
    for (int i = 7; i >= 0; i--) {
        printf("%c", (n & (1 << i)) ? '1' : '0');
    }
    printf("\n");
}

int main() {
    unsigned char byte = 0b11010101; 
    unsigned char ans = swap(byte);

    print_binary(ans);
    return 0;
}
