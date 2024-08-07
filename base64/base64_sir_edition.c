#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

char lookup[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

char* encode(char* data, int len) {
    int out_len = 4 * ((len + 2) / 3);
    char* out = (char*)malloc(out_len + 1);
    if (out == NULL) return NULL;

    int i = 0, j = 0;
    while (i < len) {
        int n = (data[i++] << 16);
        if (i < len) n |= (data[i++] << 8);
        if (i < len) n |= data[i++];

        out[j++] = lookup[(n >> 18) & 63];
        out[j++] = lookup[(n >> 12) & 63];
        out[j++] = (i > len + 1) ? '=' : lookup[(n >> 6) & 63];
        out[j++] = (i > len) ? '=' : lookup[n & 63];
    }
    out[j] = '\0';

    return out;
}

int lookup_index(char c) {
    if (c >= 'A' && c <= 'Z') return c - 'A';
    if (c >= 'a' && c <= 'z') return c - 'a' + 26;
    if (c >= '0' && c <= '9') return c - '0' + 52;
    if (c == '+') return 62;
    if (c == '/') return 63;
    return -1;
}

char* decode(char* data, int len) {
    if (len % 4 != 0) return NULL;

    int out_len = len / 4 * 3;
    if (data[len - 1] == '=') out_len--;
    if (data[len - 2] == '=') out_len--;
    
    char* out = (char*)malloc(out_len + 1);
    if (out == NULL) return NULL; 

    int i = 0, j = 0;
    while (i < len) {
        int n = (lookup_index(data[i++]) << 18);
        n |= (lookup_index(data[i++]) << 12);
        n |= (lookup_index(data[i++]) << 6);
        n |= lookup_index(data[i++]);

        if (j < out_len) out[j++] = (n >> 16) & 255;
        if (j < out_len) out[j++] = (n >> 8) & 255;
        if (j < out_len) out[j++] = n & 255;
    }
    out[j] = '\0';

    return out;
}

void test_sample_cases() {
    char* data = "Hello, World!";
    char* encoded = encode(data, strlen(data));
    printf("Encoded: %s\n", encoded);
    char* decoded = decode(encoded, strlen(encoded));
    printf("Decoded: %s\n", decoded);
    assert(strcmp(data, decoded) == 0);

    data = "Woahh";
    encoded = encode(data, strlen(data));
    printf("Encoded: %s\n", encoded);
    decoded = decode(encoded, strlen(encoded));
    printf("Decoded: %s\n", decoded);
    assert(strcmp(data, decoded) == 0);

    data = "I hope this works! Hahaha";
    encoded = encode(data, strlen(data));
    printf("Encoded: %s\n", encoded);
    decoded = decode(encoded, strlen(encoded));
    printf("Decoded: %s\n", decoded);
    assert(strcmp(data, decoded) == 0);

    free(encoded);
    free(decoded);
}

int main() {
    test_sample_cases();
    printf("All tests passed!!\n");
    return 0;
}
