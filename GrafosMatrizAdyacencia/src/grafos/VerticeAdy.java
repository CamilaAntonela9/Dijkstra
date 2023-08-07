package grafos;
import lista.Lista;
public class VerticeAdy {
	String nombre;
	int numVertice;
	Lista lad;
	public VerticeAdy(String x)
	{
		nombre = x;
		numVertice = -1;
		lad = new Lista();
	}
}
