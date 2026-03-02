int conferirPalindromo(char palindromo[], int tamanho, int posicao);
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
int main(void) {
	setbuf(stdout, NULL);
	char palindromo[] = "ovo";
	int tamanho = strlen(palindromo);
	int posicao = 0;
	conferirPalindromo(palindromo, tamanho-1, posicao);
	return EXIT_SUCCESS;
}
 
int conferirPalindromo(char palindromo[], int tamanho, int posicao){
	if(palindromo[posicao]==palindromo[tamanho] && tamanho != posicao){
		return conferirPalindromo(palindromo, (tamanho - 1), (posicao + 1));
	}else if(palindromo[posicao]==palindromo[tamanho] && tamanho == posicao){
		printf("\n%s É um palíndromo!", palindromo);
	}else{
		printf("\n%s não é um palíndromo!", palindromo);
	}
}