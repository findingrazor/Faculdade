/*
 ============================================================================
 Name        : ListaEncadeadaDupla.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//Macro
#define RANDOMICO(x) rand() % (x)

//Estrutura
typedef struct no listaDupla;
//struct | tipo
//ponteiro so aponta pro tipo dele
struct no{
	int codigo;
	listaDupla *anterior;
	listaDupla *proximo;
};

listaDupla* alocarEspaco();
listaDupla* inserirInicio(listaDupla *inicio);
void menu();
void impressao(listaDupla *lista);

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return EXIT_SUCCESS;
}


listaDupla* alocarEspaco(){
	listaDupla *novo = (listaDupla*) malloc (sizeof(listaDupla));
	novo->codigo = RANDOMICO(100);
	novo->proximo = NULL;
	novo->anterior = NULL;
	return novo;
}

listaDupla* inserirInicio(listaDupla *inicio){
	//Alocar o novo registro
	//Preencher dados básicos
	listaDupla *novo = alocarEspaco();

	//Organizar apontamentos
	novo->proximo = inicio;
	novo->anterior = NULL;
	if(inicio){
		inicio->anterior = novo;
	}
	//Atualizar ponteiro externo
	return novo;
}

void menu(){
	char op;
	listaDupla *lista = NULL;
	do{
		printf("\nA - Inserir Início"
				"\nB - Inserir Fim"
				"\nC - Buscar"
				"\nD - Remover"
				"\nE - Finalizar"
				"\nDigite sua opção: "
		);
		scanf(" %c", &op);

		switch (op){
		case 'A':
			lista = inserirInicio(lista);
			impressao(lista);
			break;
		case 'B':

			break;
		case 'C':

			break;
		case 'D':

			break;
		case 'E':

			break;
		default:
			printf("\nOpção inválida");
		}
	}while(op != 'E');
}


void impressao(listaDupla *lista){
	if(lista){
	//if (lista != NULL){
		printf("\nEndereço %p - Código %i - Anterior %p - Próximo %p",
				lista, lista->codigo, lista->anterior,lista->proximo);
		impressao(lista->proximo);
	}
}

