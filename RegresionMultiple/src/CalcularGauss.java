public class CalcularGauss {

    public float[][] acomodarMatriz(TablaRegresion tablaRegresion) {
        float[][] matrizAcomodada = new float[3][4];

        matrizAcomodada[0][0] = tablaRegresion.getNumero();
        matrizAcomodada[0][1] = tablaRegresion.getSumX1();
        matrizAcomodada[0][2] = tablaRegresion.getSumX2();
        matrizAcomodada[0][3] = tablaRegresion.getSumY();

        matrizAcomodada[1][0] = tablaRegresion.getSumX1();
        matrizAcomodada[1][1] = tablaRegresion.getX1Cuadrada();
        matrizAcomodada[1][2] = tablaRegresion.getX1X2();
        matrizAcomodada[1][3] = tablaRegresion.getX1Y();

        matrizAcomodada[2][0] = tablaRegresion.getSumX2();
        matrizAcomodada[2][1] = tablaRegresion.getX1X2();
        matrizAcomodada[2][2] = tablaRegresion.getX2Cuadrada();
        matrizAcomodada[2][3] = tablaRegresion.getX2Y();

        return matrizAcomodada;
    }

    public float[][] resolverGauss(float[][] matrizAcomodada) {
        try {
            int filas = matrizAcomodada.length;
            int columnas = matrizAcomodada[0].length;
            for (int i = 0; i < filas; i++) {

                // Verificar si la matriz ya está resuelta
                if (matrizAcomodada[i][2] == 0) {
                    // Verificar si toda la fila es 0
                    int aux = 0;
                    for (int j = 0; j < matrizAcomodada[i].length; j++) {
                        int numero = (int) matrizAcomodada[i][j];
                        if (numero == 0) {
                            aux++;
                        }

                    }
                    // Si toda la fila es 0,  salir del ciclo
                    if (aux == 4) {
                        System.out.println("La matriz que genera tiene soluciones infinitas.");
                        break;
                    }
                }

                float divi = matrizAcomodada[i][i];
                for (int j = 0; j < columnas; j++) {

                    try {
                        matrizAcomodada[i][j] /= divi;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                for (int k = 0; k < filas; k++) {
                    if (k != i) {

                        try {
                            float mult = matrizAcomodada[k][i];
                            for (int j = 0; j < columnas; j++) {
                                matrizAcomodada[k][j] -= mult * matrizAcomodada[i][j];
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception errException) {
            System.out.println(errException.getMessage());
        }
        return matrizAcomodada;
    }

    public void imprimirMatrizResuelta(float[][] matrizGauss) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                System.out.print(matrizGauss[j][i] + "\t");
            }
            System.out.println();
        }
    }
}