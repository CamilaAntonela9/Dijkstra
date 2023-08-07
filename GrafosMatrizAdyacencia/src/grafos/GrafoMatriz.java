package grafos;
import java.util.ArrayList;
import java.util.List;
public class GrafoMatriz {
	//Atributos
	int numVerts;
	static int maxVerts = 20; 
	Vertice [] verts;
	int [][] matAd;
	public Object[] tablAdc;
	//contructor
	public GrafoMatriz()
	{
		this(maxVerts);
	}
	public GrafoMatriz(int mx)
	{
		matAd = new int [mx][mx];
		verts = new Vertice[mx];
		for (int i = 0; i < mx; i++)
			for (int j = 0; i < mx; i++)
				matAd[i][j] = 0;
		numVerts = 0;
	}
    // Método para obtener el número de vértices
    public int getNumeroDeVertices() {
        return numVerts;
    }
	//agregar un nuevo vertice al arbol
	public void nuevoVertice (String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta)  {
			Vertice v = new Vertice(nom); 
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}  //numVertice() busca el vértice en el array. Devuelve -1 si no lo encuentra:
	int numVertice(String vs){
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;){
			encontrado = verts[i].equals(v);
			if (!encontrado) i++ ; 
		}
		return (i < numVerts) ? i : -1 ;
	}

	public void nuevoArco(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	//MAS OPTIMIZADO
	public void nuevoArco(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	public boolean adyacente(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}
	public boolean adyacente(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}

	public List<Vertice> nodosConectados(String nombreVertice) {
		List<Vertice> nodosConectados = new ArrayList<>();
		int indiceVertice = numVertice(nombreVertice);

		if (indiceVertice >= 0) {
			for (int i = 0; i < numVerts; i++) {
				if (matAd[indiceVertice][i] == 1) {
					nodosConectados.add(verts[i]);
				}
			}
		} else {
			throw new IllegalArgumentException("Vértice no encontrado");
		}

		return nodosConectados;
	}
	public int obtenerIndiceVertice(String nombreVertice) {
        for (int i = 0; i < numVerts; i++) {
            if (verts[i].nomVertice().equals(nombreVertice)) {
                return i;
            }
        }
        return -1;
    }

}
