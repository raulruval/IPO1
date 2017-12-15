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
	
	
	public static ArrayList<Proyecto> inicializar() {
		Usuario us1 = new Usuario("Pepe Rodriguez Romero", "Profesor", null, tareas1, "38 años y soltero",
				"Estudio en michigan", "Economia, matematicas, etc..");
		Usuario us2 = new Usuario("Raul Sanchez Romerijo", "Economico", null, tareas2, "27 años y recien titulado",
				"Estudio en Ciudad Real", "Economia de pimes");
		Usuario us3 = new Usuario("Inés Cepeda Ruiz", "Secretaria", null, tareas1, "39 años y experimentada",
				"Gran experiencia en el mundo de la empresa", "Economia, matematicas, etc..");
		Usuario us4 = new Usuario("Raquel Marquez Salguero", "Gerente", null, tareas3, "29 años",
				"Master en economicas", "Gran curriculum");
		
		usuarios1.add(us1);
		usuarios1.add(us2);
		usuarios1.add(us3);
		usuarios1.add(us4);
		
		Usuario us5 = new Usuario("Pilar Salguero Hinarejos", "Administrativa", null, tareas1, "47 años",
				"Estudio en Toledo", "Economia, matematicas, etc..");
		Usuario us6 = new Usuario("Jaime Martin Navarro", "Limpiador", null, tareas3, "57 años",
				" ", "Habilidoso y efectivo");
		Usuario us7 = new Usuario("Ionut Florin Santori", "Estudiante", null, tareas1, "39 años",
				" ", " ");
		Usuario us8 = new Usuario("Pilar Ruiz Sanchez", "RRPP", null, tareas2, "29 años",
				"Publicidad y marketing", "Gran curriculum");
		
		usuarios2.add(us5);
		usuarios2.add(us6);
		usuarios2.add(us7);
		usuarios2.add(us8);
		
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
				"En este proyecto aprenderas a dirigir tu propia economía", usuarios1, tareas2, us2);
		Proyecto pro2 = new Proyecto("Biotecnología", "Importante en el apartado de desarrollo", usuarios3, tareas3, us4);
		Proyecto pro3=new Proyecto("Física Cuántica", "Desarrollo y teoría", usuarios1, tareas2, us4);
		Proyecto pro4=new Proyecto("Historia de Ciudad Real", "Desde 1800 hasta 2000", usuarios3, tareas1, us7);
		
		proyectos.add(pro4);
		proyectos.add(pro3);
		proyectos.add(pro2);
		proyectos.add(pro1);
		
		
		
		return proyectos;
	}

}
