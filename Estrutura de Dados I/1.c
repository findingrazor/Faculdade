#include <stdio.h>

//apontador do apontador
int main (){
    int i = 3, j = 5;
    int *p = &i, *q = &j;

    printf("%d\n", p); //endereço de i
    printf("%d\n", &p); //endereço da váriavel p
    printf("%d\n", *&p); //aponta para o endereço de p (que armazena o &i)
    printf("%d\n", **&p); //aponta para o apont do endereço p que guarda o &i (retorna i)

    return 0;
}
