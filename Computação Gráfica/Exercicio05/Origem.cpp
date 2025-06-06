#include <GL/glut.h>

float angulo = 0.0;

void DefineRecorteCamera(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(60, 1, 10, 400);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(150, 150, 100, 0, 0, 0, 0, 1, 0);
	glEnable(GL_DEPTH_TEST);
}

void DefineApresentacao(void)
{
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport(0, 0, 400, 400);
}

void Anima(int x)
{
	angulo += 1;
	glutPostRedisplay();
	glutTimerFunc(9, Anima, 1);
}

void Desenha(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glPushMatrix();
	
	glRotatef(angulo, 0, 1, 0);

	//sol
	glPushMatrix();
	glColor3f(1.0, 1.0, 0.0);
	glutWireSphere(30,16,16);
	glPopMatrix();

	//terra
	glRotatef(angulo+0.5, 0, 1, 0);
	glTranslatef(-82, 0, 0);
	glPushMatrix();
	glRotatef(angulo, 0, 1, 0);
	glColor3f(0.0, 0.0, 1.0);
	glutWireSphere(10, 16, 16);
	glPopMatrix();

	//sol
	glRotatef(angulo+1, 0, 1, 0);
	glTranslatef(-22, 0, 0);
	glPushMatrix();
	glRotatef(angulo, 0, 1, 0);
	glColor3f(1.0, 1.0, 1.0);
	glutWireSphere(5, 16, 16);
	glPopMatrix();

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