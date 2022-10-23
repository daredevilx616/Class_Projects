#include <stdio.h>
#include<string.h>

int main(void) {
    char str[20];
    int i;
    printf("Enter a single string, to change it to lower or upercase characters: \n");
    scanf("%s", str); //takes input
    printf("After changing: \n");

    for (i = 0; i<=20;i++) {
        if (isupper(str[i])) //checks if the character is uppercase
            printf("%c", tolower(str[i])); //prints that character in lowercase
        if (islower(str[i])) //checks if the character is lowercase
            printf("%c", toupper(str[i])); //prints that character in uppercase
        if(str[i]=='\0') //checks if there is no more character in the array
            break; //breaks the loop
    }

    return 0;
}
