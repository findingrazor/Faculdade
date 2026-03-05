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
#include <ctype.h>

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
void impressao(listaSimples *lista);
int solicitarCodigo(char *frase);
listaSimples* inserirInicio(listaSimples *inicio);
listaSimples* inserirFim(listaSimples *inicio);
void inserirFimUltimo(listaSimples** ultimo);
listaSimples* buscarNo (listaSimples *inicio, listaSimples **anterior, int codigo);
listaSimples* removerNo(listaSimples *inicio);
void menu();

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

void impressao(listaSimples *lista){
	if(lista){
	//if (lista != NULL){
		printf("\nEndereço %p - Código %i - Próximo %p",
				lista, lista->codigo, lista->proximo);
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

listaSimples* inserirInicio(listaSimples *inicio){
	//Alocar o novo registro
	//Preencher dados básicos
	listaSimples *novo = alocarEspaco();

	//Organizar apontamentos
	novo->proximo = inicio;

	//Atualizar ponteiro externo
	return novo;
}

listaSimples* inserirFim(listaSimples *inicio){
	//Alocar o novo registro
	//Preencher dados básicos
	listaSimples *novo = alocarEspaco();

	//organizar apontamentos
	//tem registro na lista
	if(inicio){//if (inicio != NULL)
		listaSimples *tmp = inicio; //temporario que aponta pro mesmo lugar de inicio
		while(tmp->proximo){
			tmp = tmp->proximo;
		}
		tmp->proximo = novo;
		return inicio;
	}

	//não tem registro na lista
	//if(!inicio){//if (inicio == NULL)
		return novo;
	//}

}

void inserirFimUltimo(listaSimples** ultimo){
	//Alocar o novo registro
	//Preencher dados básicos
	listaSimples *novo = alocarEspaco();

	//organizar apontamentos
	if(*ultimo){//if((*ultimo) != null)
		(*ultimo)->proximo = novo;
	}

	(*ultimo) = novo;
}

listaSimples* buscarNo (listaSimples *inicio, listaSimples **anterior, int codigo){
	if(!inicio){ //caso base 1 - não encontrou
		return NULL;
	}

	if (inicio->codigo == codigo){ //caso base 2 - encontrou código
			return inicio;
	}

	(*anterior) = inicio;
	return buscarNo(inicio->proximo, anterior, codigo); // caso recursivo - não achou vai para o próximo
}

listaSimples* removerNo(listaSimples *inicio){
	listaSimples *anteriorBusca = NULL;
	int codigo = solicitarCodigo("Digite o código que deseja excluir: ");
	listaSimples *atual = buscarNo(inicio, &anteriorBusca, codigo);

	if(atual){
		if(!anteriorBusca){
			//remover primeiro registro
			inicio = inicio->proximo;
		} else {
			//remover do segundo até o último
			anteriorBusca->proximo = atual->proximo;
		}
		free(atual);
	}

	//se não achou registro para excluir
	return inicio;
}

void menu(){
	char op;
	int codigo;
	listaSimples *ultimoNo = NULL;
	listaSimples *lista = NULL;
	listaSimples *busca = NULL;
	listaSimples *anteriorBusca;
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
			anteriorBusca = NULL;
			codigo = solicitarCodigo("Digite o código que deseja buscar: ");
			busca = buscarNo(lista, &anteriorBusca, codigo);
			if (!busca){
				printf("\nNó não encontrado");
			} else {
				printf("\nNó encontrado %p - Código %d - Próximo %p - Anterior %p", busca, busca->codigo, busca->proximo, anteriorBusca);
			}

			break;
		case 'E':
			lista = removerNo(lista);
			impressao(lista);
			break;
		case 'F':

			break;
		default:
			printf("\nOpção inválida");
		}
	}while(op != 'F');
}
