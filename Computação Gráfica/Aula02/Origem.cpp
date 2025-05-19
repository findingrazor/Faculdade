#include<GL/glut.h>

float  limiteX1 = 1.0;
float  limiteX2 = 1.0;
float  limiteY1 = 1.0;
float  limiteY2 = 1.0;
float moveQuad = 0.0;//mover apenas o quadrado com translate e teclas

void DefineRecorte(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(-limiteX1, limiteX2, -limiteY1, limiteY2);
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
	glPushMatrix();//guarda como a matrix estava antes dos próximos acontecimentos

		glTranslatef(moveQuad, 0.0, 0.0);//move
		//move apenas o quadrado pq ta dentro do push e pop

		//desenha o quadrado branco
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2f(-0.8, 0.8);
			glVertex2f(0.8, 0.8);
			glVertex2f(0.8, -0.8);
			glVertex2f(-0.8, -0.8);
		glEnd();

	glPopMatrix();//volta a matrix para a condição original

	glPushMatrix();
		glRotatef(45, 0, 0, 1);//rotaciona

		//desenha o triangulo vermelho
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_TRIANGLES);
			glVertex2f(0.0, 0.6);
			glVertex2f(0.6, -0.6);
			glVertex2f(-0.6, -0.6);
		glEnd();

	glPopMatrix();

	glScalef(2.0, 2.0, 1.0);//escalona

	//desenha o poligono verde
	glColor3f(0.0, 1.0, 0.0);
	glBegin(GL_POLYGON);
		glVertex2f(-0.6, -0.6);
		glVertex2f(-0.6, -0.4);
		glVertex2f(0.0, -0.2);
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
	switch (key)
	{
	case GLUT_KEY_PAGE_DOWN:
		limiteX1 += 0.5;
		limiteX2 += 0.5;
		limiteY1 += 0.5;
		limiteY2 += 0.5;
		break;

	case GLUT_KEY_PAGE_UP:
		limiteX1 -= 0.5;
		limiteX2 -= 0.5;
		limiteY1 -= 0.5;
		limiteY2 -= 0.5;
		break;

	case GLUT_KEY_LEFT:
		limiteX1 += 0.5;
		limiteX2 -= 0.5;
		break;

	case GLUT_KEY_RIGHT:
		limiteX1 -= 0.5;
		limiteX2 += 0.5;
		break;

	case GLUT_KEY_UP:
		limiteY1 -= 0.5;
		limiteY2 += 0.5;
		break;

	case GLUT_KEY_DOWN:
		limiteY1 += 0.5;
		limiteY2 -= 0.5;
		break;

	case GLUT_KEY_HOME:
		moveQuad += 1;
		break;
	case GLUT_KEY_END:
		moveQuad -= 1;
		break;
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