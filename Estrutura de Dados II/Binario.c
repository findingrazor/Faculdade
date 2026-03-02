int transformarBinario(char binario[], int numero, int posicao);

#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 

int main(void)
{
	setbuf(stdout, NULL);
	char binario[8] = "00000000";
	int numero = 255;
	binario[8] = '\0';
	int posicao = strlen(binario) - 1;
	transformarBinario(binario, numero, posicao);
	return EXIT_SUCCESS;
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
		printf("O número em binário é igual a %s", binario);
	}
}