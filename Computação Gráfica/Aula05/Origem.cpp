#include<GL/glut.h>
float angulo, anguloCam = 0;
int deslocax, deslocay, deslocaz = 0;

void DefineRecorteCamera(void) {
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    //glOrtho(-65, 65, -65, 65, -400, 400);
    gluPerspective(60, 1, 10, 500);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glTranslatef(deslocax, deslocay, deslocaz);
    glRotatef(anguloCam, 0, 1, 0);
    gluLookAt(20, 20, 300, 0, 0, 0, 0, 1, 0);

    glEnable(GL_DEPTH_TEST);
}

void DefineExibicao(void) {
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glViewport(0, 0, 400, 400);
}

void Desenha(void) {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glPushMatrix();
    glRotatef(angulo, 0, 1, 0);
    glColor3f(1, 1, 0);
    glutWireSphere(40, 12, 12);

    glTranslatef(100, 0, 0);
    glColor3f(0, 0, 1);
    glutWireSphere(20, 12, 12);

    glRotatef(angulo, 0, 1, 0);
    glTranslatef(40, 0, 0);
    glColor3f(1, 1, 1);
    glutWireSphere(10, 12, 12);
    glPopMatrix();
    glFlush();
}

void Inicializa(void) {
    glClearColor(0, 0, 0, 1);
    DefineRecorteCamera();
}

void Anima(int key)
{
    angulo += 2;
    glutPostRedisplay();
    glutTimerFunc(13, Anima, 1);
}

void Teclas(int key, int x, int y)
{
    if (key == GLUT_KEY_RIGHT)
    {
        deslocax++;
    }
    if (key == GLUT_KEY_LEFT)
    {
        deslocax--;
    }
    if (key == GLUT_KEY_HOME)
    {
        deslocay++;
    }
    if (key == GLUT_KEY_END)
    {
        deslocay--;
    }
    if (key == GLUT_KEY_UP)
    {
        deslocaz++;
    }
    if (key == GLUT_KEY_DOWN)
    {
        deslocaz--;
    }
    if (key == GLUT_KEY_PAGE_DOWN)
    {
        anguloCam--;
    }
    if (key == GLUT_KEY_PAGE_UP)
    {
        anguloCam++;
    }
    DefineRecorteCamera();
    glutPostRedisplay();
}

int main(void) {
    glutInitWindowSize(400, 400);
    glutInitWindowPosition(0, 0);
    glutCreateWindow("3D");
    Inicializa();
    glutDisplayFunc(Desenha);
    Anima(1);
    glutSpecialFunc(Teclas);
    glutMainLoop();
}