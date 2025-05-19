#include <stdio.h>

int main () {
    //char c = 'A';
    //printf("%d", c);
    //imprime o decimal (ASCII)

    char string1[100];
    char string2[100];

    //Entrada de dados
    printf("Digite a String 1: \n");
    //scanf("%s", string1);
    gets(string1);

    printf("Digite a String 2: \n");
    scanf("%s", string2);
    //gets(string2);

    printf("String 1: %s\n", string1);
    printf("String 2: %s\n", string2);
    return 0;
}
