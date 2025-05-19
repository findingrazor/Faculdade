#include <stdio.h>
#define SQR(x) (x)*(x)

int main(){
    int i = 7, j = 12;
    printf("\nO valor é %d", SQR(i+j));
    #undef SQR
    //printf("\nO valor é %d", SQR(i+j)); não executa
    return 0;
}

