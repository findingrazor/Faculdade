#include <stdio.h>

void imprimirBaseBinaria(int num);

int main(){
    printf("\nImpressão do Binário de um número: ");
    imprimirBaseBinaria(37);
    return 0;
}

void imprimirBaseBinaria(int num){
    if (num>1){
        imprimirBaseBinaria(num/2);
        printf(" %d",num%2);
    } else{
        printf(" %d",num%2);//1/2 vai restar 1 pq n é "divisível" e 0/2 é 0
    }
}

//não precisa de return por ser print
//se fosse recursiva, uma ideia é utilizar um vetor para guardar e imprimir as parciais(imprimindo ao contrário)
