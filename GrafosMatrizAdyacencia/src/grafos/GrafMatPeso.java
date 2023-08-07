package grafos;

public class GrafMatPeso {
    public static final int INFINITO = Integer.MAX_VALUE;
    private int numVertices;
    public int[][] matPeso;

    public GrafMatPeso(int numVertices) {
        this.numVertices = numVertices;
        matPeso = new int[numVertices][numVertices];

        // Inicializar matriz de pesos con INFINITO para todos los arcos
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matPeso[i][j] = INFINITO;
            }
        }
    }

    public void agregarArco(int verticeOrigen, int verticeDestino, int peso) {
        matPeso[verticeOrigen][verticeDestino] = peso;
    }

    public int pesoArco(int verticeOrigen, int verticeDestino) {
        return matPeso[verticeOrigen][verticeDestino];
    }

    public int numeroDeVertices() {
        return numVertices;
    }
}
