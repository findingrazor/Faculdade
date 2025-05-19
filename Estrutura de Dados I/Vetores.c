#include <stdio.h>

int main(){
    double salario[5];
    double *pontSalario;

    pontSalario = &salario[0];
    pontSalario = salario;

    //printf("Ponteiro: %d", pontSalario);

    //----

    int vetor [] = {34, 78, 93};
    int *pontVetor;

    pontVetor = &vetor[0];

    printf("\nPrimeiro valor - %d", *pontVetor);
    pontVetor++;//aumenta no endereço

    printf("\nSegundo valor - %d", *pontVetor);
    (*pontVetor)++;//aumenta no conteudo

    printf("\nTerceiro valor - %d", *pontVetor);
    *(pontVetor)++;

    printf("\nQuarto valor - %d", *pontVetor);

    return 0;
}
