#include <stdio.h>
//typedef struct dadosCliente dadosCliente
typedef struct {
    char rua[20];
    int numero;
    char bairro[20];
    int cep;
} endereco;

typedef struct{
    char nome[30];
    int idade;
    float valor;
    char genero;
    endereco end;
} dadosCliente;

int main(){
    //struct
    dadosCliente cli;

    cli.end.numero = 23;

    printf("Digite a rua da residencia: ");
    scanf(" %[^\n]", cli.end.rua);
    printf("\nNumero: %d", cli.end.numero);
    printf("\nRua: %s", cli.end.rua);

    return 0;
}

/*typedef int inteiro;

int main(){
    inteiro i;
    i = 85;
    printf("\nNumero atribuido %d", i);
    printf("\nDigite um numero inteiro: ");
    scanf("%d", &i);
    printf("\nNumero digitado %d", i);

    return 0;
}

typedef int inteiro[5];

int main(){
    inteiro i;
    int x;
    for(x = 0; x < 5; x++){
        i[x] = x * 10;
        printf("\nValor atribuido %d", i[x]);
    }
    return 0;
}

typedef int* inteiro;

int main(){
    inteiro i;
    int x = 77;
    i = &x;
    *i *= 100;
    printf("\nValor atribuido %i", *i);

    return 0;
}*/
