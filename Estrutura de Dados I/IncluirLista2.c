#include <stdio.h>
#include <stdlib.h>
#include "IncluirLista2.h"

int main(){
    No *lista = NULL;//apontador para o início
    // No *cauda ou fim = NULL;
    //lista =  inserirInicioLista(lista);
    //lista =  inserirInicioLista(lista);
    lista = inserirFimLista(lista);
    impressao(lista);
    lista = inserirFimLista(lista);
    impressao(lista);
    free(lista);
    return 0;
}

No* inserirFimLista(No *inicio){//passar a cauda tbm
    No *novo=(No*)malloc(sizeof(No));
    novo->codigo = RANDO;
    novo->proximo = NULL;

    if(inicio == NULL){
        novo->anterior = NULL;
        return novo;//inserir em ambas, cabeca e cauda
    }
    No *atual=inicio;

    while(atual->proximo != NULL){//não precisa, atribuir diretamente na cauda
        atual = atual->proximo;
    }
    atual->proximo = novo;
    novo->anterior = atual;
    return inicio;
}

void impressao(No *lista){
    if(lista == NULL){
        printf("Lista Vazia\n");
        return;
    }
    No *atual = lista;
    while(atual != NULL){
        printf("Codigo: %d\n", atual->codigo);
        atual = atual->proximo;
    }
}


