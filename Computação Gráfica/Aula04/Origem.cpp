#include<GL/glut.h>

int angulo = 0;

void DefineRecorteCamera(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	//glOrtho(-65, 65, -65, 65, -400, 400);
	gluPerspective(60, 1, 10, 400);

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(0, 0, 200, 0, 0, 0, 0, 1, 0);
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
	angulo += 2;
	glutPostRedisplay();
	glutTimerFunc(9, Anima, 1);
}

void Desenha(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glPushMatrix();
	glRotatef(angulo, 0, 1, 0);

	//meio
	glPushMatrix();
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//lateral esquerda
	glPushMatrix();
	glTranslatef(-22.0, 0.0, 0.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//lateral direita
	glPushMatrix();
	glTranslatef(+22.0, 0.0, 0.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//atr s
	glPushMatrix();
	glTranslatef(0.0, 0.0, -22.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//frente
	glPushMatrix();
	glTranslatef(0.0, 0.0, +22.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//topo
	glPushMatrix();
	glTranslatef(0.0, +22.0, 0.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	//fundo
	glPushMatrix();
	glTranslatef(0.0, -22.0, 0.0);
	glColor3f(0.6, 0.7, 1.0);
	glutSolidCube(20);
	glColor3f(0.0, 0.0, 1.0);
	glutWireCube(20);
	glPopMatrix();

	glPopMatrix();
	glFlush();
}

void Inicializa(void)
{
	glClearColor(1.0, 1.0, 1.0, 1.0);
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