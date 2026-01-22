package biblioteca;

import java.util.Objects;

public class Estudiante {

    private String nombre;
    private String apellidos;
    private String dni;

    // Constructor parametrizado
    public Estudiante(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.dni = dni;
    }

    // Constructor por defecto
    public Estudiante() {
        this.nombre = "Ruben";
        this.apellidos = "Wood";
        this.dni = "000 111 222 W";
    }

    // Getters n Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // toString
    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", Apellidos=" + apellidos + ", dni=" + dni
                + "]";
    }

    // HarshCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        return Objects.equals(this.dni, other.dni);
    }

}
