package biblioteca;

import java.util.ArrayList;

public class ListaPrestamos {

    private ArrayList<Prestamo> listaPrestamos;

    // constructor
    public ListaPrestamos() {
        this.listaPrestamos = new ArrayList<>(100);
    }

    // guardar prestamo
    public void guardarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    // borrar prestamo
    public void borrarPretamo(int pos) {
        if (pos > 0 && pos < listaPrestamos.size()) {
        }
        listaPrestamos.remove(pos);
    }

    // Modificar Libro prestamo
    // Modificar estudiante prestamo

   /* public Prestamo buscarPrestamoID(int id) {
        for (Prestamo Prestamo : listaPrestamos) {
            if (Prestamo.getId() == id) {
            }
            
        }
        
    }*/



    /*
     * Guardar préstamo
     * Borrar préstamo
     * Modificar el libro de un préstamo de la lista, para ello se debe aportar el
     * id del préstamo, y el nuevo libro a asignar.
     * Modificar el estudiante de un préstamo de la lista, para ello se debe aportar
     * el id del préstamo, y el nuevo estudiante a asignar.
     * Buscar préstamo por id (usa búsqueda secuencial)
     * --------------------------------
     * Buscar todos los préstamos de un libro
     * Buscar todos los préstamos de un estudiante
     * Buscar todos los prestamos vencidos
     * Buscar los préstamos que vencen en una fecha determinada
     * Ordenar préstamos por id
     * Búsqueda binaria de préstamos por id
     * Ordenar préstamos por fecha de inicio
     * Ordenar por fecha de devolución
     * Ordenar por título de libro
     * Ordenar por nombre de alumno/a
     */

}
