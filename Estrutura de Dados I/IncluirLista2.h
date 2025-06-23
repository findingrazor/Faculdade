#ifndef INCLUIRLISTA2_H_INCLUDED
#define INCLUIRLISTA2_H_INCLUDED



#endif // INCLUIRLISTA2_H_INCLUDED

#define RANDO rand() % 1000
#define RANDO2(x) rand() % (x)

typedef struct No No;
struct No{
    int codigo;
    No *proximo;
    No *anterior;
};

void menu();
No* inserirInicioLista(No *inicio);
No* inserirFimLista(No *inicio);
void impressao(No *inicio);
