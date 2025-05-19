#include <stdio.h>

int multiplicarNumeros(int valor, int mult);
int multiplicarNumeros1(int valor, int mult);
int multiplicarNumerosCauda(int valor, int mult, int parcial);


int main(){
    printf("\nMultiplicação com somas sucessivas: %d", multiplicarNumeros(7,5));
    printf("\nMultiplicação com somas sucessivas: %d", multiplicarNumeros1(7,5));
    printf("\nMultiplicação com somas sucessivas: %d", multiplicarNumerosCauda(7,5,0));
    return 0;
}
int multiplicarNumeros(int valor, int mult){
    if (mult==0){
        return 0;
    } else if (mult > 1){//>caso base
        return valor + multiplicarNumeros(valor,mult-1);
    } else {
        return valor;
    }
}

int multiplicarNumeros1(int valor, int mult){
    if (mult==0){
        return 0;
    } else {//>caso base
        return valor + multiplicarNumeros(valor,mult-1);
    }
}

int multiplicarNumerosCauda(int valor, int mult, int parcial){
    if(mult==0){
        return parcial;
    } else {
        return multiplicarNumerosCauda(valor, mult - 1, valor+parcial);
    }
}


