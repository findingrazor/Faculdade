#include <stdio.h>

//ponteiros armazenam o endereço de uma outra variavel
//apontam seu conteúdo

//* declaração do ponteiro & endereço %p print endereço
//** apontador de ponteiro
int main() {

    int idade = 23;
    int *pontIdade;

    pontIdade = &idade;
    *pontIdade = 36; //substituindo o que esta guardado

    //printf("Idade: %d - Endereço: %x\n", idade, &idade);
    //printf("pontIdade: %d - Endereço: %x\n", *pontIdade, pontIdade);


    //printf("Idade: %d - Endereço: %x\n", idade, &idade);
    //printf("pontIdade: %d - Endereço: %x\n", *pontIdade, pontIdade);

    printf("\nA variavel idade possui o valor %d ", idade);//variavel
    printf("\nA variavel idade possui o valor %d ", *pontIdade);//aponta o conteudo

    printf("\nEndereco de memoria da variavel idade %p ", &idade);//mostrado pelo &
    printf("\nEndereco de memoria da variavel idade %p ", pontIdade);//mostrado pela variavel

    printf("\nEndereco de memoria da variavel pontIdade %p ", &pontIdade);//endereco do pont

    //----
    printf("\n\n");

    float numeroFloat = 10.12,
        *ponteiroB = &numeroFloat,
        **ponteiroC = &ponteiroB;

    printf("\nVariavel comum, conteudo %f - endereco %p", numeroFloat, &numeroFloat);
    printf("\nPonteiroB, conteudo %p - endereco %p", ponteiroB, &ponteiroB);
    printf("\nPonteiroC, conteudo %p - endereco %p", ponteiroC, &ponteiroC);

    printf("\nPonteiroC aponta para a Variavel comum: %f", **ponteiroC);

    return 0;

}
