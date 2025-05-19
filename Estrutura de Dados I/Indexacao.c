#include <stdio.h>

void somarElementos(int pVet[], int tam, int *soma);
//soma é um ponteiro pra mudar no main (ref)
int main (){
    int soma, vet[] = {15, 23, 75, 48};
    somarElementos(vet, 4, &soma);
    printf("Primeira posicao do vetor %d", vet[0]);
    printf("\nA soma dos elementos %d", soma);
    return 0;
}

void somarElementos(int pVet[], int tam, int *soma){
    int i;
    *soma = 0;
    for(i = 0; i < tam; i++){
        *soma += pVet[i];
        pVet[i]++;
    }
}
