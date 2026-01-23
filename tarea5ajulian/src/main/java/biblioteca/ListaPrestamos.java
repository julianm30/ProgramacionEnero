package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ListaPrestamos {

    private final ArrayList<Prestamo> listaPrestamos;

    // constructor
    public ListaPrestamos() {
        this.listaPrestamos = new ArrayList<>(100);
    }

    // guardar prestamo
    public void guardarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    // borrar prestamo
    public void borrarPrestamo(int pos) {
        if (pos >= 0 && pos < listaPrestamos.size()) {
            listaPrestamos.remove(pos);
        }
    }

    // Modificar el libro de un préstamo
    public void modificarLibroPrestamo(int idPrestamo, Libro nuevoLibro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId() == idPrestamo) {
                prestamo.setLibro(nuevoLibro);

            }
        }
    }

    // Modificar el estudiante de un préstamo
    public void modificarEstudiantePrestamo(int idPrestamo, Estudiante nuevoEstudiante) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId() == idPrestamo) {
                prestamo.setEstudiante(nuevoEstudiante);

            }
        }
    }

    // Buscar préstamo por id (búsqueda secuencial)
    public Prestamo buscarPrestamoID(int id) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }

    // Buscar todos los préstamos de un libro
    public ArrayList<Prestamo> buscarPrestamosLibro(Libro libro) {
        ArrayList<Prestamo> prestamosLibro = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro)) {
                prestamosLibro.add(prestamo);
            }
        }
        return prestamosLibro;
    }

    // Buscar todos los préstamos de un estudiante
    public ArrayList<Prestamo> buscarPrestamosEstudiante(Estudiante estudiante) {
        ArrayList<Prestamo> prestamosEstudiante = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getEstudiante().equals(estudiante)) {
                prestamosEstudiante.add(prestamo);
            }
        }
        return prestamosEstudiante;
    }

    // Buscar todos los préstamos vencidos
    public ArrayList<Prestamo> buscarPrestamosVencidos() {
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getFechaDev().isBefore(hoy)) {
                prestamosVencidos.add(prestamo);
            }
        }
        return prestamosVencidos;
    }

    // Buscar los préstamos que vencen en una fecha determinada
    public ArrayList<Prestamo> buscarPrestamosVencenFecha(LocalDate fecha) {
        ArrayList<Prestamo> prestamosVencenFecha = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getFechaDev().isEqual(fecha)) {
                prestamosVencenFecha.add(prestamo);
            }
        }
        return prestamosVencenFecha;
    }

    // Ordenar préstamos por id
    public void ordenarPorID() {
        Collections.sort(listaPrestamos, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
    }

    // Búsqueda binaria de préstamos por id
    public Prestamo busquedaBinariaPorID(int id) {
        ordenarPorID();
        int izq = 0, der = listaPrestamos.size() - 1;

        while (izq <= der) {
            int mid = izq + (der - izq) / 2;
            int midID = listaPrestamos.get(mid).getId();

            if (midID == id) {
                return listaPrestamos.get(mid);
            } else if (midID < id) {
                izq = mid + 1;
            } else {
                der = mid - 1;
            }
        }
        return null;
    }

    // Ordenar préstamos por fecha de inicio
    public void ordenarPorFechaInicio() {
        Collections.sort(listaPrestamos, (p1, p2) -> p1.getFechaInicial().compareTo(p2.getFechaInicial()));
    }

    // Ordenar por fecha de devolución
    public void ordenarPorFechaDevolucion() {
        Collections.sort(listaPrestamos, (p1, p2) -> p1.getFechaDev().compareTo(p2.getFechaDev()));
    }

    // Ordenar por título de libro
    public void ordenarPorTituloLibro() {
        Collections.sort(listaPrestamos, (p1, p2) -> p1.getLibro().getTitulo().compareTo(p2.getLibro().getTitulo()));
    }

    // Ordenar por nombre de alumno
    public void ordenarPorNombreEstudiante() {
        Collections.sort(listaPrestamos,
                (p1, p2) -> p1.getEstudiante().getNombre().compareTo(p2.getEstudiante().getNombre()));
    }

    // Método auxiliar para obtener cantidad de préstamos
    public int cantidad() {
        return listaPrestamos.size();
    }

    // Método auxiliar para verificar si está vacía
    public boolean estaVacia() {
        return listaPrestamos.isEmpty();
    }

    // Método para obtener un préstamo por posición
    public Prestamo obtener(int pos) {
        if (pos >= 0 && pos < listaPrestamos.size()) {
            return listaPrestamos.get(pos);
        }
        return null;
    }

    // Método para imprimir todos los préstamos
    public void imprimir() {
        listaPrestamos.forEach(System.out::println);
    }
}
