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
#include <ctype.h>

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
void impressao(listaDupla *lista);
int solicitarCodigo(char *frase);
listaDupla* inserirInicio(listaDupla *inicio);
listaDupla* inserirFim(listaDupla *inicio);
void inserirFimUltimo(listaDupla** ultimo);
listaDupla* buscarNo (listaDupla *inicio, int codigo);
void menu();

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

void impressao(listaDupla *lista){
	if(lista){
	//if (lista != NULL){
		printf("\nEndereço %p - Código %i - Anterior %p - Próximo %p",
				lista, lista->codigo, lista->anterior,lista->proximo);
		impressao(lista->proximo);
	}
}

int solicitarCodigo(char *frase){
	int codigo;
	do{
		printf("\n%s", frase);
		scanf(" %i", &codigo);
		if (codigo < 0){
			printf("\nCódigo inválido, digite um número positivo");
		}
	} while(codigo < 0);
	return codigo;
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

listaDupla* inserirFim(listaDupla *inicio){
	//Alocar o novo registro
	//Preencher dados básicos
	listaDupla *novo = alocarEspaco();

	//organizar apontamentos
	//tem registro na lista
	if(inicio){//if (inicio != NULL)
		listaDupla *tmp = inicio; //temporario que aponta pro mesmo lugar de inicio
		while(tmp->proximo){
			tmp = tmp->proximo;
		}
		tmp->proximo = novo;
		novo->anterior = tmp;
		return inicio;
	}

	//não tem registro na lista
	//if(!inicio){//if (inicio == NULL)
		return novo;
	//}

}

void inserirFimUltimo(listaDupla** ultimo){
	//Alocar o novo registro
	//Preencher dados básicos
	listaDupla *novo = alocarEspaco();

	//organizar apontamentos
	if(*ultimo){//if((*ultimo) != null)
		(*ultimo)->proximo = novo;
	}
	novo->anterior = (*ultimo);
	(*ultimo) = novo;
}

listaDupla* buscarNo (listaDupla *inicio, int codigo){
	if(!inicio){ //caso base 1 - não encontrou
		return NULL;
	}

	if (inicio->codigo == codigo){ //caso base 2 - encontrou código
			return inicio;
	}

	return buscarNo(inicio->proximo, codigo); // caso recursivo -não achopu vai para o próximo
}

void menu(){
	char op;
	int codigo;
	listaDupla *ultimoNo = NULL;
	listaDupla *lista = NULL;
	listaDupla *busca = NULL;
	do{
		printf("\nA - Inserir Início"
				"\nB - Inserir Fim"
				"\nC - Inserir Fim (Guardando O Último)"
				"\nD - Buscar"
				"\nE - Remover"
				"\nF - Finalizar"
				"\nDigite sua opção: "
		);
		scanf(" %c", &op);
		op = toupper(op);

		switch (op){
		case 'A':
			lista = inserirInicio(lista);
			impressao(lista);
			break;
		case 'B':
			lista = inserirFim(lista);
			impressao(lista);
			break;
		case 'C':
			inserirFimUltimo(&ultimoNo);
			if(!lista){
				lista = ultimoNo;
			}
			impressao(lista);
			break;
		case 'D':
			codigo = solicitarCodigo("Digite o código que deseja buscar: ");
			busca = buscarNo(lista, codigo);
			if (!busca){
				printf("\nNó não encontrado");
			} else {
				printf("\nNó encontrado %p - Código %d - Próximo %p - Anterior %p", busca, busca->codigo, busca->proximo, busca->anterior);
			}
			break;
		case 'E':

			break;
		case 'F':

			break;
		default:
			printf("\nOpção inválida");
		}
	}while(op != 'E');
}




