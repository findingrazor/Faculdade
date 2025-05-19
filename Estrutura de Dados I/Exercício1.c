#include <stdio.h>

int main() {
    char opcao = ' ';
    int termos, x = 0, y = 1, z = 1;
    double resultado;
    int somaSequencia;

    do {

        printf("Escolha uma opção\n");
        printf("A) ((1 + 0) / 1) + ((2 + 1) / 4)...\n");
        printf("B) 1/1 + 8/10 + 27/100...\n");
        printf("C) (1 / (3 * 2)) + (2 / (3 * 4))...\n");
        printf("D) Sair\n");
        printf("Digite a opção escolhida: \n");
        scanf(" %c", &opcao);
        //usar o toupper pra transformar em maiúsculo


        if (opcao == 'D') {
            printf("Programa encerrado");
            break;
        } else if (opcao == ' ') {
           continue;
        } else if  (opcao != 'A' && opcao != 'B' && opcao != 'C') {
            printf("Opção invalida. Digite 'A', 'B', 'C' ou 'D'\n");
            printf("Digite a opção escolhida: \n");
            scanf("%c", &opcao);
        }
        //else if opcao == 'A' && opcao <= 'C'

        do {
            printf("Digite a quantidade de termos que deseja calcular: \n");
            scanf("%d", &termos);
            if (termos < 1) {
                printf("Digite uma quantidade de termos positiva \n");
                break;
            }
        } while (termos < 1);
        //%i pra ler int, usar while pra testar a condição antes

        if (opcao == 'A') {
            while (x != termos) {
                somaSequencia = ((y + x)+ (0 + x)) / 1 * (y*y);
                resultado = somaSequencia + somaSequencia;
                x++;
                y++;
            }
        } else if (opcao == 'B') {
            do {
                somaSequencia = (1 * y) / 1 * z;
                resultado = somaSequencia + somaSequencia;
                x++;
                y + 8;
                z * 10;
            } while (x != termos);
        } else {
            for (int a = 1; a >= termos; a++){
                somaSequencia = (1 * y) / 3 * (2 * z);
                resultado = somaSequencia + somaSequencia;
                x++;
                y++;
                z + 2;
            }
        }

        printf("O resultado do calculo é: \n" "%d\n", resultado);

        somaSequencia = 0;
        x = 0;
        y = 0;
        opcao = ' ';
        fflush(stdin);
    } while (opcao != 'D');

    return 0;
}
