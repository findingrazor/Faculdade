/*
 * funcoesRecursividade.c
 *
 *  Created on: 19 de fev. de 2026
 *      Author: 1a290924996
 */

int multiplicacaoIterativa (int multiplicando, int multiplicador){
	int resultado = 0;
	while(multiplicador > 0){
		resultado += multiplicando;
		multiplicador --;
	}

	return resultado;
}

int multRecursivo (int multiplicando, int multiplicador){//>1 pois resolve no caso base, as outras n instancias sao feitas no caso recursivo
	if(multiplicador > 1){//caso recursivo
		return multiplicando + multRecursivo(multiplicando, (multiplicador-1));
	}else{//caso base
		return multiplicando;
	}
}

int multRecursivoCauda (int multiplicando, int multiplicador, int resultado){//>0 pois o resultado ja é resolvido nas instancias do caso recursivo
	if(multiplicador > 0){//caso recursivo
		return multRecursivoCauda(multiplicando, (multiplicador-1), (resultado+multiplicando));
	}else{//caso base
		return resultado;//seria >1 se tivee um + multiplicando no fim
	}
}
