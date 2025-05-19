#include <stdio.h>
#include <string.h>

//0 se for igual, negativo se str1 for menor que str2
//e positivo se str2 for menor que str1 (vem antes na ASCII)

int main (){
    char str1[] = "Computacao";
    char str2[] = "Computador";
    char str3[] = "Computacao";

    printf("Comparando str1 e str2: %d\n", strcmp(str1,str2));
    printf("Comparando str1 e str3: %d\n", strcmp(str1,str3));

    return 0;
}
