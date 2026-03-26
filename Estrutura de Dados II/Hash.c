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

typedef struct no listaSimples;

struct no{
	int codigo;
	listaSimples *proximo;
};

void menu();
listaSimples* alocarEspaco();
void impressaoElementos(listaSimples *lista);
int solicitarCodigo(char *frase);
listaSimples* inserir(listaSimples *inicio);

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return EXIT_SUCCESS;
}

void menu(){
	char op;
	listaSimples vetor[10];
	listaSimples *lista = NULL;

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
			inserir(lista, vetor);
			break;
		case 'B':
			solicitarCodigo("Digite o código do funcionário: ");
			break;
		case 'C':
			for (int i = 0; i <= 10; i++){
					printf("\n Índice %d", i);
			}
			break;
		case 'D':
			break;
		case 'E':
			break;
		default:
			printf("\nOpção inválida");
		}

		if(op == 'E'){
			break;
		}
	}while(op != 'E');
}

listaSimples* alocarEspaco(){
	listaSimples *novo = (listaSimples*) malloc (sizeof(listaSimples));
	novo->codigo = RANDOMICO(100);
	novo->proximo = NULL;
	return novo;
}

void impressaoElementos(listaSimples *lista){
	if(lista){
		printf("\n Código %i - Próximo %p",
				lista->codigo, lista->proximo);
		impressao(lista->proximo);
	}

}

int solicitarCodigo(char *frase){
	int codigo;
	do{
		printf("\n%s", frase);
		scanf(" %i", &codigo);
		if (codigo < 0){
			printf("\nCódigo de funcionário inválido, digite um número positivo");
		}
	} while(codigo < 0);
	return codigo;
}

listaSimples* inserir(listaSimples *inicio, listaSimples *vetor){
	listaSimples *novo = alocarEspaco();

	for (int i = 0; i <= 10; i++){
		if(i == (novo->codigo % 11)){
			novo->proximo = inicio;
			vetor[i].proximo = inicio;
		}
	}
	return vetor;
}


