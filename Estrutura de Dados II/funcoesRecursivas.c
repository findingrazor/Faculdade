/*
 ============================================================================
 Name        : funcoesRecursivas.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int conferirPalindromo(char palindromo[], int tamanho, int posicao);
bool palindromos(char *frase, int inicio, int fim);
int transformarBinario(char binario[], int numero, int posicao);
void transformarBinarios(char binario[], int numero, int posicao);

int main(void) {
	setbuf(stdout, NULL);
	char binario[8] = "00000000";
	char palindromo[] = "ovo";
	char frase[] = "arara";
	int tamanho = strlen(palindromo);
	int posicao = 0;
	conferirPalindromo(palindromo, tamanho-1, posicao);
	(palindromos(frase, 0, strlen(frase)-1) == true) ?
			printf("\nÉ palíndromo") :
			printf("\nNão é palíndromo");
	transformarBinario(binario, 12, strlen(binario) -1);
	transformarBinarios(binario, 129, strlen(binario) -1);
	return EXIT_SUCCESS;
}

int conferirPalindromo(char palindromo[], int tamanho, int posicao){
	if(palindromo[posicao]==palindromo[tamanho] && tamanho != posicao){
		return conferirPalindromo(palindromo, (tamanho - 1), (posicao + 1));
	}else if(palindromo[posicao]==palindromo[tamanho] && tamanho == posicao){
		printf("\n%s é um palíndromo!", palindromo);
	}else{
		printf("\n%s não é um palíndromo!", palindromo);
	}
}

bool palindromos(char *frase, int inicio, int fim){
	if(inicio >= fim){
		return true;
	} else if(frase[inicio]==frase[fim]){
		return palindromos(frase, inicio+1, fim-1);
	} else{
		return false;
	}
}

int transformarBinario(char binario[], int numero, int posicao)
{
	if (numero > 0)
	{
		binario[posicao] = (numero % 2) + '0';
		return transformarBinario(binario, numero / 2, posicao - 1);
	}
	else
	{
		printf("\nO número em binário é igual a %s", binario);
	}
}

void transformarBinarios(char *binario, int numero, int posicao)
{
	if (numero > 0)
	{
		binario[posicao] = (numero % 2) + '0';
		transformarBinario(binario, numero / 2, posicao - 1);
	} else{
		printf("\nO número em binário é igual a %s", binario);
	}
}
