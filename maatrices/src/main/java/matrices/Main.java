package matrices;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*
         * Una matriz o array bidimensional es una estructura de datos
         * conceptualmente es una tabla e internamente es un array de arrays
         * guarda siempre el mismo tipo de dato con el que se define
         */

        int[][] num = new int[4][6];

        // El primer numero que se da son las filas (horizontales) y
        // el segundo las columnas (veritacales)
        // si filas y columnas son iguales la matriz es cuadrada

        // 0 1 2 3 4 5 → COLUMNAS
        // 0_|_|_|_|_|_|
        // 1_|_|_|_|_|_|
        // 2_|_|_|_|_|_|
        // 3_|_|_|_|_|_|
        // ↓
        // FILAS

        // si hacemos matriz.legth() seria la fila y
        // si le damos un valor seria la columna

        int[][] matriz = new int[4][4];

        // recorrido clasico
        System.out.println("________________↓for-clasico↓______________\n");

        for (int i = 0; i < matriz.length; i++) { // i recorre filas
            for (int j = 0; j < matriz.length; j++) { // j recorre columnas
                matriz[i][j] = new Random().nextInt(0, 100);
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
        
        // recorrido con for-each
        System.out.println("________________↓for-each↓______________\n");
        for (int[] fila : matriz) {
            for (int columna : fila) {
                System.out.print(" " + columna);
            }
            System.out.println();
        }
    }
}