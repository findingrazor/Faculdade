#include <stdio.h>
#include <stdlib.h>
#include "incluirLista.h"

int main(){
    No *lista = NULL;
    lista =  inserirInicioLista(lista);
    return 0;
}

No* inserirInicioLista(No *inicio){
    No *novo=(No*)malloc(sizeof(No));
    novo->codigo = RANDO;
    novo->proximo = inicio;
    return novo;
}

void impressao(No *lista){
    No *atual = lista;
    while(atual != NULL){
        printf("Código: %d\n", atual->codigo);
        atual = atual->proximo;
    }
}
