#include <stdio.h>
#include <string.h>

//copia apenas parte da string

int main (){
    char origem[] = "Programacao";
    char destino[20];

    strncpy(destino,origem,5);
    destino[5] = '\0';
    printf("Destino: %s\n", destino);

    return 0;
}
