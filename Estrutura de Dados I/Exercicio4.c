#include <stdio.h>
#include <stdlib.h>

int main(){
    int tamanho;
    int soma=0;
    do{
        printf("Digite o tamanho do vetor(numero inteiro): ");
        scanf(" %d", &tamanho);

        if(tamanho<=0){
          printf("Tamanho invalido, por favor digite um numero positivo inteiro!\n");
        }
    }while(tamanho<=0);

    int *vetor;
    vetor =(int *)malloc(tamanho * sizeof(int));

    for (int i=0; i<tamanho; i++){
        printf("Digite o valor da posicao %d: ", i);
        scanf(" %d", &vetor[i]);

        if(i%2==0){
            vetor[i] *= 2;
        } else{
            vetor[i] /= 2;
        }



        soma += *(vetor + i);
        //soma += vetor[i];
    }

    printf("\nVetor: ");
    for (int i=0; i<tamanho; i++){
        printf("\n %d", vetor[i]);
    }
    printf("\nSoma dos itens do vetor: %d", soma);

    free(vetor);
    return 0;
}
