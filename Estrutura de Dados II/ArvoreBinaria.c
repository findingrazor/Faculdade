/*
 ============================================================================
 Name        : ArvoreBinaria.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct no noArvore;
struct no{
	int codigo;

	noArvore *esquerda;
	noArvore *direita;
};

void menu();
noArvore* criarNo(int codigo);

int main(void) {
	setbuf(stdout, NULL);
	return EXIT_SUCCESS;
}

void menu(){
	int op;
	noArvore *arvore = NULL;

	do{
		printf("\n1 - Inserir nó"
				"\n2 - Pesquisar nó"
				"\n3 - Excluir nó"
				"\n4 - Sair"
				"\nDigite sua opção: ");
		scanf("%d",&op);

		switch (op){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			printf("\nPrograma finalizado.");
			break;
		default:
			printf("\nValor inválido.");
		}
	} while (op != 4);
}

noArvore* criarNo(int codigo){
	noArvore *novoNo = (noArvore*) malloc(sizeof(noArvore));

	novoNo->codigo = codigo;
	novoNo->esquerda = NULL;
	novoNo->direita = NULL;

	return novoNo;
}

noArvore* inserirNo(noArvore *raiz, int codigo){
	if(!raiz){
		raiz = criarNo(codigo);
	} else if(codigo > raiz->codigo){
		raiz->direita = inserirNo(raiz->direita, codigo);
	} else {
		raiz->esquerda = inserirNo(raiz->esquerda, codigo);
	}

	return raiz;
}
