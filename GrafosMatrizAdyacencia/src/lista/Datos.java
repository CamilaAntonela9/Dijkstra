package lista;

public class Datos {
	//------------------------------------------------------
	//				Atributos tipo genericos 
	//------------------------------------------------------
	String nombre;
	String apellido;
	String colorCarro;
	String modelo;
	Double precio;
	Integer cedula;
	//------------------------------------------------------
	// 					Constructor Vacio
	//------------------------------------------------------
	public Datos() {
		nombre=null;
		apellido=null;
		colorCarro=null;
		modelo=null;
		precio=null;
		cedula=null;
	}
	//------------------------------------------------------
	// 					Constructor sobre cargado
	//------------------------------------------------------
	public Datos(String nombre, String apellido, String colorCarro, String modelo, Double precio, Integer cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.colorCarro= colorCarro;
		this.modelo= modelo;		
		this.precio=precio;
		this.cedula=cedula;
	}
	public Datos(Integer cedula) {
		nombre=null;
		apellido=null;
		colorCarro=null;
		modelo=null;
		precio=null;
		this.cedula=cedula;
	}
	//------------------------------------------------------
	// 					GETTERS Y SETTERS
	//------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getColorCarro() {
		return colorCarro;
	}
	public void setColorCarro(String colorCarro) {
		this.colorCarro = colorCarro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}	
}
