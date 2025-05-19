#include <stdio.h>
#include <string.h>

//strcpy: copia de uma string pra outra o conteúdo
int main () {
    char origem[] = "Computacao";
    char destino[10];

    strcpy(destino,origem);
    printf("Destino: %s\n", destino);

    // -SEPARAÇÃO
    //copia e recebe dados de uma string

    char string1[] = "Estrutura de Dados I";
    char string2[30];

    strcpy(string2, string1);
    printf("String copiada : %s\n", string2);

    printf("Digite seu nome: ");
    fgets(string2, 30, stdin);

    printf("Seu nome: %s\n", string2);

    return 0;
}
