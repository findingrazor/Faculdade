#include <stdio.h>

void tabelaDeMultiplicacao(int n, int q);

int main (){
    printf("\nMultiplicação: ");
    tabelaDeMultiplicacao(5,6);
    return 0;
}

void tabelaDeMultiplicacao(int n, int q){
    if (q==1){
        printf("\n%d X 1 = %d",n,n*1);
    } else {
        tabelaDeMultiplicacao(n,q-1);
        printf("\n%d X %d = %d", n,q,n*q);
    }
}