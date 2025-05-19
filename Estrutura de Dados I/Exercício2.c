#include <stdio.h>
#include <stdlib.h>

int main()
{
    int agencia; // tamanho do vetor
    float *saldo;
    int tipoConta;
    char continuar;
    float media = 0.0;

    do
    {
        // pede a digitacao da agencia
        printf("Digite o numero da agencia: ");
        scanf(" %d", &agencia);

        // aloca o vetor
        saldo = (float*)malloc(agencia * sizeof(float));

        if (saldo == NULL) {
            printf("Erro ao alocar memória!\n");
            return 1;
        }

        // solicitacao ao cliente
        for (int i = 0; i < agencia; i++){
            do{
                printf("Digite o valor do saldo: ");
                scanf(" %f", &saldo[i]);

                // validacao
                if (saldo[i] <= 0){
                    printf("Saldo invalido, por favor digite um saldo positivo\n");
                }
            } while (saldo[i] <= 0);

            do{
                printf("Digite o tipo de conta (1 - poupanca, 2 - plus e 3 - especial): ");
                scanf(" %d", &tipoConta);

                // validacao
                if (tipoConta != 1 && tipoConta != 2 && tipoConta != 3){
                    printf("Tipo invalido, por favor digite 1, 2 ou 3\n");
                }
            } while (tipoConta != 1 && tipoConta != 2 && tipoConta != 3);
        }

        // calculo de rendimento e media
        for (int i = 0; i < agencia; i++){
            switch (tipoConta){
            case 1:
                saldo[i] *= 1.015;
                break;

            case 2:
                saldo[i] *= 1.020;
                break;

            case 3:
                saldo[i] *= 1.040;
                break;
            }
            media = media + *saldo;
        }
        media = media / agencia;

        // exibicao
        printf("\nNovos valores: ");
        for (int i = 0; i < agencia; i++)
        {
            printf("\n%f", saldo[i]);
        }
        printf("\nMedia dos valores: %lf", media);

        // desalocacao de memoria
        free(saldo);

        // deseja continuar?

        do {
            printf("\nDeseja efetuar novos calculos? (S - Sim, N - Nao)");
            scanf(" %c", &continuar);

            if (continuar != 'N' && continuar != 'n' && continuar != 'S' && continuar != 's'){
                printf("Por favor, digite S ou N\n");
            }

        } while(continuar != 'N' && continuar != 'n' && continuar != 'S' && continuar != 's');

        if (continuar == 'N' || continuar == 'n')
        {
            break;
        }

    } while (continuar != 'N' && continuar != 'n');

    return 0;
}
