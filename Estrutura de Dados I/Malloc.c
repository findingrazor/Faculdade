#include <stdio.h>
#include <stdlib.h>

int main()
{
    //aloca��o de inteiro
    int *x;
    x = (int*)malloc(sizeof(int));
    *x = 5;
    printf("Valor de x: %x\n", *x);
    printf("Endereco do valor de x: %p\n", x);

    //aloca��o de um vetor de caracteres
    char *c;
    c = (char*)malloc(10);

    //aloca��o de um vetor de 5 double
    double *y;
    y = (double*)malloc(5 * sizeof(double));

    //Libera espa�o de mem�ria reservado
    free(x);
    printf("Valor de x: %x\n", *x);
    printf("Endereco do valor de x: %p\n", x);

    free(c);
    free(y);

    return 0;
}
