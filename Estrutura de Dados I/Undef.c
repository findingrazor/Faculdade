#include <stdio.h>
#define SQR(x) (x)*(x)

int main(){
    int i = 7, j = 12;
    printf("\nO valor � %d", SQR(i+j));
    #undef SQR
    //printf("\nO valor � %d", SQR(i+j)); n�o executa
    return 0;
}

