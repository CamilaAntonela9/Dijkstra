package grafos;
public class CaminoMinimo {
	private int [][] Pesos;
	private int [] ultimo;
	private int [] De;
	private boolean [] F;
	private int s, n; // vértice origen y número de vértices
	public CaminoMinimo(GrafMatPeso gp, int origen)
	{
		n = gp.numeroDeVertices();
		s = origen;
		Pesos = gp.matPeso;
		ultimo = new int [n];
		De = new int [n];
		F = new boolean [n];
	}
	public void caminoMinimos()
	{
		// valores iniciales
		for (int i = 0; i < n; i++)
		{
			F[i] = false;
			De[i] = Pesos[s][i];
			ultimo[i] = s;
		}
		F[s] = true; De[s] = 0;
		// Pasos para marcar los n-1 vértices 
		for (int i = 1; i < n; i++)
		{
			int v = minimo(); /* selecciona vértice no marcado 
	de menor distancia */
			F[v] = true;
			// actualiza distancia de vértices no marcados 
			for (int w = 1; w < n; w++)
				if (!F[w])
					if ((De[v] + Pesos[v][w]) < De[w])
					{
						De[w] = De[v] + Pesos[v][w];
						ultimo[w] = v;
					}
		}
	}
	private int minimo()
	{
		int mx = GrafMatPeso.INFINITO;
		int v = 1;
		for (int j = 1; j < n; j++)
			if (!F[j] && (De[j]<= mx))
			{
				mx = De[j];
				v = j;
			}
		return v;
	}
	public void recuperaCamino(int v) {
	int anterior = ultimo[v];
	if (v != s)
	{
	 recuperaCamino(anterior); // vuelve al último del último	
	 System.out.print(" -> V" + v);
	}
	else 
	System.out.print("V" + s);
	}


}