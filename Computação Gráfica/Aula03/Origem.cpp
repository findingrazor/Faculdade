#include<GL/glut.h>

int angulo = 0;

void DefineRecorteCamera(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-65, 65, -65, 65, -400, 400);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(20, 20, 100, 0, 0, 0, 0, 1, 0);
	glEnable(GL_DEPTH_TEST);
}

void DefineApresentação()
{
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport(0, 0, 400, 400);
}

void Anima(int) 
{
	angulo += 4;
	glutPostRedisplay();
	glutTimerFunc(13, Anima, 1);
}

void Desenha(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	
	glPushMatrix();
	glRotatef(angulo, 0,1,0);
	//desenha o triangulo 
	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_TRIANGLES);
		glVertex2f(-40, -40);
		glVertex2f(0, 40);
		glVertex2f(40, -40);
	glEnd();

	//desenha o cubo
	glColor3f(1.0, 0.0, 0.0);
	glutWireCube(40);
	glPopMatrix();

	glFlush();
}

void Inicializa(void)
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	DefineRecorteCamera();
}

void main(void)
{
	glutInitWindowSize(400, 400);
	glutInitWindowPosition(0, 0);
	glutCreateWindow("3D Ortogonal");
	Inicializa();
	glutDisplayFunc(Desenha);
	Anima(1);
	glutMainLoop();
}