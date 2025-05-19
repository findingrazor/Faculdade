#include <stdio.h>
#include <string.h>

// strlen: retorna o tamanho da string, que no caso é 10 pois \0 não conta
int main(){
    char palavra[] = "Estruturas";
    printf("Tamanho: %zu\n", strlen(palavra));
    //%zu: tipo específico para o size
    return 0;
}
