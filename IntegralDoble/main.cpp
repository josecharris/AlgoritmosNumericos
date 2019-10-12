
#include <cstdlib>
#include <math.h>
#include <stdio.h>
#include <iostream>
using namespace std;

/*
 * 
 */
float funcionCx( float x){
    return x;
    
}
float funcionDx(float x){
    float e,y;
    e=exp(1);
    y=pow(e,x);
    return y;
}
float f(float x, float y){
    float r;
    r= pow(x,2)+pow(y,2);
    return r;    
}
float sum1(float x,float a,float h,int lim,int ini,int inc){
    float suma=0;
    for(int i=ini;i<lim;i+=inc){
        suma=suma+f(x,a+i*h);
    }
    return suma;
}

float inteInterna(float x) {
    float c=0,d=0,hy,suma1,suma2,suma3,suma,resultado;
    c=funcionCx(x);
    d=funcionDx(x);
    int n=12;
    hy=(d-c)/n;
    suma1=(32*sum1(x,c,hy,n,1,2));
    suma2=12*sum1(x,c,hy,(n-1),2,4);
    suma3= 14*sum1(x,c,hy,(n-3),4,4);
    suma=(7*f(x,c))+suma1+suma2+suma3+(7*f(x,d));
    resultado=(2*hy/45)*suma;    
    return resultado;
}
float trap(float a,float h,int lim,int ini,float b){
    float suma=0;
    for(int i=ini;i<lim;i++){
        suma=suma+inteInterna(a+i*h);
    }
    suma=(2*suma)+inteInterna(a)+inteInterna(b);
    return suma;
}
int main(){
    float a=0,b=3,hx,suma,resultado;
    int n=200;
    hx=(b-a)/n;
    suma=(trap(a,hx,n,1,b));
    resultado=(hx/2)*suma;
    printf("%f", resultado);
    return 0;
    
}