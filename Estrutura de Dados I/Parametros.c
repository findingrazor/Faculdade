#include <stdio.h>

int somarNumeros(int numero1, int numero2){
    numero1 *= 2;
    numero2 += 150;
    printf("Numero1 = %d e Numero2 = %d\n", numero1, numero2);
    return numero1 + numero2;
}

int main(){
    int resultado, numero1 = 5, numero2 = 37;
    resultado = somarNumeros(numero1,numero2);
    printf("O resultado e %d\n", resultado);
    printf("Numero1 = %d e numero2 = %d\n", numero1,numero2);
    return 0;
}
