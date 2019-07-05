import java.util.Scanner;

public class Trapecios {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, h,n, sumatoria=0;
		Trapecios main = new Trapecios();
		System.out.println("Digite el valor de A : ");
		a = sc.nextDouble();
		System.out.println("Digite el valor de B");
		b = sc.nextDouble();
		System.out.println("Digite el valor de N : ");
		n = sc.nextDouble();
		h = main.calculateH(a, b, n);
		double multiplicate = h / 2;
		double f_a = main.calculateFuncion(a);
		double f_b = main.calculateFuncion(a);
		
		for (int i=1; i<n-1; i++ ) {
			double valor = a + (i*h);
			sumatoria += main.calculateFuncion(valor);
		}
		sumatoria *= 2;
		
		double suma = f_a + sumatoria  + f_b;
		double integral = multiplicate * suma;
		System.out.println("El resultado de la integral es " + integral);
		sc.close();
	}
	
	
	public double calculateH(double a, double b, double n) {
		return (b-a)/n;
	}
	
	public double calculateFuncion(double x) {
		return  Math.pow(1 + Math.pow(x/2, 2), 2) * Math.PI;
	}
}
