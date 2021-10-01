package practica5;
import java.util.Scanner;
public class tiemposVuelo {
	static String []ciudades= {"AQP","JUL","CUZ","TCQ","LIM"};
	static  int [][]tiempos= {{0,22,30,42,57},{23,0,15,25,58},{31,17,0,24,30},{45,27,25,0,95},{59,58,30,97,0}};

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		int partida, llegada;
		mostrarTablaTiemposVuelo();
		for(int i=0;i<ciudades.length;i++) {
			System.out.println((i+1)+" = "+ciudades[i]);
		}
		System.out.println();
		System.out.print("ingrese el numero de ciudad de partida: ");
		partida = sc.nextInt();
		System.out.print("ingrese el numero de ciudad de llegada: ");
		llegada = sc.nextInt();
		System.out.println("tiempo de vuelo: "+preguntarPorTiempoVuelo(partida,llegada));
		
	}
	public static void mostrarTablaTiemposVuelo() {
		for(String e: ciudades) {
			System.out.print("\t"+e);
		}
		System.out.println();
		for(int i=0;i<tiempos.length;i++) {
			System.out.print(ciudades[i]+"\t");
			for(int j=0;j<tiempos[i].length;j++) {
				System.out.print(tiempos[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	public static int preguntarPorTiempoVuelo(int a, int b) {
		return tiempos[a-1][b-1];
	}

}
