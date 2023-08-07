package grafos;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrafoMatriz grafo = new GrafoMatriz();
        int opcion;

        System.out.println("\n--------------------------------------------------");
        System.out.println("\n     UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE");
        System.out.println("            ESTRUCTURAS DE DATOS");
        System.out.println(" TEMA: TALLER GRUPAL IMPLEMENTACION ALGORITMO DIJKSTRA");
        System.out.println("       ESTUDIANTE: CAMILA OBANDO & GIOVANNY DURÁN ");
        System.out.println("            FECHA: 04 / 08 / 2023");
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n    TE PRESENTO LA CREACIÓN DE GRAFOS...");
        System.out.println("\nIngresa un vertice inicial");
        agregarVertice(grafo, scanner);

        do {
            System.out.println("\n--------------------------------------------------");
            System.out.println("\n                  MENÚ GRAFOS");
            System.out.println("\n--------------------------------------------------");
            System.out.println("  1. Insertar nuevo vértice");
            System.out.println("  2. Conectar vértices");
            System.out.println("  3. Buscar nodos conectados a un vértice");
            System.out.println("  4. Recorrido en anchura:");
            System.out.println("  5. Recorrido en profundidad:");
            System.out.println("  6. Salir");
            System.out.println("  7. Ejecutar algoritmo de Dijkstra");
            System.out.println("\n--------------------------------------------------");
            System.out.print("Ingrese la opción deseada: ");
            System.out.println("\n--------------------------------------------------");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarVertice(grafo, scanner);
                    break;
                case 2:
                    conectarVertices(grafo, scanner);
                    break;
                case 3:
                    buscarNodosConectados(grafo, scanner);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del vértice inicial para el recorrido: ");
                    String verticeInicial = scanner.next();
                    try {
                        int[] resultados = RecorreGrafo.recorrerAnchura(grafo, verticeInicial);
                        System.out.println("Recorrido en anchura desde el vértice '" + verticeInicial + "': ");
                        for (int i = 0; i < resultados.length; i++) {
                            System.out.println("Vértice: " + grafo.verts[i].nomVertice() + ", Distancia: " + resultados[i]);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al realizar el recorrido en anchura: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del vértice inicial para el recorrido: ");
                    String verticeInicialProf = scanner.next();
                    try {
                        int[] resultadosProf = RecorreGrafo.recorrerProf(grafo, verticeInicialProf);
                        System.out.println("Recorrido en profundidad desde el vértice '" + verticeInicialProf + "': ");
                        for (int i = 0; i < resultadosProf.length; i++) {
                            System.out.println("Vértice: " + grafo.verts[i].nomVertice() + ", Estado: " + resultadosProf[i]);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al realizar el recorrido en profundidad: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del vértice origen para el algoritmo de Dijkstra: ");
                    String verticeOrigenDijkstra = scanner.next();
                    
                    try {
                    	
                        int origen = grafo.obtenerIndiceVertice(verticeOrigenDijkstra);
                        if (origen == -1) {
                            throw new Exception("El vértice origen no existe en el grafo.");
                        }

                        CaminoMinimo caminoMinimo = new CaminoMinimo(new GrafMatPeso(grafo.numVerts), origen);
                        caminoMinimo.caminoMinimos();

                        System.out.println("Camino mínimo desde el vértice '" + verticeOrigenDijkstra + "':");
                        for (int i = 0; i < grafo.numVerts; i++) {
                            if (i != origen) {
                                System.out.print("V" + verticeOrigenDijkstra);
                                caminoMinimo.recuperaCamino(i);
                               // System.out.println(" -> V" + i + ", Distancia: " + caminoMinimo.De[i]);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error al ejecutar el algoritmo de Dijkstra: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static void agregarVertice(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo vértice: ");
        String nombreVertice = scanner.next();

        grafo.nuevoVertice(nombreVertice);
        System.out.println("Vértice '" + nombreVertice + "' agregado correctamente.");
    }

    public static void conectarVertices(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del primer vértice: ");
        String vertice1 = scanner.next();

        System.out.print("Ingrese el nombre del segundo vértice: ");
        String vertice2 = scanner.next();

        try {
            grafo.nuevoArco(vertice1, vertice2);
            System.out.println("Arista entre '" + vertice1 + "' y '" + vertice2 + "' agregada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al conectar los vértices: " + e.getMessage());
        }
    }

    public static void buscarNodosConectados(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del vértice para buscar los nodos conectados: ");
        String nombreVertice = scanner.next();

        try {
            List<Vertice> nodosConectados = grafo.nodosConectados(nombreVertice);
            System.out.println("Nodos conectados a '" + nombreVertice + "': ");
            for (Vertice vertice : nodosConectados) {
                System.out.println(vertice.nomVertice());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

