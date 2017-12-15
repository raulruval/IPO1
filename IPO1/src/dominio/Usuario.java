package dominio;

import java.util.ArrayList;

public class Usuario {
 String nombre;
 String rol;
 Proyecto proyectos;
 ArrayList<Tarea> tareas=new ArrayList<Tarea>();
 String informacion;
 String conocimientos;
 String habilidades;
public Usuario(String nombre, String rol, Proyecto proyectos, ArrayList<Tarea> tareas, String informacion,
		String conocimientos, String habilidades) {
	super();
	this.nombre = nombre;
	this.rol = rol;
	this.proyectos = proyectos;
	this.tareas = tareas;
	this.informacion = informacion;
	this.conocimientos = conocimientos;
	this.habilidades = habilidades;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getRol() {
	return rol;
}
public void setRol(String rol) {
	this.rol = rol;
}
public Proyecto getProyectos() {
	return proyectos;
}
public void setProyectos(Proyecto proyectos) {
	this.proyectos = proyectos;
}
public ArrayList<Tarea> getTareas() {
	return tareas;
}
public void setTareas(ArrayList<Tarea> tareas) {
	this.tareas = tareas;
}
public String getInformacion() {
	return informacion;
}
public void setInformacion(String informacion) {
	this.informacion = informacion;
}
public String getConocimientos() {
	return conocimientos;
}
public void setConocimientos(String conocimientos) {
	this.conocimientos = conocimientos;
}
public String getHabilidades() {
	return habilidades;
}
public void setHabilidades(String habilidades) {
	this.habilidades = habilidades;
}
 
}
