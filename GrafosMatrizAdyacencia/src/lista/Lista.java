package lista;
import java.util.ArrayList;
import java.util.List;
public class Lista{
    Nodo primero;
    Nodo ultimo;
	Nodo actual;
	Nodo nodoAnterior;
	
	int contador=1;
    public Lista() {
        primero = null;
        ultimo= null;
    }
    public Lista(Nodo nodoIngresado) {
    	primero=nodoIngresado;
    	ultimo=primero;
    }    
    public boolean estaVacia() {
        return primero == null;
    }
    public void insertar(Datos datos) {
        Nodo nuevoNodo = new Nodo(datos);
        //----------------------------------------------------------
        //Caso base cuando solo tenemos un nodo en la lista
        //----------------------------------------------------------
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo= nuevoNodo;
        } else {
            ultimo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
    }
    public List<Datos> getNodos() {
        List<Datos> listaNodos = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            listaNodos.add(actual.getDatos());
            actual = actual.getSiguienteNodo();
        }
        
        return listaNodos;
    }

    public Nodo getPrimero() {
		return primero;
	}
	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}
	public Nodo getUltimo() {
		return ultimo;
	}
	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
	public Nodo getActual() {
		return actual;
	}
	public void setActual(Nodo actual) {
		this.actual = actual;
	}
	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}
	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
        } else {        	
            for(actual=primero;actual!=null; actual=actual.getSiguienteNodo()) {            	
            		System.out.println("----------------------------------------------");
            		System.out.println("                  Cliente#"+contador);
            		System.out.println("----------------------------------------------");
		            Datos datos = actual.getDatos();
		            System.out.println("Nombre: " + datos.getNombre());
		            System.out.println("Apellido: " + datos.getApellido());
		            System.out.println("Color de carro: " + datos.getColorCarro());
		            System.out.println("Modelo: " + datos.getModelo());
		            System.out.println("Precio: " + datos.getPrecio());
		            System.out.println("Cédula: " + datos.getCedula());
		            contador=contador+1;
            }
        }
    }
  
    public Nodo buscar(Nodo nodoBuscar) {
    	if(estaVacia()) {
    		System.out.println("La lista se encuentra Vacía");
    	}
    	else {
    		for(actual=primero; actual!=null; actual=actual.getSiguienteNodo()) {
    			if(nodoBuscar.getCedula()==actual.getCedula()) {
    				return actual;
    			}
    		}    		
    	}
		return null;
    }
    void mostrarNodoEncontrado(Nodo nodo) {
        Datos datos = nodo.getDatos();
    	System.out.println("----------------------------------------------");
		System.out.println("                Cliente["+datos.getCedula()+"]");
		System.out.println("----------------------------------------------");
        System.out.println("Nombre: " + datos.getNombre());
        System.out.println("Apellido: " + datos.getApellido());
        System.out.println("Color de carro: " + datos.getColorCarro());
        System.out.println("Modelo: " + datos.getModelo());
        System.out.println("Precio: " + datos.getPrecio());
        System.out.println("Cédula: " + datos.getCedula());
    }
    //Método extra "sizeLista" Me retorna la cantidad de clientes que tengo
    int sizeLista() {
    	contador=0;
		for(actual=primero; actual!=null; actual=actual.getSiguienteNodo()) {
			contador=contador+1;
		} 
		return contador;
    }
	public void eliminarNodo(Nodo nodoEliminar ) {
		Nodo nodoBuscado = nodoEliminar;
	    Nodo nodoEncontrado = buscar(nodoBuscado);

	    if (nodoEncontrado != null) {
	        Nodo actual = primero;
	        Nodo anterior = null;

	        // Búsqueda del nodo y del anterior
	        while (actual != null && actual != nodoEncontrado) {
	            anterior = actual;
	            actual = actual.getSiguienteNodo();
	        }

	        // Enlace del nodo anterior con el siguiente
	        if (actual == primero) {
	            primero = actual.getSiguienteNodo();
	        } else {
	            anterior.setSiguienteNodo(actual.getSiguienteNodo());
	        }
	        System.out.println("Se eliminó correctamente el nodo");
	    } else {
	        System.out.println("No se encontró el nodo");
	    }
	}
	public void mostrarLista() {
	    if (estaVacia()) {
	        System.out.println("La lista está vacía");	      
	    } else {
	        int contador = 1;
	        Nodo actual = ultimo; // Comenzar desde el último nodo

	        while (actual != null) {
	            System.out.println("----------------------------------------------");
	            System.out.println("                  Cliente#" + contador);
	            System.out.println("----------------------------------------------");
	            Datos datos = actual.getDatos();
	            System.out.println("Nombre: " + datos.getNombre());
	            System.out.println("Apellido: " + datos.getApellido());
	            System.out.println("Color de carro: " + datos.getColorCarro());
	            System.out.println("Modelo: " + datos.getModelo());
	            System.out.println("Precio: " + datos.getPrecio());
	            System.out.println("Cédula: " + datos.getCedula());
	            contador++;
	            actual = actual.getAnterior(); // Mover al nodo anterior
	        }
	    }
	}
	public List<Integer> obtenerListaIds() {
        List<Integer> idList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            idList.add(actual.getDatos().getCedula());
            actual = actual.getSiguienteNodo();
        }
        
        return idList;
    }
    
    public List<String> obtenerListaNombres() {
        List<String> nombreList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            nombreList.add(actual.getDatos().getNombre());
            actual = actual.getSiguienteNodo();
        }
        
        return nombreList;
    }
    
    public List<String> obtenerListaApellidos() {
        List<String> apellidoList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            apellidoList.add(actual.getDatos().getApellido());
            actual = actual.getSiguienteNodo();
        }
        
        return apellidoList;
    }
    
    public List<String> obtenerListaColoresCarro() {
        List<String> colorList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            colorList.add(actual.getDatos().getColorCarro());
            actual = actual.getSiguienteNodo();
        }
        
        return colorList;
    }
    
    public List<String> obtenerListaModelos() {
        List<String> modeloList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            modeloList.add(actual.getDatos().getModelo());
            actual = actual.getSiguienteNodo();
        }
        
        return modeloList;
    }
    
    public List<Double> obtenerListaPrecios() {
        List<Double> precioList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            precioList.add(actual.getDatos().getPrecio());
            actual = actual.getSiguienteNodo();
        }        
        return precioList;
    }
    
    public List<Integer> obtenerListaCedulas() {
        List<Integer> cedulaList = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            cedulaList.add(actual.getDatos().getCedula());
            actual = actual.getSiguienteNodo();
        }
        return cedulaList;
    }
}

