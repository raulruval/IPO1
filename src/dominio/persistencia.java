package dominio;

import java.util.ArrayList;

public class persistencia {
	static ArrayList<Usuario> usuarios1 = new ArrayList<Usuario>();
	static ArrayList<Usuario> usuarios2 = new ArrayList<Usuario>();
	static ArrayList<Usuario> usuarios3 = new ArrayList<Usuario>();
	
	static ArrayList<Tarea> tareas1=new ArrayList<Tarea>();
	static ArrayList<Tarea> tareas2=new ArrayList<Tarea>();
	static ArrayList<Tarea> tareas3=new ArrayList<Tarea>();
	
	static ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	static ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
	static ArrayList<Tarea> tareas=new ArrayList<Tarea>();
	static ArrayList<Mensaje> mensajes=new ArrayList<Mensaje>();
	static Usuario us1;
	static Usuario us2;
	static Usuario us3;
	static Usuario us4;
	
	
	public static ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}
	public static ArrayList<Proyecto> inicializar() {
		us1 = new Usuario("Pepe Rodriguez Romero", "Profesor", "38 años y soltero",
				"Estudio en michigan", "Economia, matematicas, etc..");
		us2 = new Usuario("Raul Sanchez Romerijo", "Economico", "27 años y recien titulado",
				"Estudio en Ciudad Real", "Economia de pimes");
		us3 = new Usuario("Inés Cepeda Ruiz", "Secretaria", "39 años y experimentada",
				"Gran experiencia en el mundo de la empresa", "Economia, matematicas, etc..");
		us4 = new Usuario("Raquel Marquez Salguero", "Gerente", "29 años",
				"Master en economicas", "Gran curriculum");
		
		usuarios1.add(us1);
		usuarios.add(us1);
		usuarios1.add(us2);
		usuarios.add(us2);
		usuarios1.add(us3);
		usuarios.add(us3);
		usuarios1.add(us4);
		usuarios.add(us4);
		
		Usuario us5 = new Usuario("Pilar Salguero Hinarejos", "Administrativa", "47 años",
				"Estudio en Toledo", "Economia, matematicas, etc..");
		Usuario us6 = new Usuario("Jaime Martin Navarro", "Limpiador", "57 años",
				" ", "Habilidoso y efectivo");
		Usuario us7 = new Usuario("Ionut Florin Santori", "Estudiante", "39 años",
				" ", " ");
		Usuario us8 = new Usuario("Pilar Ruiz Sanchez", "RRPP", "29 años",
				"Publicidad y marketing", "Gran curriculum");
		
		usuarios2.add(us5);
		usuarios.add(us5);
		usuarios2.add(us6);
		usuarios.add(us6);
		usuarios2.add(us7);
		usuarios.add(us7);
		usuarios2.add(us8);
		usuarios.add(us8);
		
		usuarios3.add(us1);
		usuarios3.add(us4);
		usuarios3.add(us3);
		usuarios3.add(us7);
		
		Tarea tar1=new Tarea("Especificacion de requisitos", us3, "25/12/17", "Importante tareas ", "Importante realizar ya");
		Tarea tar2= new Tarea("Diseño de interfaz", us4, "14/04/18", "realizar paralelizable", " ");
		Tarea tar3=new Tarea("Limpieza de la sala", us7, "07/12/17", " limpiar todo", "");
		Tarea tar4=new Tarea("Realizar balances", us2, "14/12/17", "", "Enviar por correo al gerente");
				
		tareas1.add(tar1);
		tareas1.add(tar4);
		
		tareas2.add(tar3);
		tareas2.add(tar2);
		tareas2.add(tar1);
		
		tareas3.add(tar4);
		tareas3.add(tar2);
		
		Proyecto pro1 = new Proyecto("Economía de la empresa",
				"En este proyecto aprenderas a dirigir tu propia economía", usuarios2, tareas2, us2);
		Proyecto pro2 = new Proyecto("Biotecnología", "Importante en el apartado de desarrollo", usuarios3, tareas3, us4);
		Proyecto pro3=new Proyecto("Física Cuántica", "Desarrollo y teoría", usuarios1, tareas2, us4);
		Proyecto pro4=new Proyecto("Historia de Ciudad Real", "Desde 1800 hasta 2000", usuarios3, tareas1, us7);
		
		proyectos.add(pro4);
		proyectos.add(pro3);
		proyectos.add(pro2);
		proyectos.add(pro1);
		
		
		return proyectos;
	}
	public static ArrayList<Tarea> getTareas(){
		return tareas;
	}
	
	public static ArrayList<Usuario> getusuarios(){
		return usuarios;
	}
	public static void aniadeproyecto(Proyecto pro){
		proyectos.add(pro);
	}
	public static ArrayList<Mensaje> getmensajes(){
		Mensaje men1=new Mensaje("Tutoria",us1, "Podriamos quedar mañana a las 17.00 para resolver una duda");
		Mensaje men2=new Mensaje("Información", us4, "El próximo dia 17 tendrá lugar una reunión para tratar la economía");
		Mensaje men3= new Mensaje("DAI ESI", us3, "Recordamos que ya están disponibles las camisetas");
		Mensaje men4=new Mensaje("Spotify", us2, "Llevate tres meses gratis por estas navidades");
		
		mensajes.add(men1);
		mensajes.add(men2);
		mensajes.add(men3);
		mensajes.add(men4);
		
		return mensajes;
	}
 public static void vaciartodo(){
	 int num=usuarios.size()/2;
	 while(usuarios.size()>num){
		 usuarios.remove(0);
	 }
	 num=usuarios1.size()/2;
	 while(usuarios1.size()>num){
		 usuarios1.remove(0);
	 }
	 num=usuarios2.size()/2;
	 while(usuarios2.size()>num){
		 usuarios2.remove(0);
	 }
	 num=usuarios3.size()/2;
	 while(usuarios3.size()>num){
		 usuarios3.remove(0);
	 }
	 num=tareas1.size()/2;
	 while(tareas1.size()>num){
		 tareas1.remove(0);
	 }
	 num=tareas2.size()/2;
	 while(tareas2.size()>num){
		 tareas2.remove(0);
	 }
	 num=tareas3.size()/2;
	 while(tareas3.size()>num){
		 tareas3.remove(0);
	 }
	 num=tareas.size()/2;
	 while(tareas.size()>num){
		 tareas.remove(0);
	 }
	 num=mensajes.size()/2;
	 while(mensajes.size()>num){
		 mensajes.remove(0);
	 }
	 num=proyectos.size()/2;
	 while(proyectos.size()>num){
		 proyectos.remove(0);
	 }
 }
}
