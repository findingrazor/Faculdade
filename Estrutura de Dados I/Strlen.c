#include <stdio.h>
#include <string.h>

// strlen: retorna o tamanho da string, que no caso � 10 pois \0 n�o conta
int main(){
    char palavra[] = "Estruturas";
    printf("Tamanho: %zu\n", strlen(palavra));
    //%zu: tipo espec�fico para o size
    return 0;
}
