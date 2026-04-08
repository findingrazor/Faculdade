/*
 ============================================================================
 Name        : Hash.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define RANDOMICO(x) rand() % (x);
#define TAM 11

typedef struct no listaSimples;

struct no{
	int codigo;
	listaSimples *proximo;
};

void menu();
void inicializarVetor(listaSimples* vetor[]);
listaSimples* alocarEspaco();
void impressaoElementos(listaSimples *vetor[], int contElementosHash[], int contElementosTotal);
void imprimirLista(listaSimples *lista);
int solicitarDigitacao(char *frase);
void inserir(listaSimples* vetor[], int contElementosHash[], int *contElementosTotal);
void inserirEmMassa(listaSimples* vetor[], int contElementosHash[], int *contElementosTotal);
listaSimples* buscarCod(listaSimples* vetor[]);

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return EXIT_SUCCESS;
}

void menu(){
	char op;
	listaSimples *vetor[TAM];
	listaSimples *lista = NULL;
    int contElementosTotal = 0;
	int contElementosHash[TAM];
	inicializarVetor(vetor);

	for(int i = 0; i < TAM; i++){
    	contElementosHash[i] = 0;
	}

	do{
		printf("\nA - Inserir Funcionário"
				"\nB - Pesquisar Funcionário"
				"\nC - Impressão"
				"\nD - Inserção em Massa"
				"\nE - Saída"
				"\nDigite sua opção: "
		);
		scanf(" %c", &op);
		op = toupper(op);

		switch (op){
		case 'A':
			inserir(vetor, contElementosHash, &contElementosTotal);
			break;
		case 'B':
			buscarCod(vetor);
			break;
		case 'C':
			impressaoElementos(vetor, contElementosHash, contElementosTotal);
			break;
		case 'D':
			inserirEmMassa(vetor, contElementosHash, &contElementosTotal);
			break;
		case 'E':
		printf("\nPrograma encerrado!\n");
			break;
		default:
			printf("\nOpção inválida");
		}

		if(op == 'E'){
			break;
		}
	}while(op != 'E');
}

void inicializarVetor(listaSimples* vetor[]) {
    for (int i = 0; i < TAM; i++) {
        vetor[i] = alocarEspaco();
        vetor[i]->proximo = NULL;
    }
}

listaSimples* alocarEspaco(){
	listaSimples *novo = (listaSimples*) malloc (sizeof(listaSimples));
	novo->codigo = RANDOMICO(100);
	novo->proximo = NULL;
	return novo;
}

void impressaoElementos(listaSimples *vetor[], int contElementosHash[], int contElementosTotal){
	printf("\n\n--------------- TABELA HASH ---------------\n");
	
	for(int i = 0; i < TAM; i++){
		printf("\n\nChave %d", i);

		int qtdElementos = contElementosHash[i];

		float percentual = 0;
        if (contElementosTotal > 0){
            percentual = (qtdElementos * 100.0) / contElementosTotal;
        }

		printf("\nQuantidade de elementos: %d", qtdElementos);
        printf("\nPercentual: %.2f%%", percentual);

        listaSimples *aux = vetor[i]->proximo;

        if(aux == NULL){
            printf("\nLista vazia.");
        } else {
            printf("\nElementos:");
            imprimirLista(aux); 
        }
    }

    printf("\n\n--------------- TABELA HASH ---------------\n");
}

void imprimirLista(listaSimples *lista) {
    if (lista == NULL){
		return;
	} 
    printf("\nCódigo: %d | Próximo: %p", lista->codigo, lista->proximo);
    imprimirLista(lista->proximo);
}

int solicitarDigitacao(char *frase){
	int numero;
	do{
		printf("\n%s", frase);
		scanf(" %i", &numero);
		if (numero < 0){
			printf("\nNúmero inválido, digite um número positivo");
		}
	} while(numero < 0);
	return numero;
}

void inserir(listaSimples* vetor[], int contElementosHash[], int *contElementosTotal) {
    listaSimples *novo = alocarEspaco();

    int chave = novo->codigo % TAM;

    novo->proximo = vetor[chave]->proximo;
    vetor[chave]->proximo = novo;

	contElementosHash[chave]++;
	(*contElementosTotal)++;
}

void inserirEmMassa(listaSimples* vetor[], int contElementosHash[], int *contElementosTotal){
	int qntdRegistros = solicitarDigitacao("\nDigite o número de registros que deseja cadastrar: ");

	for(int i=0; i < qntdRegistros; i++){
		printf("\nGuardando registro %d", i+1);
		int valor = solicitarDigitacao("\nDigite o valor do registro: ");

		listaSimples *novo = alocarEspaco();
		novo->codigo = valor;

		int chave = novo->codigo % TAM;

		novo->proximo = vetor[chave]->proximo;
		vetor[chave]->proximo = novo;

		contElementosHash[chave]++;
		(*contElementosTotal)++;
	}
}

listaSimples* buscarCod( listaSimples* vetor[]){
    int codigo = solicitarDigitacao("\nDigite o código do funcionário: ");

    int chave = codigo % TAM;
    listaSimples *aux = vetor[chave]->proximo;

    while(aux != NULL){
        if(aux->codigo == codigo){
            printf("\nValor do hash: %d" 
                "\nEndereço na tabela de hash: tabela[%d]"
                "\nCódigo do funcionário: %d"
                "\nPróximo ponteiro: %p\n",
            chave, chave, aux->codigo, aux->proximo);
            return aux;  
        }
        aux = aux->proximo;
    }
	printf("\nCodigo não encontrado!");
    return NULL;
}