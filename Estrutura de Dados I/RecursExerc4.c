#include <stdio.h>
#include <stdlib.h>

int somaElementosVetor(int *vetor, int tam);

int main(){
    int tam;

    do{
        printf("\nDigite o tamanho do vetor: ");
        scanf(" %d", &tam);

        if (tam<=0){
            printf("Tamanho inválido, por favor digite um número positivo ");
        }
    }while(tam<=0);

    int *vetor;
    vetor = (int*)malloc(tam*sizeof(int));

    for(int i=0; i<tam; i++){
        printf("\nDigite o elemento %d do vetor: ", i+1);
        scanf(" %d", &vetor[i]);
    }

    printf("\nSoma dos Elementos do Vetor: %d", somaElementosVetor(vetor, tam));
    free(vetor);
    return 0;
}

int somaElementosVetor(int *vetor, int tam){
    tam = tam-1;
    if(tam>0){
        return vetor[tam] + somaElementosVetor(vetor, tam);
    } else {
        return vetor[0];
    }

}