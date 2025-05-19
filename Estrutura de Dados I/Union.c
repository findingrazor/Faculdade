#include <stdio.h>
#include <string.h>

// Define a union
/*union Data {
   int a;
   float b;
   char c[20];
};

int main() {
   union Data data;

   // Printing the size of the each member of union
   printf("Size of a: %lu bytes\n", sizeof(data.a));
   printf("Size of b: %lu bytes\n", sizeof(data.b));
   printf("Size of c: %lu bytes\n", sizeof(data.c));

   // Printing the size of the union
   printf("Size of union: %lu bytes\n", sizeof(data));

   return 0;
}*/

union Data{
   int i;
   float f;
   char str[20];
};

int main(){

   union Data data;

   data.i = 10;
   printf("data.i: %d \n", data.i);

   data.f = 220.5;
   printf("data.f: %f \n", data.f);

   strcpy(data.str, "C Programming");
   printf("data.str: %s \n", data.str);
   return 0;
}
