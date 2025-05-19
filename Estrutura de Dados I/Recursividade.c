#include <stdio.h>
int fatorialRecursivo (int n);
int fatorialRecursivoCauda(int n, int parcial);

int main (){
    printf("\nFatorial recursivo: %d", fatorialRecursivo(5));
    printf("\nFatorial recursivo cauda: %d", fatorialRecursivoCauda(5,1));

    return 0;
}

int fatorialRecursivo (int n){
    if (n>1){
        return n * fatorialRecursivo(n-1);
    } else {
        return 1;
    }
}

int fatorialRecursivoCauda(int n, int parcial){
    if (n>1){
        return fatorialRecursivoCauda(n-1, n*parcial);
    } else {
        return parcial;
    }
}

