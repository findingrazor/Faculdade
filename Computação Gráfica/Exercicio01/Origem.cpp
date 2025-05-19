#include<GL/glut.h>

float  limite = 1.0;

void DefineRecorte(void) 
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(-limite, limite, -limite, limite);
}

void DefineApresentação() 
{
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport(0, 0, 400, 400);
}

void Desenha(void) 
{
	DefineApresentação();
	glClear(GL_COLOR_BUFFER_BIT);

	//desenha o quadrado branco
	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-0.8, 0.8);
		glVertex2f(0.8, 0.8);
		glVertex2f(0.8, -0.8);
		glVertex2f(-0.8, -0.8);
	glEnd();

	//desenha o triangulo vermelho
	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_TRIANGLES);
		glVertex2f(0.0, 0.6);
		glVertex2f(0.6, -0.6);
		glVertex2f(-0.6, -0.6);
	glEnd();

	//desenha o poligono verde
	glColor3f(0.0, 1.0, 0.0);
	glBegin(GL_POLYGON);
		glVertex2f(-0.6, -0.6);
		glVertex2f(-0.6, -0.4);
		glVertex2f(0.0, -0.3);
		glVertex2f(0.6, -0.4);
		glVertex2f(0.6, -0.6);
	glEnd();


	//desenha a linha azul
	glColor3f(0.0, 0.0, 1.0);
	glLineWidth(1.0);
	glBegin(GL_LINES);
		glVertex2f(-1.0, 1.0);
		glVertex2f(1.0, -1.0);
	glEnd();

	glFlush();
}

void TeclasEspeciais(int key, int x, int y) 
{
	if (key == GLUT_KEY_PAGE_DOWN) {
		limite = 2;
	}
	else if (key == GLUT_KEY_PAGE_UP) {
		limite = 0.5;
	}
	DefineRecorte();
	glutPostRedisplay();
}

void Inicializa(void) 
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	DefineRecorte();
}

void main(void) 
{
	glutInitWindowSize(400, 400);
	glutInitWindowPosition(0, 0);
	glutCreateWindow("Desenho");
	Inicializa();
	glutDisplayFunc(Desenha);
	glutSpecialFunc(TeclasEspeciais);
	glutMainLoop();
}