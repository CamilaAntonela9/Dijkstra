package lista;
public class Nodo {
    Nodo siguienteNodo;
    Nodo Anterior;
    Datos datos;
    
    public Nodo() {
        datos=null;
        siguienteNodo=null;
    }
    public Nodo(Datos dato) {
        datos=dato;
        siguienteNodo=null;
    }
	public Nodo getSiguienteNodo() {
		return siguienteNodo;
	}
	public void setSiguienteNodo(Nodo siguienteNodo) {
		this.siguienteNodo = siguienteNodo;
	}
	public Datos getDatos() {
		return datos;
	}
	public void setDatos(Datos datos) {
		this.datos = datos;
	}  
	
    public String getNombre() {
    	return datos.getNombre();
    }
    public String getApellido() {
    	return datos.getApellido();
    }
    public String getColor() {
    	return datos.getColorCarro();
    }
    public String getModelo() {
    	return datos.getModelo();
    }
    public Double getPrecio() {
    	return datos.getPrecio();
    }
    public Integer getCedula() {
    	return datos.getCedula();
    }
	public Nodo getAnterior() {
		return Anterior;
	}
	public void setAnterior(Nodo anterior) {
		Anterior = anterior;
	}
    
}
