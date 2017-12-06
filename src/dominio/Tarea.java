package dominio;


public class Tarea {
 String nombre;
 Usuario encargado;
 String fechafinal;
 String etiquetas;
 String comentarios;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Usuario getEncargado() {
	return encargado;
}
public void setEncargado(Usuario encargado) {
	this.encargado = encargado;
}
public String getFechafinal() {
	return fechafinal;
}
public void setFechafinal(String fechafinal) {
	this.fechafinal = fechafinal;
}
public String getEtiquetas() {
	return etiquetas;
}
public void setEtiquetas(String etiquetas) {
	this.etiquetas = etiquetas;
}
public String getComentarios() {
	return comentarios;
}
public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}
public Tarea(String nombre, Usuario encargado, String fechafinal, String etiquetas, String comentarios) {
	super();
	this.nombre = nombre;
	this.encargado = encargado;
	this.fechafinal = fechafinal;
	this.etiquetas = etiquetas;
	this.comentarios = comentarios;
}
}
