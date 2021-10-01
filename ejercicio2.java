package practica5;
import java.util.*;
public class ejercicio2 {
	static Scanner sc=new Scanner (System.in);
	static int [] a�os= {-1,-1,-1,-1,-1};

	public static void main(String[] args) {
		
		int resp;
		boolean continuar=true;
		Alumno [][]alumno=new Alumno[5][100];
		System.out.println("MENU\n"
				+ "1. Ingresar datos\n"
				+ "2. Consultar a�o\n"
				+ "3. Consultar todos\n"
				+ "4. Promedio ponderado por a�o\n"
				+ "5. Promedio ponderado de todos\n"
				+ "6. Mayor a�o\n"
				+ "7. Menor a�o\n"
				+ "8. Mayor todos\n"
				+ "9. Menor todos 10. Rankear a�o\n"
				+ "11. Rankear todos\n"
				+ "12. Salir\n");
		do {
			System.out.print("ingrese una opci�n: ");
			resp=sc.nextInt();
			switch(resp) {
			case 1:
				ingresarDatos(alumno);
				break;
			case 2:
				consultarA�o(alumno);
				break;
			case 3:
				consultarTodos(alumno);
				break;
			case 4:
				PromedioPorA�o(alumno);
				break;
			case 5:
				PromedioDeTodos(alumno);
				break;
			case 6:
				mayorPromedioPorA�o(alumno);
				break;
			case 7:
				menorPromedioPorA�o(alumno);
				break;
			case 8:
				mayorPromedioTodos(alumno);
				break;
			case 9:
				menorPromedioTodos(alumno);
				break;
			case 10:
				rankearPorA�o(alumno);
				break;
			case 11:
				rankearTodos(alumno);
				break;
			case 12:
				continuar = false ;
			}
		}while(continuar);	
	}
	public static void ingresarDatos(Alumno [][]a) {
		int a�o,edad,cont,resp;
		String nombre;
		double promedio;
		
		do {
			System.out.print("Ingrese a�o de estudios: ");
			a�o=sc.nextInt();
			a�os[a�o-1]++;
			cont=a�os[a�o-1];
			System.out.print("Ingrese nombre: ");
			nombre=sc.next();
			System.out.print("Ingrese edad: ");
			edad=sc.nextInt();
			System.out.print("Ingrese promedio: ");
			promedio=sc.nextDouble();
			a[a�o-1][cont]=new Alumno(nombre,edad,promedio);
			System.out.println("�Desea ingresar datos de otro alumno? 1.Si 2.No");
			resp=sc.nextInt();
		}while(resp == 1);
				
	}
	public static void consultarA�o(Alumno [][]a) {
		int a�o;
		System.out.println("ingrese a�o de estudios: ");
		a�o=sc.nextInt();
		for(int i=0;i<a[a�o-1].length;i++) {
			if(a[a�o-1][i] == null)
				break;
			System.out.println(a[a�o-1][i].getNombre());
		}	
	}
	public static void consultarTodos(Alumno [][]a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(">>>>>>>>>>>"+(i+1)+"� A�O");
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				System.out.println((j+1)+".- "+a[i][j].getNombre());
			}
		}		
	}
	public static void PromedioPorA�o(Alumno [][]a) {
		int suma,cont;
		double promedio;
		for(int i=0;i<a.length;i++) {
			suma=0;
			cont=0;
			System.out.println(">>>>>>>>>>>"+(i+1)+"� A�O");
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				cont ++;
				suma+= a[i][j].getPromedioPonderado();
			}
			promedio=(double)suma/cont;
			System.out.printf("promedio ponderado: %.2f\n",promedio);
		}
	}
	public static void PromedioDeTodos(Alumno [][]a) {
		int suma=0,cont=0;
		double promedio=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				cont ++;
				suma+= a[i][j].getPromedioPonderado();
			}
			promedio=(double)suma/cont;
		}
		System.out.printf("promedio ponderado de la EPIS: %.2f\n",promedio);
	}
	public static void mayorPromedioPorA�o(Alumno [][]a) {
		double mayor;
		System.out.println("Mayor promedio ponderado");
		for(int i=0;i<a.length; i++) {
			System.out.print((i+1)+"� A�O\t");
			mayor=0;
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				if(a[i][j].getPromedioPonderado()>mayor) 
					mayor=a[i][j].getPromedioPonderado();
			}
			System.out.println(mayor);
		}
	}
	public static void menorPromedioPorA�o(Alumno [][]a) {
		double menor;
		System.out.println("Menor promedio ponderado");
		for(int i=0;i<a.length; i++) {
			System.out.print((i+1)+"� A�O\t");
			menor=20;
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				if(a[i][j].getPromedioPonderado()<menor) 
					menor=a[i][j].getPromedioPonderado();
			}	
			System.out.println(menor);
		}
	}
	public static void mayorPromedioTodos(Alumno [][]a) {
		double mayor;
		System.out.println("Mayor promedio ponderado de la EPIS:");
		mayor=0;
		for(int i=0;i<a.length; i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				if(a[i][j].getPromedioPonderado()>mayor) 
					mayor=a[i][j].getPromedioPonderado();
			}
		}
		System.out.println(mayor);
	}
	public static void menorPromedioTodos(Alumno [][]a) {
		double menor=20;
		System.out.println("Menor promedio ponderado de la EPIS:");
		for(int i=0;i<a.length; i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				if(a[i][j].getPromedioPonderado()<menor) 
					menor=a[i][j].getPromedioPonderado();
			}
			
		}
		System.out.println(menor);
	}
	public static void rankearPorA�o(Alumno [][]a) {
		Alumno []fila;
		for(int i=0;i<a.length;i++) {
			fila = new Alumno [a[i].length];
			System.out.println("\n>>>>>>>>>>>"+(i+1)+"� A�O");
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				fila[j]=a[i][j];
			}
			ordenarPorBurbuja(fila);
			imprimirRankin(fila);		
		}
	}
	public static void rankearTodos(Alumno [][]a) {
		Alumno []todos=new Alumno[500];
		int cont=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == null)
					break;
				todos[cont]=a[i][j];
				cont++;
			}
		}
		ordenarPorBurbuja(todos);
		imprimirRankin(todos);		
	}
	public static void ordenarPorBurbuja(Alumno []a) {
		for(int i=1;i<a.length;i++) {
			for(int j=0;j<a.length-i;j++) {
				if(a[j+1] == null)
					break;
				if(a[j].getPromedioPonderado()<a[j+1].getPromedioPonderado())
					intercambiar(a,j,j+1);
			}
		}	
	}
	public static void intercambiar(Alumno []a,int i,int j) {
		Alumno tmp;
		tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	public static void imprimirRankin(Alumno []a) {
		System.out.println("puesto\tnombre\tpromedio");
		for (int i=0;i<a.length;i++) {
			
			if(a[i] == null)
				break;
			System.out.println((i+1)+"\t"+a[i].getNombre()+"\t"+a[i].getPromedioPonderado());
		}
	}

}
