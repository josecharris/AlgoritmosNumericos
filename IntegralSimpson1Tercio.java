import java.util.Scanner;

public class Simpson1Tercio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, h,n, multiplicando, sum_par=0, sum_impar=0;
		Simpson1Tercio main = new Simpson1Tercio();
		System.out.println("Digite el valor de A : ");
		a = sc.nextDouble();
		System.out.println("Digite el valor de B");
		b = sc.nextDouble();
		System.out.println("Digite el valor de N : ");
		n = sc.nextDouble();
		h = main.calculateH(a, b, n);
		double multiplicate = h / 3;
		
		for (int i=1; i<n-1; i=i+2 ) {
			double valor = a + (i*h);
			sum_impar += main.calculateFuncion(valor);
		}
		sum_impar *= 4;
		
		for (int i=2;i<n-2; i=i+2) {
			sum_par += main.calculateFuncion(a + (i*h));
		}
		
		sum_par *= 2;
		double suma = sum_impar + sum_par;
		
		multiplicando = main.calculateFuncion(a);
		multiplicando += suma;
		multiplicando += main.calculateFuncion(b);
		
		double integral = multiplicate * multiplicando;
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
