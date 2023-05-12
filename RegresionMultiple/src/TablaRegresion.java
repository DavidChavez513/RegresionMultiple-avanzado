import java.util.Scanner;

public class TablaRegresion {
    private int numero;
    private int sumY;
    private int sumX1;
    private int sumX2;
    private int x1Cuadrada;
    private int x1X2;
    private int x1Y;
    private int x2Cuadrada;
    private int x2Y;
    private int yCuadrada;

    public int getNumero() {
        return numero;
    }

    public int getSumY() {
        return sumY;
    }

    public int getSumX1() {
        return sumX1;
    }

    public int getSumX2() {
        return sumX2;
    }

    public int getX1Cuadrada() {
        return x1Cuadrada;
    }

    public int getX1X2() {
        return x1X2;
    }

    public int getX1Y() {
        return x1Y;
    }

    public int getX2Cuadrada() {
        return x2Cuadrada;
    }

    public int getX2Y() {
        return x2Y;
    }


    public int[][] generarTabla(int filas) {
        // La variable numero se usará en la posición [0][0] de la matriz
        numero = filas;

        // Crear la matriz para almacenar los valores
        int[][] tabla = new int[filas + 1][9];

        Scanner scanner = new Scanner(System.in);

        // Obtener los valores para las primeras 3 columnas
        for (int i = 0; i < filas; i++) {
            System.out.print("Ingrese el valor de 'y' de la fila " + (i + 1) + ": ");
            tabla[i][0] = scanner.nextInt();

            System.out.print("Ingrese el valor de 'x1' de la fila " + (i + 1) + ": ");
            tabla[i][1] = scanner.nextInt();

            System.out.print("Ingrese el valor de 'x2' de la fila " + (i + 1) + ": ");
            tabla[i][2] = scanner.nextInt();
        }

        // Realizar las operaciones para las columnas restantes
        for (int i = 0; i < filas; i++) {
            tabla[i][3] = tabla[i][1] * tabla[i][1]; // x1^2
            tabla[i][4] = tabla[i][1] * tabla[i][2]; // x1 * x2
            tabla[i][5] = tabla[i][1] * tabla[i][0]; // x1 * y
            tabla[i][6] = tabla[i][2] * tabla[i][2]; // x2^2
            tabla[i][7] = tabla[i][2] * tabla[i][0]; // x2 * y
            tabla[i][8] = tabla[i][0] * tabla[i][0]; // y^2

            // Actualizar las sumatorias de las columnas
            sumY += tabla[i][0];
            sumX1 += tabla[i][1];
            sumX2 += tabla[i][2];
            x1Cuadrada += tabla[i][3];
            x1X2 += tabla[i][4];
            x1Y += tabla[i][5];
            x2Cuadrada += tabla[i][6];
            x2Y += tabla[i][7];
            yCuadrada += tabla[i][8];
        }

        // Asignar las sumatorias en la última fila de la matriz
        tabla[filas][0] = sumY;
        tabla[filas][1] = sumX1;
        tabla[filas][2] = sumX2;
        tabla[filas][3] = x1Cuadrada;
        tabla[filas][4] = x1X2;
        tabla[filas][5] = x1Y;
        tabla[filas][6] = x2Cuadrada;
        tabla[filas][7] = x2Y;
        tabla[filas][8] = yCuadrada;

        return tabla;
    }

}
