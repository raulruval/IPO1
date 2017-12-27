package dominio;

public class Mensaje {
	String asunto;
	Usuario remitente;
	String contenido;
	public Mensaje(String asunto, Usuario remitente, String contenido) {
		super();
		this.asunto = asunto;
		this.remitente = remitente;
		this.contenido = contenido;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Usuario getRemitente() {
		return remitente;
	}
	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	

}
