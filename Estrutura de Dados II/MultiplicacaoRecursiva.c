/*
 ============================================================================
 Name        : MultiplicacaoRecursiva.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

int multiplicacaoRecursivaComum(int multiplicando, int multiplicador);
int multiplicacaoRecursivaCauda(int multiplicando, int multiplicador, int resultado);

#include "bibliotecaRecursividade.h"

int main(void)
{
	setbuf(stdout, NULL);
    int multiplicando = 5;
    int multiplicador = 4;
    int resultado = 0;
    printf("\nMultiplicação Recursiva Comum entre %d e %d é %d",
           multiplicando, multiplicador, multiplicacaoRecursivaComum(multiplicando, multiplicador));
    printf("\nMultiplicação Recursiva Cauda entre %d e %d é %d",
           multiplicando, multiplicador, multiplicacaoRecursivaCauda(multiplicando, multiplicador, resultado));

    //chamando pela .h e a .c
    printf("\n%d * %d = %d", multiplicando, multiplicador, multiplicacaoIterativa(multiplicando, multiplicador));
    printf("\n%d * %d = %d", multiplicando, multiplicador, multRecursivo(multiplicando, multiplicador));
    printf("\n%d * %d = %d", multiplicando, multiplicador, multRecursivoCauda(multiplicando, multiplicador, resultado));
    return EXIT_SUCCESS;
}

int multiplicacaoRecursivaComum(int multiplicando, int multiplicador)
{
    if (multiplicador > 1)
    {
        return multiplicando + multiplicacaoRecursivaComum(multiplicando, (multiplicador - 1));
    }
    else
    {
        return multiplicando;
    }
}

int multiplicacaoRecursivaCauda(int multiplicando, int multiplicador, int resultado)
{
    if (multiplicador > 0)
    {
        return multiplicacaoRecursivaCauda(multiplicando, (multiplicador - 1), (multiplicando + resultado));
    }
    else
    {
        return resultado;
    }
}
