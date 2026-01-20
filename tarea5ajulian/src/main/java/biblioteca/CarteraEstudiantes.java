package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CarteraEstudiantes {

    private List<Estudiante> cartera;

    public CarteraEstudiantes(List<Estudiante> cartera) {
        this.cartera = cartera;
    }

    // constructor predeterminado
    public CarteraEstudiantes() {
        cartera = new ArrayList<>(100);
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

    // buscar estudiante
    public int buscarDNI(Estudiante estudiante) {
        return cartera.indexOf(estudiante);
    }

}
