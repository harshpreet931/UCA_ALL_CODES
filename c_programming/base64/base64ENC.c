#include <stdio.h>
#include <string.h>
#include <math.h>
#include <assert.h>
#define MAX_LIM 100000
char arr[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

void encode(char s[], char out[], int n)
{
    int temp[MAX_LIM];
    char conv[MAX_LIM*8];
    int dig_6[MAX_LIM];
    char res[MAX_LIM];
    int padding = (3 - (n % 3));
    if(padding == 3) padding = 0;
    for(int i = 0; i < n; i++)
    {
        temp[i] = s[i];
    }

    int idx = 0;
    for(int i = 0; i < n; i++)
    {
        int num = temp[i];
        for(int j = 7; j >= 0; j--)
        {
            conv[idx++] = (num & (1 << j)) ? '1' : '0';
        }
    }

    int dig_6_n = 0;
    for(int i = 0; i < idx; i+=6)
    {
        int res = 0;
        for(int j = 0; j < 6 && i+j < idx; j++)
        {
            if(conv[i+j] == '1')
                res += (int) pow(2, 5-j);
        }
        dig_6[dig_6_n++] = res;
    }

    for(int i = 0; i < dig_6_n; i++)
    {
        res[i] = arr[dig_6[i]];
    }

    for(int i = 0; i < padding; i++)
    {
        res[dig_6_n + i] = '=';
    }
    res[dig_6_n + padding] = '\0';

    strcpy(out, res);
}

void run_tests()
{
    char out[MAX_LIM];

    // Test case 1: "Harsh"
    encode("Harsh", out, strlen("Harsh"));
    printf("Test case 1: %s\n", out);
    assert(strcmp(out, "SGFyc2g=") == 0);

    // Test case 2: "Hello"
    encode("Hello", out, strlen("Hello"));
    printf("Test case 2: %s\n", out);
    assert(strcmp(out, "SGVsbG8=") == 0);

    // Test case 3: "Base64"
    encode("Base64", out, strlen("Base64"));
    printf("Test case 3: %s\n", out);
    assert(strcmp(out, "QmFzZTY0") == 0);

    // Test case 4: "Test"
    encode("Test", out, strlen("Test"));
    printf("Test case 4: %s\n", out);
    assert(strcmp(out, "VGVzdA==") == 0);

    // Test case 5: "Test1"
    encode("Test1", out, strlen("Test1"));
    printf("Test case 5: %s\n", out);
    assert(strcmp(out, "VGVzdDE=") == 0);

    // Test case 6: Empty string
    encode("", out, strlen(""));
    printf("Test case 6: %s\n", out);
    assert(strcmp(out, "") == 0);

    // Test case 7: "Base64 encoding"
    encode("Base64 encoding", out, strlen("Base64 encoding"));
    printf("Test case 7: %s\n", out);
    assert(strcmp(out, "QmFzZTY0IGVuY29kaW5n") == 0);

    printf("All test cases passed!\n");
}

int main()
{
    run_tests();

    char s[MAX_LIM], out[MAX_LIM];
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

    encode(s, out, n);
    printf("Encoded string: %s\n", out);

    return 0;
}