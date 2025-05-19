#include <stdio.h>

//impressão de linhas e colunas

int main () {
    //vetor
    int nome_vetor[] = {34,-76, 29};

    int size1 = sizeof(nome_vetor) / sizeof(int);

    for (int i = 0; i < size1; ++i){
            printf(" %d", nome_vetor[i]);
        }

    printf("\n");
    //matriz
    //const int num_colunas = 3;
    int nome_matriz[][4] = {34, -76, 29, 5, 56, 18, 90, 2, 87, 109, 120, 136};
    //linha[] e coluna[]
    //começa pelo indice 0

    //int num_linhas = sizeof(nome_matriz) / sizeof(int);
    //igual o de baixo

    int num_colunas = sizeof(nome_matriz[0]) / sizeof(nome_matriz[0][0]);
    //divide o tamanho da linha por quanto cada espaço ocupa (int)
    int num_linhas = sizeof(nome_matriz) / sizeof(nome_matriz[0]);
    //divide a matriz toda por quanto uma linha ocupa

    printf("linhas: %d\n", num_linhas);
    printf("colunas: %d\n", num_colunas);

    for (int i = 0; i <num_linhas; ++i){
        for (int j = 0; j <num_colunas; ++j){
            printf(" %d", nome_matriz[i][j]);
        }
        printf("\n");
    }

    return 0;
}
