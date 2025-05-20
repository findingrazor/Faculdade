#include <stdio.h>
#include <math.h>

float calcularCubos(int termos);

int main () {
    int qtdeTermos;

    do{
        printf("\nDigite a quantidade de termos que deseja calcular: ");
        scanf(" %d", &qtdeTermos);

        if(qtdeTermos<=0){
            printf("Quantidade de termos inválida, por favor, digite um número positivo ");
        }
    }while(qtdeTermos<=0);
    printf("\nResultado: %f", calcularCubos(qtdeTermos));

    return 0;
}

float calcularCubos(int termos){
    if (termos>1){
        return pow(termos, 3)/pow(10, termos-1) + calcularCubos(termos-1);
    } else {
        return 1;
    }

}