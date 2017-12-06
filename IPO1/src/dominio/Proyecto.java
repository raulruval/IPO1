package dominio;

import java.util.ArrayList;

public class Proyecto {
 String nombre;
 String descripcion;
 ArrayList<Usuario> miembros=new ArrayList<Usuario>();
 ArrayList<Tarea> tareas= new ArrayList<Tarea>();
 Usuario responsable;
public Proyecto(String nombre, String descripcion, ArrayList<Usuario> miembros, ArrayList<Tarea> tareas,
		Usuario responsable) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.miembros = miembros;
	this.tareas = tareas;
	this.responsable = responsable;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public ArrayList<Usuario> getMiembros() {
	return miembros;
}
public void setMiembros(ArrayList<Usuario> miembros) {
	this.miembros = miembros;
}
public ArrayList<Tarea> getTareas() {
	return tareas;
}
public void setTareas(ArrayList<Tarea> tareas) {
	this.tareas = tareas;
}
public Usuario getResponsable() {
	return responsable;
}
public void setResponsable(Usuario responsable) {
	this.responsable = responsable;
}
}
