#include <stdio.h>

int main() {
    char string[40];
    int tamanho = 0;

    printf("Digite a String: ");
    scanf("%[^\n]", string);

     while (string[tamanho] != '\0'){
       tamanho++;
    }

    printf("Tamanho da String: %d", tamanho);

    return 0;
}
