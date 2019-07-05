import java.util.Scanner;

public class Simpson3Octavos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, h,n, sumatoria1=0, sumatoria2=0, sumatoria3=0;;
		Simpson3Octavos main = new Simpson3Octavos();
		System.out.println("Digite el valor de A : ");
		a = sc.nextDouble();
		System.out.println("Digite el valor de B");
		b = sc.nextDouble();
		System.out.println("Digite el valor de N : ");
		n = sc.nextDouble();
		h = main.calculateH(a, b, n);
		double multiplicate = h * 0.375;
		
		double f_a = main.calculateFuncion(a);
		double f_b = main.calculateFuncion(a);
		
		for (int i=1; i<n-2; i=i+3 ) {
			double valor = a + (i*h);
			sumatoria1 += main.calculateFuncion(valor);
		}
		sumatoria1 *= 3;		
		for (int i=2;i<n-1; i=i+3) {
			sumatoria2 += main.calculateFuncion(a + (i*h));
		}
		sumatoria2 *= 3;
		
		for (int i=3;i<n-3; i=i+3) {
			sumatoria3 += main.calculateFuncion(a + (i*h));
		}
		sumatoria3 *= 2;
		double suma = f_a + sumatoria1 + sumatoria2 + sumatoria3 + f_b;
		double integral = multiplicate * suma;
		System.out.println("Resultado de la integral : "+integral);
		sc.close();
	}
	
	public double calculateH(double a, double b, double n) {
		return (b-a)/n;
	}
	
	public double calculateFuncion(double x) {
		return  Math.pow(1 + Math.pow(x/2, 2), 2) * Math.PI;
	}
}
