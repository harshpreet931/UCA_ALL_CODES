#include <stdio.h>
#include <string.h>
#include <math.h>
#include <assert.h>
#define MAX_LIM 100000

char arr[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

int char_to_index(char c) {
    if (c >= 'A' && c <= 'Z') return c - 'A';
    if (c >= 'a' && c <= 'z') return c - 'a' + 26;
    if (c >= '0' && c <= '9') return c - '0' + 52;
    if (c == '+') return 62;
    if (c == '/') return 63;
    return -1;
}

void decode(char s[], char out[], int n)
{
    int temp[MAX_LIM];
    char conv[MAX_LIM*8];
    int dig_8[MAX_LIM];
    char res[MAX_LIM];
    int padding = 0;
    while (n > 0 && s[n-1] == '=') {
        padding++;
        n--;
    }

    int idx = 0;
    for(int i = 0; i < n; i++)
    {
        int val = char_to_index(s[i]);
        if (val == -1) continue;
        for(int j = 5; j >= 0; j--)
        {
            conv[idx++] = (val & (1 << j)) ? '1' : '0';
        }
    }

    int dig_8_n = 0;
    for(int i = 0; i < idx; i+=8)
    {
        int res = 0;
        for(int j = 0; j < 8 && i+j < idx; j++)
        {
            if(conv[i+j] == '1')
                res += (int) pow(2, 7-j);
        }
        dig_8[dig_8_n++] = res;
    }

    for(int i = 0; i < dig_8_n; i++)
    {
        res[i] = (char)dig_8[i];
    }
    res[dig_8_n] = '\0';

    strcpy(out, res);
}

void run_decode_tests()
{
    char out[MAX_LIM];

    // Test case 1: "SGFyc2g=" (Harsh)
    decode("SGFyc2g=", out, strlen("SGFyc2g="));
    printf("Test case 1: %s\n", out);
    assert(strcmp(out, "Harsh") == 0);

    // Test case 2: "SGVsbG8=" (Hello)
    decode("SGVsbG8=", out, strlen("SGVsbG8="));
    printf("Test case 2: %s\n", out);
    assert(strcmp(out, "Hello") == 0);

    // Test case 3: "QmFzZTY0" (Base64)
    decode("QmFzZTY0", out, strlen("QmFzZTY0"));
    printf("Test case 3: %s\n", out);
    assert(strcmp(out, "Base64") == 0);

    // Test case 4: "VGVzdA==" (Test)
    decode("VGVzdA==", out, strlen("VGVzdA=="));
    printf("Test case 4: %s\n", out);
    assert(strcmp(out, "Test") == 0);

    // Test case 5: "VGVzdDE=" (Test1)
    decode("VGVzdDE=", out, strlen("VGVzdDE="));
    printf("Test case 5: %s\n", out);
    assert(strcmp(out, "Test1") == 0);

    // Test case 6: "" (Empty string)
    decode("", out, strlen(""));
    printf("Test case 6: %s\n", out);
    assert(strcmp(out, "") == 0);

    // Test case 7: "QmFzZTY0IGVuY29kaW5n" (Base64 encoding)
    decode("QmFzZTY0IGVuY29kaW5n", out, strlen("QmFzZTY0IGVuY29kaW5n"));
    printf("Test case 7: %s\n", out);
    assert(strcmp(out, "Base64 encoding") == 0);

    printf("All decode test cases passed!\n");
}

int main()
{
    run_decode_tests();

    char s[MAX_LIM], out[MAX_LIM];
    printf("Enter a Base64 encoded string: ");
    fgets(s, MAX_LIM, stdin);
    int n = strlen(s);

    if(n == 0)
    {
        printf("Give a valid string. \n");
        return 0;
    }
    if(s[n-1] == '\n')
    {
        s[n-1] = '\0';
        n--;
    }

    decode(s, out, n);
    printf("Decoded string: %s\n", out);

    return 0;
}