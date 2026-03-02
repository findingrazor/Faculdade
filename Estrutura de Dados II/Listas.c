/*
 ============================================================================
 Name        : Listas.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void imprimirVetor(int *numeros);

int main(void) {
	setbuf(stdout, NULL);
	int numeros [] = {15, 96, 78, 12, 34};
	printf("\nDa função main %p", &numeros[0]);
	imprimirVetor(numeros);
	return EXIT_SUCCESS;
}

void imprimirVetor(int *numeros){
	printf("\nDa função imprimirVetor %p", &numeros[0]);
	for (int i = 0; i < 5; i++){
		printf("\nConteúdo do ponteiro %p", numeros);
		//printf("\nConteúdo da apontada %d", numeros[i]); indexação
		printf("\nConteúdo da apontada %d", *numeros); //aritmética
		//printf("\n%d", numeros[i]);
		printf("\n----------------------------------");
		numeros++;
	}
}
