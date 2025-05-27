#ifndef INCLUIRLISTA_H_INCLUDED
#define INCLUIRLISTA_H_INCLUDED



#endif // INCLUIRLISTA_H_INCLUDED

#define RANDO rand() % 1000
#define RANDO2(x) rand() % (x)

typedef struct No No;
struct No{
    int codigo;
    No *proximo;
};

void menu();
No* inserirInicioLista(No *inicio);
void impressao(No *inicio);
