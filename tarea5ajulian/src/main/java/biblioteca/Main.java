package biblioteca;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // Crear 10 libros distintos y un 11º que repite el ISBN del 10º
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "1111", Genero.NOVELA, true);
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", 1605, "2222", Genero.NOVELA, true);
        Libro libro3 = new Libro("Orgullo y prejuicio", "Jane Austen", 1813, "3333", Genero.NOVELA, true);
        Libro libro4 = new Libro("1984", "George Orwell", 1949, "4444", Genero.FICCION, true);
        Libro libro5 = new Libro("El Quijote", "Miguel de Cervantes", 1605, "5555", Genero.NOVELA, false);
        Libro libro6 = new Libro("Poeta en Nueva York", "Federico García Lorca", 1940, "6666", Genero.POESIA, true);
        Libro libro7 = new Libro("La metamorfosis", "Franz Kafka", 1915, "7777", Genero.RELATO, true);
        Libro libro8 = new Libro("El guardián entre el centeno", "J.D. Salinger", 1951, "8888", Genero.NOVELA, true);
        Libro libro9 = new Libro("Crimen y castigo", "Fiódor Dostoievski", 1866, "9999", Genero.NOVELA, true);
        Libro libro10 = new Libro("La casa de los espíritus", "Isabel Allende", 1982, "0000", Genero.NOVELA, true);
        Libro libro11 = new Libro("La ciudad de los espíritus", "Isabel Allende", 1982, "0000", Genero.NOVELA, false);

        // Mostrar datos de los libros
        System.out.println(" DATOS DE LOS 11 LIBROS ");
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);
        System.out.println("Libro 3: " + libro3);
        System.out.println("Libro 4: " + libro4);
        System.out.println("Libro 5: " + libro5);
        System.out.println("Libro 6: " + libro6);
        System.out.println("Libro 7: " + libro7);
        System.out.println("Libro 8: " + libro8);
        System.out.println("Libro 9: " + libro9);
        System.out.println("Libro 10: " + libro10);
        System.out.println("Libro 11: " + libro11);

        // Prueba de métodos prestar y devolver
        System.out.println("\n PRUEBA DE MÉTODOS PRESTAR() Y DEVOLVER()");
        libro1.prestar();
        System.out.println("Estado después de prestar: " + libro1);
        libro1.prestar(); // Intenta prestar un libro ya prestado
        libro1.devolver();
        System.out.println("Estado después de devolver: " + libro1);

        // Crear catálogo y agregar libros
        System.out.println("\nPARTE B: CLASE CATALOGO LIBROS\n");

        CatalogoLibros catalogo = new CatalogoLibros();

        catalogo.guardar(libro1);
        catalogo.guardar(libro2);
        catalogo.guardar(libro3);
        catalogo.guardar(libro4);
        catalogo.guardar(libro5);
        catalogo.guardar(libro6);
        catalogo.guardar(libro7);
        catalogo.guardar(libro8);
        catalogo.guardar(libro9);
        catalogo.guardar(libro10);
        catalogo.guardar(libro11);

        System.out.println("Cantidad de libros en el catálogo: " + catalogo.cantidad());
        catalogo.eliminar(8);

        System.out.println("Cantidad de libros en el catálogo: " + catalogo.cantidad());

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog("""
                    ========== MENÚ DE CATÁLOGO DE LIBROS ==========

                    1. Agregar un nuevo libro
                    2. Mostrar todos los libros del catálogo
                    3. Buscar libro por ISBN
                    4. Buscar libros por autor
                    5. Prestar un libro
                    6. Devolver un libro
                    7. Eliminar un libro
                    8. Mostrar cantidad de libros
                    9. Salir

                    Selecciona una opción (1-9):""");

            if (opcion == null) {
                continuar = false;
                break;
            }

            switch (opcion.trim()) {
                case "1" -> agregarLibro(catalogo);
                case "2" -> mostrarCatalogo(catalogo);
                case "3" -> buscarPorISBN(catalogo);
                case "4" -> buscarPorAutor(catalogo);
                case "5" -> prestarLibro(catalogo);
                case "6" -> devolverLibro(catalogo);
                case "7" -> eliminarLibro(catalogo);
                case "8" -> mostrarCantidad(catalogo);
                case "9" -> {
                    JOptionPane.showMessageDialog(null, "Has decidido salir");
                    continuar = false;
                }
                default -> JOptionPane.showMessageDialog(null,
                        "Opción no válida. Por favor, selecciona una opción entre 1 y 9.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Prestamo p1 =new Prestamo(1, cartera , catalogo.obtener(1));
        // System.out.println(p1);
    }

    // Método para agregar un nuevo libro
    private static void agregarLibro(CatalogoLibros catalogo) {
        try {
            String titulo = JOptionPane.showInputDialog("Ingresa el título del libro:");
            if (titulo == null)
                return;

            String autor = JOptionPane.showInputDialog("Ingresa el autor del libro:");
            if (autor == null)
                return;

            String anioStr = JOptionPane.showInputDialog("Ingresa el año de publicación:");
            if (anioStr == null)
                return;
            int anio = Integer.parseInt(anioStr);

            String isbn = JOptionPane.showInputDialog("Ingresa el ISBN (4 dígitos):");
            if (isbn == null)
                return;

            String[] generos = { "NOVELA", "FICCION", "POESIA", "RELATO" };
            int indexGenero = JOptionPane.showOptionDialog(null, "Selecciona el género:", "Género",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
            if (indexGenero < 0)
                return;

            Genero genero = Genero.valueOf(generos[indexGenero]);

            String[] disponibilidad = { "Disponible", "No disponible" };
            int indexDisponible = JOptionPane.showOptionDialog(null, "¿Está disponible?", "Disponibilidad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, disponibilidad, disponibilidad[0]);
            if (indexDisponible < 0)
                return;

            boolean disponible = indexDisponible == 0;

            Libro nuevoLibro = new Libro(titulo, autor, anio, isbn, genero, disponible);
            catalogo.guardar(nuevoLibro);
            JOptionPane.showMessageDialog(null, "✓ Libro agregado exitosamente:\n" + nuevoLibro, "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    " Error: Año o ISBN inválido. El año debe ser un número y el ISBN debe tener 4 dígitos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, " Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar todos los libros del catálogo
    private static void mostrarCatalogo(CatalogoLibros catalogo) {
        if (catalogo.estaVacia()) {
            JOptionPane.showMessageDialog(null, "El catálogo está vacío.", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("========== LIBROS DEL CATÁLOGO ==========\n\n");
        for (int i = 0; i < catalogo.cantidad(); i++) {
            sb.append(String.format("[Posición %d] %s\n\n", i, catalogo.obtener(i)));
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Catálogo de Libros", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para buscar libro por ISBN
    private static void buscarPorISBN(CatalogoLibros catalogo) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a buscar:");
        if (isbn == null)
            return;

        Libro libro = catalogo.buscarIsbn(isbn);
        if (libro != null) {
            JOptionPane.showMessageDialog(null, " Libro encontrado:\n\n" + libro, "Búsqueda Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, " No se encontró un libro con ISBN: " + isbn, "No Encontrado",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para buscar libros por autor
    private static void buscarPorAutor(CatalogoLibros catalogo) {
        String autor = JOptionPane.showInputDialog("Ingresa el nombre del autor a buscar:");
        if (autor == null)
            return;

        var librosAutor = catalogo.buscarAutor(autor);
        if (!librosAutor.isEmpty()) {
            StringBuilder sb = new StringBuilder(" Libros encontrados de " + autor + ":\n\n");
            for (Libro libro : librosAutor) {
                sb.append(libro).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, " No se encontraron libros del autor: " + autor, "No Encontrado",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para prestar un libro
    private static void prestarLibro(CatalogoLibros catalogo) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a prestar:");
        if (isbn == null)
            return;

        Libro libro = catalogo.buscarIsbn(isbn);
        if (libro != null) {
            libro.prestar();
            if (libro.isDisponible()) {
                libro.prestar();
                JOptionPane.showMessageDialog(null, " Libro prestado exitosamente: " + libro.getTitulo(), "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, " El libro no está disponible para préstamo.", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El libro no ha sido encontrado con ISBN: " + isbn, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para devolver un libro
    private static void devolverLibro(CatalogoLibros catalogo) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a devolver:");
        if (isbn == null)
            return;

        Libro libro = catalogo.buscarIsbn(isbn);
        if (libro != null) {
            libro.devolver();
            if (libro.isDisponible()) {
                JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente: " + libro.getTitulo(), "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El libro ya estaba disponible.", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "E libro no ha sido encontrado con ISBN: " + isbn, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un libro
    private static void eliminarLibro(CatalogoLibros catalogo) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a eliminar:");
        if (isbn == null)
            return;

        Libro libro = catalogo.buscarIsbn(isbn);
        if (libro != null) {
            catalogo.eliminarISBN(isbn);
            JOptionPane.showMessageDialog(null, " Libro eliminado exitosamente: " + libro.getTitulo(), "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, " Libro no encontrado con ISBN: " + isbn, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar la cantidad de libros en el catálogo
    private static void mostrarCantidad(CatalogoLibros catalogo) {
        int cantidad = catalogo.cantidad();
        JOptionPane.showMessageDialog(null, "Cantidad de libros en el catálogo: " + cantidad, "Cantidad de Libros",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

// falta añadir los metodos para la cartera de estudiantes