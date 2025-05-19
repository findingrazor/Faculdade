#include<GL/glut.h>

float move = 0.0;
float giraV = 0.0;
float giraA = 0.0;

void DefineRecorte(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(-1.0, 1.0, -1.0, 1.0);
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

	//desenha a linha preta
	glColor3f(0.0, 0.0, 0.0);
	glLineWidth(1.0);
	glBegin(GL_LINES);
		glVertex2f(-1.0, -0.2);
		glVertex2f(1.0, -0.2);
	glEnd();

	glTranslatef(move, 0.0, 0.0);

	//desenha o poligono vermelho
	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_LINE_LOOP);
		glVertex2f(-0.3, -0.2);
		glVertex2f(-0.3, 0.2);
		glVertex2f(0.3, 0.2);
		glVertex2f(0.3, -0.2);
		glVertex2f(0.2, -0.2);
		glVertex2f(0.2, -0.1);
		glVertex2f(-0.2, -0.1);
		glVertex2f(-0.2, -0.2);
	glEnd();

	glRotatef(giraV, 0, 0, 1);
	
	//desenha o retangulo verde
	glColor3f(0.0, 1.0, 0.0);
	glBegin(GL_LINE_LOOP);
		glVertex2f(0.1, 0.0);
		glVertex2f(-0.1, 0.0);
		glVertex2f(-0.1, 0.4);
		glVertex2f(0.1, 0.4);
	glEnd();

	glTranslatef(0.0, 0.4, 0.0);
	glRotatef(giraA, 0, 0, 1);
	glTranslatef(0.0, -0.4, 0.0);

	//desenha o retangulo azul
	glColor3f(0.0, 0.0, 1.0);
	glBegin(GL_LINE_LOOP);
		glVertex2f(0.1, 0.3);
		glVertex2f(-0.1, 0.3);
		glVertex2f(-0.1, 0.8);
		glVertex2f(0.1, 0.8);
	glEnd();


	glFlush();
}

void TeclasEspeciais(int key, int x, int y)
{
	switch (key)
	{
	case GLUT_KEY_PAGE_DOWN:
		giraV += 10;
		break;

	case GLUT_KEY_PAGE_UP:
		giraV -= 10;
		break;

	case GLUT_KEY_LEFT:
		move -= 0.1;
		break;

	case GLUT_KEY_RIGHT:
		move += 0.1;
		break;

	case GLUT_KEY_HOME:
		giraA -= 10;
		break;
	case GLUT_KEY_END:
		giraA += 10;
		break;
	}

	DefineRecorte();
	glutPostRedisplay();
}

void Inicializa(void)
{
	glClearColor(255.0, 255.0, 255.0, 0.0);
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