#include <stdio.h>

//apontador do apontador
int main (){
    int i = 3, j = 5;
    int *p = &i, *q = &j;

    printf("%d\n", p); //endere�o de i
    printf("%d\n", &p); //endere�o da v�riavel p
    printf("%d\n", *&p); //aponta para o endere�o de p (que armazena o &i)
    printf("%d\n", **&p); //aponta para o apont do endere�o p que guarda o &i (retorna i)

    return 0;
}
