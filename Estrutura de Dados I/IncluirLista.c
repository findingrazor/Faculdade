#include <stdio.h>
#include <stdlib.h>
#include "incluirLista.h"

int main(){
    No *lista = NULL;
    lista =  inserirInicioLista(lista);
    lista =  inserirInicioLista(lista);
    impressao(lista);
    return 0;
}

No* inserirInicioLista(No *inicio){
    No *novo=(No*)malloc(sizeof(No));
    novo->codigo = RANDO;
    novo->proximo = inicio;
    return novo;
}

void impressao(No *lista){
    if(lista == NULL){
        printf("Lista Vazia\n");
        return;
    }
    No *atual = lista;
    while(atual != NULL){
        printf("Código: %d\n", atual->codigo);
        atual = atual->proximo;
    }
}
