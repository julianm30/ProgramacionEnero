package biblioteca;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== PARTE A: CLASE LIBRO Y ENUM GENERO ==========\n");

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
        System.out.println("--- DATOS DE LOS 11 LIBROS ---");
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
        System.out.println("\n--- PRUEBA DE MÉTODOS PRESTAR() Y DEVOLVER() ---");
        libro1.prestar();
        System.out.println("Estado después de prestar: " + libro1);
        libro1.prestar();  // Intenta prestar un libro ya prestado
        libro1.devolver();
        System.out.println("Estado después de devolver: " + libro1);

        // Prueba de hashCode
        System.out.println("\n--- PRUEBA DE HASHCODE() ---");
        System.out.println("HashCode de Libro 1 (ISBN: 1111): " + libro1.hashCode());
        System.out.println("HashCode de Libro 2 (ISBN: 2222): " + libro2.hashCode());
        System.out.println("HashCode de Libro 3 (ISBN: 3333): " + libro3.hashCode());
        System.out.println("HashCode de Libro 4 (ISBN: 4444): " + libro4.hashCode());
        System.out.println("HashCode de Libro 5 (ISBN: 5555): " + libro5.hashCode());
        System.out.println("HashCode de Libro 6 (ISBN: 6666): " + libro6.hashCode());
        System.out.println("HashCode de Libro 7 (ISBN: 7777): " + libro7.hashCode());
        System.out.println("HashCode de Libro 8 (ISBN: 8888): " + libro8.hashCode());
        System.out.println("HashCode de Libro 9 (ISBN: 9999): " + libro9.hashCode());
        System.out.println("HashCode de Libro 10 (ISBN: 0000): " + libro10.hashCode());
        System.out.println("HashCode de Libro 11 (ISBN: 0000): " + libro11.hashCode());
        System.out.println("\n✓ Los libros 10 y 11 tienen el mismo ISBN (0000) por lo que generan el mismo hashCode");
        System.out.println("✓ Los demás libros tienen ISBN diferente por lo que generan hashCode diferentes");

        // Prueba de equals
        System.out.println("\n--- PRUEBA DE EQUALS() ---");
        System.out.println("libro1.equals(libro2): " + libro1.equals(libro2) + " (ISBN diferente)");
        System.out.println("libro10.equals(libro11): " + libro10.equals(libro11) + " (ISBN igual: 0000)");
        System.out.println("libro5.equals(libro1): " + libro5.equals(libro1) + " (ISBN diferente)");
        System.out.println("libro1.equals(libro1): " + libro1.equals(libro1) + " (misma instancia)");
    }
}