
public class Main {

	public static void main(String[] args) {
	double []x={0.1,0.4,0.5,0.7,0.7,0.9};
	double[]y={0.61,0.92,0.99,1.52,1.47,2.03};
	double[]x2=new double[50];
	double[]xy=new double[50];
	double sumx=0;
	double sumy=0;
	double sumx2=0;
	double sumxy=0;
	System.out.println("i       xi         yi        xi^2                xiyi");
	for(int i=0;i<x.length;i++){
		x2[i]=x[i]*x[i];
		xy[i]=x[i]*y[i];
		System.out.println("---------------------------------------------------------------------");
		System.out.println(i+"|      "+i+x[i]+"|        "+y[i]+"|    "+x2[i]+"|   "+xy[i]);
		sumx=sumx+x[i];
		sumy=sumy+y[i];
		sumx2=sumx2+x2[i];
		sumxy=sumxy+xy[i];
		System.out.println("---------------------------------------------------------------------");

	}
	System.out.println("Sumatoria Xi= "+sumx);
	System.out.println("Sumatoria Yi= "+sumy);
	System.out.println("Sumatoria Xi^2= "+sumx2);
	System.out.println("Sumatoria XiYi= "+sumxy);
	
	}

}
