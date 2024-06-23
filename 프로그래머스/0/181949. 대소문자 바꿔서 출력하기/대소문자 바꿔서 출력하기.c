#include <stdio.h>
#include <ctype.h>
#define LEN_INPUT 21  // 문자열 최대 길이 20 + 널 종결자

int main(void) {
    char s1[LEN_INPUT];
    scanf("%20s", s1);  // 최대 20자까지 입력받도록 제한

    for (int i = 0; s1[i] != '\0'; i++) {
        if (isupper(s1[i])) {
            s1[i] = tolower(s1[i]);
        } else if (islower(s1[i])) {
            s1[i] = toupper(s1[i]);
        }
    }

    printf("%s\n", s1);

    return 0;
}
