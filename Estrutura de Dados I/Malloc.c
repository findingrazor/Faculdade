#include <stdio.h>
#include <stdlib.h>

int main()
{
    //alocação de inteiro
    int *x;
    x = (int*)malloc(sizeof(int));
    *x = 5;
    printf("Valor de x: %x\n", *x);
    printf("Endereco do valor de x: %p\n", x);

    //alocação de um vetor de caracteres
    char *c;
    c = (char*)malloc(10);

    //alocação de um vetor de 5 double
    double *y;
    y = (double*)malloc(5 * sizeof(double));

    //Libera espaço de memória reservado
    free(x);
    printf("Valor de x: %x\n", *x);
    printf("Endereco do valor de x: %p\n", x);

    free(c);
    free(y);

    return 0;
}
