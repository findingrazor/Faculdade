#include<GL/glut.h>

float anguloCam = 0.0;
float cabeca = 0.0;
float bracoEs = 0.0;
float bracoDi = 0.0;

void DefineRecorteCamera(void) {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(60, 1, 10, 600);

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(0, 0, 400, 0, 0, 0, 0, 1, 0);
	glRotatef(anguloCam, 0, 1, 0);


	glEnable(GL_DEPTH_TEST);
}

void DefineExibicao(void) {
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport(0, 0, 400, 400);
}

void Desenha(void) {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	//cabeca
	glPushMatrix();
	glTranslatef(0, 30, 0);
	glColor3f(1, 0.8, 0.8);
	glRotatef(cabeca, 0, 1, 0);
	glutSolidSphere(40, 12, 12);
	glColor3f(0, 0.8, 0.8);
	glutWireSphere(40, 12, 12);
	glPopMatrix();

	//tronco
	glPushMatrix();
	glTranslatef(0, -50, 0);
	glColor3f(0.4, 1, 0.8);
	glScalef(1, +2, 1);
	glutSolidCube(50);
	glPopMatrix();

	//braço esquerdo
	glPushMatrix();
	glTranslatef(30, -20, 0);
	glPushMatrix();
	glRotatef(bracoEs, 0, 0, 1);
	glTranslatef(0, -30, 0);
	glColor3f(1, 0.2, 0.9);
	glScalef(1, +2, 1);
	glutSolidCube(30);
	glPopMatrix();
	glPopMatrix();

	//braço direito
	glPushMatrix();
	glTranslatef(-30, -20, 0);
	glPushMatrix();
	glRotatef(bracoDi, 0, 0, 1);
	glTranslatef(0, -30, 0);
	glColor3f(0.2, 1, 0.4);
	glScalef(1, +2, 1);
	glutSolidCube(30);
	glPopMatrix();
	glPopMatrix();

	//perna esquerda
	glPushMatrix();
	glTranslatef(10, -85, 0);
	glColor3f(1, 0.4, 0.4);
	glScalef(1, +5, 1);
	glutSolidCube(20);
	glPopMatrix();

	//perna direita
	glPushMatrix();
	glTranslatef(-10, -85, 0);
	glColor3f(0.1, 0.6, 0.9);
	glScalef(1, +5, 1);
	glutSolidCube(20);
	glPopMatrix();

	//chao
	glBegin(GL_QUADS);
	glColor3f(1, 1, 1);
	glVertex3f(-150, -150, -150);
	glVertex3f(150, -150, -150);
	glVertex3f(150, -150, 150);
	glVertex3f(-150, -150, 150);
	glEnd();

	glFlush();
}

void Inicializa(void) {
	glClearColor(0.0, 0.0, 0.0, 1.0);
	DefineRecorteCamera();
}

void Anima(int)
{
	//angulo += 1;
	glutPostRedisplay();
	glutTimerFunc(13, Anima, 1);
}

void Teclas(int key, int x, int y) {

	if (key == GLUT_KEY_UP) {
		bracoDi += 1;
	}
	if (key == GLUT_KEY_DOWN) {
		bracoDi -= 1;
	}
	if (key == GLUT_KEY_LEFT)
	{
		cabeca -= 1;
	}
	if (key == GLUT_KEY_RIGHT)
	{
		cabeca += 1;
	}
	if (key == GLUT_KEY_PAGE_UP)
	{
		bracoEs += 1;
	}
	if (key == GLUT_KEY_PAGE_DOWN)
	{
		bracoEs -= 1;
	}
	if (key == GLUT_KEY_HOME)
	{
		anguloCam -= 3;
	}
	if (key == GLUT_KEY_END)
	{
		anguloCam += 3;
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
	glutSpecialFunc(Teclas);
	Anima(1);
	glutMainLoop();
}