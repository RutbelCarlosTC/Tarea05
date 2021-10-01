package practica5;

public class Alumno {
	
	private String nombre;
	private int edad;
	private double promedioPonderado;
	
	public Alumno(String nombre,int edad,double promedio) {
		setNombre(nombre);
		setEdad(edad);
		setPromedioPonderado(promedio);
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public void setPromedioPonderado(double promedio) {
		this.promedioPonderado=promedio;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getEdad() {
		return this.edad;
	}
	public double getPromedioPonderado() {
		return this.promedioPonderado;
	}

}
