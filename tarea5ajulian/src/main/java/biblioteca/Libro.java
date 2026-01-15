package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private final String isbn;
    private Genero genero;
    private boolean disponible;

    // Constructor parametrizado
    public Libro(String titulo, String autor, int anioPublicacion, String isbn, Genero genero, boolean disponible) {
        if (!isValidISBN(isbn)) {
            throw new IllegalArgumentException("ISBN debe ser un número de 4 dígitos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Constructor por defecto
    public Libro() {
        this.titulo = "Sin título";
        this.autor = "Autor desconocido";
        this.anioPublicacion = 2024;
        this.isbn = "1234";
        this.genero = Genero.NOVELA;
        this.disponible = true;
    }

    // Validar ISBN (4 dígitos)
    private static boolean isValidISBN(String isbn) {
        return isbn != null && isbn.matches("\\d{4}");
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getISBN() {
        return isbn;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters (excepto disponible)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Método prestar: marca el libro como no disponible si está disponible
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("✓ Libro '" + titulo + "' prestado exitosamente.");
        } else {
            System.out.println("✗ El libro '" + titulo + "' no está disponible para préstamo.");
        }
    }

    // Método devolver: marca el libro como disponible si está no disponible
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("✓ Libro '" + titulo + "' devuelto exitosamente.");
        } else {
            System.out.println("✗ El libro '" + titulo + "' ya estaba disponible.");
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", isbn=" + isbn +
                ", genero=" + genero +
                " (" + genero.getDescripcion() + ")" +
                ", disponible=" + disponible +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
        
        Libro other = (Libro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    
}
