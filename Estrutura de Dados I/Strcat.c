#include <stdio.h>
#include <string.h>

//strcat: concatena strings

int main () {
    char texto[30] = "Hello ";
    char complemento[] = "World!";

    strcat(texto,complemento);
    printf("%s\n", texto);

    //-SEPARACAO
    //entrada de dados e concatenação

    char string1[50];
    char string2[30];

    printf("Digite a primeira string: ");
    fgets(string1,30,stdin);

    printf("Digite a segunda string: ");
    fgets(string2,30,stdin);

    strcat(string1,string2);
    printf("Resultado : %s\n", string1);

    return 0;
}
