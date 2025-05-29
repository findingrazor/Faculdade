#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#include "bibliotecaListaSimples.h"

void menu(){
	char op;
	int cod;
    //criar o ponteiro que armazena a lista.
    No *lista = NULL;

	do{
		printf("\nA - Insersão em lista - Pelo Início"
			"\nB - Insersão em lista - Pelo Fim"
			"\nC - Excluir"
			"\nD - Imprimir"
			"\nE - Finalizar"
			"\nDigite sua opção: ");
		scanf(" %c", &op);
		op = toupper(op);

		switch(op){
		case 'A':
		    lista = inserirInicioLista(lista);
		    printf("\nRegistro inserido com sucesso!");
			break;
		case 'B':
			break;
		case 'C':
			break;
		case 'D':
		    impressao(lista);
		    printf("\n");
			break;
		case 'E':
			printf("\nPrograma finalizado.");
			break;
		default:
			printf("\nOpção inválida.");
		}

	} while (op != 'E');
}

No* inserirInicioLista(No *inicio){
    //Criar o espaço de memória novo
    No *novo =
        (No*) malloc (sizeof(No));

    //Preencher dados básicos
    novo->codigo = RANDO;

    //Conectar o novo à lista pelo início.
    novo->proximo = inicio; //Depois do novo vem o início da lista.

    //Atualizar a lista do escopo menu
    return novo;
}

void impressao(No *inicio){
    if(inicio == NULL){
        printf("Lista Vazia\n");
        return;
    }

    No *iterador = inicio;

    while(iterador!=NULL){
        printf("[ codigo: %d ]\n", iterador->codigo);
        iterador = iterador->proximo;
    }
}

int main(){
    menu();
    return 0;
}
