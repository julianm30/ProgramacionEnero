package biblioteca;

public class Main2 {
    // crear catalogo y agregar estudiantes

    

    public static CarteraEstudiantes generarCarteraEstudiantes() {
        CarteraEstudiantes cartera = new CarteraEstudiantes();

        cartera.guardar(new Estudiante("Juan", "Pérez", "12345678A"));
        cartera.guardar(new Estudiante("Marta", "Gómez", "87654321B"));
        cartera.guardar(new Estudiante("Luis", "Martínez", "11223344C"));
        cartera.guardar(new Estudiante("Ana", "López", "44332211D"));
        cartera.guardar(new Estudiante("Carlos", "Sánchez", "55667788E"));
        cartera.guardar(new Estudiante("Laura", "Ramírez", "88776655F"));
        cartera.guardar(new Estudiante("Jorge", "Torres", "99887766G"));
        cartera.guardar(new Estudiante("Sofía", "Flores", "66554433H"));
        cartera.guardar(new Estudiante("Miguel", "Rivera", "33445566I"));
        cartera.guardar(new Estudiante("Elena", "Sánchez", "22113344J"));

        return cartera;
    }
}
