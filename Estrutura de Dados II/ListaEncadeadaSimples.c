/*
 ============================================================================
 Name        : ListaEncadeadaSimples.c
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
typedef struct no listaSimples;
//struct | tipo
//ponteiro so aponta pro tipo dele
struct no{
	int codigo;
	listaSimples *proximo;
};

listaSimples* alocarEspaco();
listaSimples* inserirInicio(listaSimples *inicio);
void menu();
void impressao(listaSimples *lista);

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return EXIT_SUCCESS;
}


listaSimples* alocarEspaco(){
	listaSimples *novo = (listaSimples*) malloc (sizeof(listaSimples));
	novo->codigo = RANDOMICO(100);
	novo->proximo = NULL;
	return novo;
}

listaSimples* inserirInicio(listaSimples *inicio){
	//Alocar o novo registro
	//Preencher dados básicos
	listaSimples *novo = alocarEspaco();

	//Organizar apontamentos
	novo->proximo = inicio;

	//Atualizar ponteiro externo
	return novo;
}

void menu(){
	char op;
	listaSimples *lista = NULL;
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


void impressao(listaSimples *lista){
	if(lista){
	//if (lista != NULL){
		printf("\nEndereço %p - Código %i - Próximo %p",
				lista, lista->codigo, lista->proximo);
		impressao(lista->proximo);
	}
}
