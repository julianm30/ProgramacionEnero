package biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private final int id;
    // composicion de clases
    // clases contenidas: Estudiantes, Libros, LocalDate
    // Clase continente: Prestamo
    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaInicial;
    private LocalDate fechaDev;

    public Prestamo(int id, Estudiante estudiante, Libro libro, LocalDate fechaInicial) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaInicial = fechaInicial;

        // fechaDev 15 dias desp de la inicial
        this.fechaDev = fechaInicial.plusDays(15);
    }

    // Sobrecarga de constructores
    public Prestamo(int id, Estudiante estudiante, Libro libro) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaInicial = LocalDate.now();

        // fechaDev 15 dias desp de la inicial
        this.fechaDev = fechaInicial.plusDays(15);
    }

    // Se crea un constructor por defecto con la fecha actual del sistema con fecha
    // inicial e id a cero
    public Prestamo() {
        this.id = 0;
        this.fechaInicial = LocalDate.now();
        this.fechaDev = fechaInicial.plusDays(15);
    }

    public int getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
        this.fechaDev = fechaInicial.plusDays(15);
        // para que se cumpla los 15 dias
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo [id=" + id + "\n" + ", estudiante=" + estudiante.getDni() + "\n" +  "libro=" + libro.getISBN()+ "\n" + ", fechaInicial="
                + fechaInicial +"\n"+ ", fechaDev=" + fechaDev + "]";
    }

}
