package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CarteraEstudiantes {

    private List<Estudiante> cartera;

    public CarteraEstudiantes(List<Estudiante> cartera) {
        this.cartera = cartera;
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
    
    public Estudiante obtenerEstudiante(){
    return cartera.get(new Random().nextInt(0, cartera.size()));

}
}
