#include <stdio.h>

void somarElementos(int *pVet, int tam, int *soma);
//assinatura tem que ficar antes se a função ficar depois da main

int main (){
    int soma,vet[] = {15, 23, 75, 48};
    somarElementos(vet, 4, &soma);
    printf("A soma dos elementos e %d", soma);
    return 0;
}

void somarElementos (int *pVet, int tam, int *soma){
    int i;
    *soma = 0;
    for(i = 0; i < tam; i++){
        *soma += *pVet;
        pVet++;
    }

}

