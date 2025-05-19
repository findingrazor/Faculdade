#include <stdio.h>
#define MAIOR(x,y) ((x) > (y) ? (x) : (y))
//se x maior que y retorna x else retorna y (operador ternário)

int main(){
    printf("\nQuem é maior 23 ou 45? %d", MAIOR(23,45));
    return 0;
}
