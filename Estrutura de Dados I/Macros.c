#include <stdio.h>
#define MAIOR(x,y) ((x) > (y) ? (x) : (y))
//se x maior que y retorna x else retorna y (operador tern�rio)

int main(){
    printf("\nQuem � maior 23 ou 45? %d", MAIOR(23,45));
    return 0;
}
