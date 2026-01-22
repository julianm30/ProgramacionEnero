package biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private final int id;

    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaInicial;
    private LocalDate fechaDev;


    public Prestamo(int id, Estudiante estudiante, Libro libro, LocalDate fechaInicial) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaInicial = fechaInicial;
        
        //fechaDev 15 dias desp de la inicial   
        this.fechaDev = fechaInicial.plusDays(15);
    }
    //Sobrecarga de constructores
public Prestamo(int id, Estudiante estudiante, Libro libro ) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaInicial = LocalDate.now();
        
        //fechaDev 15 dias desp de la inicial
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
    //para que se cumpla los 15 dias
}


    



  


   






}
