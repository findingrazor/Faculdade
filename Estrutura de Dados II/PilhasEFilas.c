/*
 ============================================================================
 Name        : PilhasEFilas.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define RANDOMICO(x) rand() % (x)

//Estrutura
typedef struct no listaDupla;

struct no{
	int codigo;
	listaDupla *anterior;
	listaDupla *proximo;
};


void menu();
listaDupla* alocarEspaco();
void impressao(listaDupla *lista);
listaDupla* inserirFila(listaDupla* ultimo);
listaDupla* inserirPilha(listaDupla *inicio);
listaDupla* remover(listaDupla *inicio);



int main(void) {
	setbuf(stdout, NULL);
	menu();
	return EXIT_SUCCESS;
}

void menu(){
	char op;
	listaDupla *pilha = NULL;
	listaDupla *fila = NULL;
	do{
		printf("\nA - Push Pilha"
				"\nB - Pop Pilha"
				"\nC - Exibir Pilha"
				"\nD - Push Fila"
				"\nE - Pop Fila"
				"\nF - Exibir Fila"
				"\nG - Finalizar"
				"\nDigite sua opção: "
		);
		scanf(" %c", &op);
		op = toupper(op);

		switch (op){
		case 'A':
			pilha = inserirPilha(pilha);
			impressao(pilha);
			break;
		case 'B':
			pilha = remover(pilha);
			impressao(pilha);
			break;
		case 'C':
			impressao(pilha);
			break;
		case 'D':
			fila = inserirFila(fila);
			impressao(fila);
			break;
		case 'E':
			fila = remover(fila);
			impressao(fila);
			break;
		case 'F':
			impressao(fila);
			break;
		case 'G':
			break;
		default:
			printf("\nOpção inválida");
		}

		if(op == 'G'){
			break;
		}
	}while(op != 'G');
}

listaDupla* alocarEspaco(){
	listaDupla *novo = (listaDupla*) malloc (sizeof(listaDupla));
	novo->codigo = RANDOMICO(100);
	novo->proximo = NULL;
	novo->anterior = NULL;
	return novo;
}

void impressao(listaDupla *lista){
	if(lista){
		printf("\nEndereço %p - Código %i - Anterior %p - Próximo %p",
				lista, lista->codigo, lista->anterior,lista->proximo);
		impressao(lista->proximo);
	}
}

listaDupla* inserirPilha(listaDupla *inicio){
	listaDupla *novo = alocarEspaco();

	novo->proximo = inicio;
	novo->anterior = NULL;
	if(inicio){
		inicio->anterior = novo;
	}

	return novo;
}

listaDupla* inserirFila(listaDupla* inicio){
	listaDupla *novo = alocarEspaco();

		if(inicio){
			listaDupla *tmp = inicio;
			while(tmp->proximo){
				tmp = tmp->proximo;
			}
			tmp->proximo = novo;
			novo->anterior = tmp;
			return inicio;
		}

		return novo;
}

listaDupla* remover(listaDupla *inicio){
	listaDupla *noRemovido = inicio;

	if(inicio){
		inicio = inicio->proximo;
		if(inicio){
			inicio->anterior = NULL;
		}
		free(noRemovido);
	}

	return inicio;
}
