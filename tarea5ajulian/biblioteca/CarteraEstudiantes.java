import java.util.ArrayList;
import java.util.List;

public class CarteraEstudiantes {

    private List<Cartera> cartera;

    // añadir estudiante
    public void anadirEstudiante() {
        cartera.add(this);
    }

    // borrar estudiante
    public void eliminarEstudiante(int pos) {
        if (pos > 0 && pos < cartera.size()) {
        }
        cartera.remove(pos);
    }

    // buscar estudiante
    public int buscarDNI (Cartera cartera){
        for (Cartera cartera : this.cartera) {
            
        }
    }

}
