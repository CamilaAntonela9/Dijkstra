package grafos;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class RecorreGrafo {
	public static final int CLAVE = -1;

	public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
		int w, v;
		int[] m;
		v = g.numVertice(org);
		if (v < 0) throw new Exception("Vértice origen no existe");

		Queue<Integer> cola = new LinkedList<>(); // Utilizamos la interfaz Queue
		m = new int[g.getNumeroDeVertices()]; // Utilizamos getNumeroDeVertices()

		// inicializa los vértices como no marcados 
		for (int i = 0; i < g.getNumeroDeVertices(); i++)
			m[i] = CLAVE;
		m[v] = 0; // vértice origen queda marcado 
		cola.offer(v); // Equivalente a cola.insertar(new Integer(v));

		while (!cola.isEmpty()) {
			Integer cw;
			cw = cola.poll(); // Equivalente a (Integer) cola.quitar()
			w = cw.intValue();
			System.out.println("Vértice " + g.verts[w] + " visitado");

			// inserta en la cola los adyacentes de w no marcados 
			for (int u = 0; u < g.getNumeroDeVertices(); u++) {
				if ((g.matAd[w][u] == 1) && (m[u] == CLAVE)) {
					// se marca vertice u con número de arcos hasta el 
					m[u] = m[w] + 1; // Cambio de m[v] a m[w]
					cola.offer(u); // Equivalente a cola.insertar(new Integer(u));
				}
			}
		}
		return m;
	}
	//RECORRIDO EN PROFUNDIDAD
	static public int[] recorrerProf(GrafoMatriz grafo, String org) throws Exception {
	    int v, w;
	    Stack<Integer> pila = new Stack<>();
	    int[] m;
	    m = new int[grafo.getNumeroDeVertices()];

	    // inicializa los vértices como no marcados 
	    v = grafo.numVertice(org);
	    if (v < 0) throw new Exception("Vértice origen no existe");
	    for (int i = 0; i < grafo.getNumeroDeVertices(); i++)
	        m[i] = CLAVE;
	    m[v] = 0; // vértice origen queda marcado 
	    pila.push(v);

	    while (!pila.isEmpty()) {
	        w = pila.pop();
	        System.out.println("Vértice " + grafo.verts[w].nomVertice() + " visitado");

	        // inserta en la pila los adyacentes de w no marcados
	        for (int u = 0; u < grafo.getNumeroDeVertices(); u++) {
	            if (grafo.matAd[w][u] == 1 && m[u] == CLAVE) {
	                pila.push(u);
	                m[u] = 1; // vértice queda marcado
	            }
	        }
	    }

	    return m;
	}
}
