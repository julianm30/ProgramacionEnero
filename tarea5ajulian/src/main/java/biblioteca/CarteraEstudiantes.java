package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CarteraEstudiantes {

    private final ArrayList<Estudiante> cartera;

    public CarteraEstudiantes(ArrayList<Estudiante> cartera) {
        this.cartera = cartera;
    }
    //buscar por nombre
    public int buscarPorNombre(String nombre) {
        ordenarPorNombre();
        Estudiante aux = new Estudiante(nombre, "", "");
        return Collections.binarySearch(cartera, aux, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
    }

    //ordenar por nombre
    public void ordenarPorNombre() {
        Collections.sort(cartera, (e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
    }

    // constructor predeterminado
    public CarteraEstudiantes() {
        cartera = new ArrayList<>(100);
    }

    // cantidad()
    public int cantidad() {
        return cartera.size();
    }

    // añadir estudiante
    public void anadirEstudiante(Estudiante e) {
        cartera.add(e);
    }

    // borrar estudiante
    public void eliminarEstudiante(int pos) {
        if (pos >= 0 && pos < cartera.size()) {
            cartera.remove(pos);
        }

    }

    public boolean estaVacia() {
        return cartera.isEmpty();
    }

    // ordenar estudiantes por dni
    public void ordenarPorDNI() {
        Collections.sort(cartera, (e1, e2) -> e2.getDni().compareTo(e1.getDni()));
    }

    // buscar estudiante
    public int buscarDNI(Estudiante estudiante) {
        return cartera.indexOf(estudiante);
    }

    public void imprimir() {
        cartera.forEach(System.out::println);
    }

    public Estudiante obtenerEstudiante() {
        return cartera.get(new Random().nextInt(0, cartera.size()));

    }
    public void guardar(Estudiante estudiante){
        cartera.add(estudiante);
    }
}
