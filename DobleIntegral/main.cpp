#include <math.h>
#include <cstdlib>
#include <stdio.h>
#include <iostream>
float funcionCx(float x) {

    return x;

}

float funcionDx(float x, std::string dx) {
    
    float e, y;

    if(dx.compare("e^x")){
        
        
    e = exp(1);

    y = pow(e, x);
    
    return y;
        
    }
    

}
//, std::string funcio
float f(float x, float y) {

    float result;
    std::string funcion="x+y";
    if (funcion.compare("x^2+y^2")) {

        result = pow(x, 2) + pow(y, 2);

        return result;

    } else if( funcion.compare("x^2+y") ){
        
        result = pow(x,2)+y;
        
        return result;
        
    }else if( funcion.compare("x+y^2") ){
        
        result = x+pow(x,2);
        
        return result;
        
    }else if( funcion.compare( "x+y" ) ){
        
        result = x+y;
        
        return result;
        
    } else if( funcion.compare("x-y") ){
        
        result = x-y;
        
        return result;
        
    } else if( funcion.compare("x^2-y") ){
        
        result = pow(x,2)-y;
        
        return result;
        
    } else if( funcion.compare("x-y^2") ){
        
        result = x-pow(y,2);
        
        return result;
        
    }else if( funcion.compare("x*y") ){
        
        result = x*y;
        
        return result;
        
    }else if( funcion.compare("x^2*y") ){
        
        result = pow(x,2)*y;
        
        return result;
        
    }else if( funcion.compare("x*y^2") ){
        
        result = x*pow(y,2);
        
        return result;
        
    }else if( funcion.compare("x/y") ){
        
        result = x/y;
        
        return result;
        
    }



}

float sum1(float x, float a, float h, int limit, int inicio, int inc, std::string f) {

    float acum = 0;

    for (int i = inicio; i < limit; i += inc) {

        acum = acum+f(x,a+i*h);

    }

    return acum;

}

float integralInterna(float x, std::string f, std::string dx) {

    float c = 0, d = 0, hy, suma1, suma2, suma3, suma, resultado;

    int n = 12;

    c = funcionCx(x);

    d = funcionDx(x, dx);

    hy = (d - c) / n;

    suma1 = (32 * sum1(x, c, hy, n, 1,2 ,f));

    suma2 = 12 * sum1(x, c, hy, (n - 1), 2, 4,f);

    suma3 = 14 * sum1(x, c, hy, (n - 3), 4, 4,f);

    suma = (7*f(x,c))+suma1+suma2+suma3+(7*f(x,d));

    resultado = (2 * hy / 45) * suma;

    return resultado;

}

float integralExterna(float a, int limite, int inicio, float b,std::string f,std::string dx) {

    float hx = (b - a) / limite;

    float suma = 0;

    for (int i = inicio; i < limite; i++) {

        suma = suma + integralInterna(a + i * hx,f,dx);
    }

    suma = (2 * suma) + integralInterna(a,f,dx) + integralInterna(b,f,dx);


    return (hx / 2)*suma;

}
int main() {

    
    float a = 0, b = 3, suma;
    int n = 200;    
    std::string funcion = "x+y";
    std::string cx = "e^x";    
    suma =integralExterna(a,n,1,b,funcion,cx);
    printf("%f", suma);
    return 0;
}
