#include <stdio.h>

void imprimirBaseBinaria(int num);

int main(){
    printf("\nImpress�o do Bin�rio de um n�mero: ");
    imprimirBaseBinaria(37);
    return 0;
}

void imprimirBaseBinaria(int num){
    if (num>1){
        imprimirBaseBinaria(num/2);
        printf(" %d",num%2);
    } else{
        printf(" %d",num%2);//1/2 vai restar 1 pq n � "divis�vel" e 0/2 � 0
    }
}

//n�o precisa de return por ser print
//se fosse recursiva, uma ideia � utilizar um vetor para guardar e imprimir as parciais(imprimindo ao contr�rio)
