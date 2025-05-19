#include <stdio.h>
#include <stdlib.h>
 
void receberValorInteiro(int *valor);
float receberValorReal(float valor);
float receberSalarioAtual(float salario);
float recebeVetor(float *vetor, int tam);
 
//1
int main() {
    char opcao;
    int tamanho;
 
    do{
        printf("\nEscolha uma opção (A - Calcular | B - Sair): ");
        scanf(" %c", &opcao);
        if (opcao == 'B' || opcao == 'b'){
            break;
        }
        receberValorInteiro(&tamanho);
        float *vetor;
        vetor = (float*)malloc(tamanho * sizeof(float));
        recebeVetor(vetor, tamanho);
        printf("Media dos salarios: %f", recebeVetor(vetor, tamanho));
        free(vetor);
    }while(opcao != 'B' && opcao != 'b');
 
    return 0;
}
 
//2
void receberValorInteiro(int *valor){
    int i;
    *valor = 0;
    do{
        printf("\nDigite um valor inteiro: ");
        scanf(" %d", &i);
        if (i < 0 || i > 50){
            printf("\nDigitacao invalida, digite um numero inteiro positivo ate 50");
        } else {
            *valor = i;
        }
    }while(i < 0 || i > 50);
}
 
//3
float receberValorReal(float valor){
    float i;
    do{
       printf("\nDigite um valor real: ");
       scanf(" %f", &i);
       if(i < 0){
           printf("Digitacao invalida, digite um numero real positivo\n");
       } 
    }while(i < 0);
    return i;
}
 
//4
float receberSalarioAtual(float salario){
    float novoSalario;
    if(salario <= 2500){
        novoSalario = (salario * 0,15) + salario;
    } else if(salario <= 7000){
        novoSalario = (salario * 0,075) + salario;
    } else {
        novoSalario = salario;
    }
    return novoSalario;
}
 
//5
float recebeVetor(float *vetor, int tam){
    float salario;
    float media;
    *vetor = 0;
    for(int i; i < tam; i++){
        *vetor += receberValorReal(salario);
        vetor++;
    }
    for(int i; i < tam; i++){
        *vetor = receberSalarioAtual(salario);
        media = (*vetor += media);
        vetor++;
    }
    media /= tam;
    return media;
}