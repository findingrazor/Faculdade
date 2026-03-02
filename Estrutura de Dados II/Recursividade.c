/*
 ============================================================================
 Name        : Recursividade.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

int fatorialIterativo (int n);
int fatorialRecursivo (int n);
int fatorialRecursivoCauda (int n, int resultado);

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int n = 5;
	int resultado = 1;
	printf("\nFatorial %d! = %d", n, fatorialIterativo(n));
	printf("\nFatorial %d! = %d", n, fatorialRecursivo(n));
	printf("\nFatorial %d! = %d", n, fatorialRecursivoCauda(n,resultado));
	return EXIT_SUCCESS; //constante que representa 0
}

int fatorialIterativo (int n){ //usa estrutura de repetição (não recursivo)
		//int i;
		int fat = 1;

		/*for (i=2; i<=n; i++){
			fat*=1;
		}*/

		while (n > 1){
			fat *= n;
			n--;
		}

		return fat;
	}

/*int fatorialRecursivo (int n){
	if(n <= 1){
		return 1;
	} else {
		return n * fatorialRecursivo(n-1);
	}*/

int fatorialRecursivo (int n){
	if (n > 1){ //caso recursivo - chama a função novamente
		return n * fatorialRecursivo(n-1);
	}else{ //caso base - para de chamar a função
		return 1;
	}
}

/*int fatorialRecursivoCauda (int n, int resultado){
	if (n<=1){
		return resultado;
	}else{
		return fatorialRecursivoCauda(n-1, n*resultado);
	}
}*/

int fatorialRecursivoCauda (int n, int resultado){
	if (n>1){
		return fatorialRecursivoCauda(n-1, n*resultado);
	}else{
		return resultado;
	}
}
