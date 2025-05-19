#include <stdio.h>
#include <string.h>

// concatena apenas parte da string

int main(){
    char destino[20] = "Olá, ";
    char origem[] = "Mundo!";

    strncat(destino, origem,3);

    printf("String resultante %s\n", destino);
    return 0;
}
