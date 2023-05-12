import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos instancias de las clases
        TablaRegresion tablaRegresion = new TablaRegresion();
        CalcularGauss calcularGauss = new CalcularGauss();

        // Variable para switch inicializada en 0
        int opc;

        // Obtener el tamaño de la tabla
        System.out.print("Ingrese el número de casos: ");
        int filas = scanner.nextInt();

        // Generar la tabla por defecto
        int[][] tabla = tablaRegresion.generarTabla(filas);
        System.out.println("Tabla generada:");
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j] + "\t");
            }
            System.out.println();
        }

        do {
            System.out.println("1. Método Gauss.");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. Salir del programa.");
            System.out.print("Seleccione una opción: ");
            opc = scanner.nextInt();
        
            switch (opc) {
                case 1:
                    float[][] matrizAcomodada = calcularGauss.acomodarMatriz(tablaRegresion);
                    float[][] matrizResuelta = calcularGauss.resolverGauss(matrizAcomodada);
                    calcularGauss.imprimirMatrizResuelta(matrizResuelta);
                    break;
                case 2:
                // Código para el caso 2
                break;

            case 4:
                System.out.println("Adiós...");
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }
    } while (opc != 4);
    }
}

