//Biblioteca da linguagem

//Macros e constantes
#define RANDO rand() % 1000
#define RANDO2(x) rand() % (x)

//Estrutura
typedef struct No No;
struct No{
    //Dados básicos
    int codigo;

    //Ponteiro
    No *proximo;
};

//Protótipos
void menu();
No* inserirInicioLista(No *inicio);
void impressao(No *inicio);
