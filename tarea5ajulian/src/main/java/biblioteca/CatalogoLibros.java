package biblioteca;

import java.util.List;

public class CatalogoLibros {

    private List<Libro> libros;

    public CatalogoLibros(List<Libro> libros) {
        this.libros = libros;
    }

    // cantidad(): devuelve el numero de Libros de la lista.

    public int cantidad() {
        return libros.size();
    }

    // estaVacia(): devuelve si la lista de libros está vacía.
    public boolean estaVacia() {
        return false;
    }

    // obtener(int pos): devuelve el libro que se encuentra en la posición indicada.
    public Libro obtener(int pos) {
        if (pos >= 0 && pos < libros.size()) {
            return libros.get(pos);
        }
        return null;
    }

    // cambiar(int pos, Libro nuevo): cambia el libro de la posición indicada por el
    // nuevo libro proporcionado.
    public void cambiar(int pos, Libro nuevo) {
        if (pos > 0 && pos < libros.size()) {
            libros.set(pos, nuevo);
        }
    }

    // guardar(Libro libro): agrega al final de la lista el libro pasado.
    public void guardar(Libro libro) {
        libros.addLast(libro);
    }

    // eliminar(int pos): elimina el libro que se encuentra en la posición indicada.
    public void eliminar(int pos) {
        libros.remove(pos);
    }

    // eliminar(String isbn), elimina el objeto libro que tiene ese isbn si se
    // encuentra en la lista.

    public void eliminar(String isbn) {
        libros.remove(isbn);
    }

    // buscar(Libro libro), busca el libro en la lista y devuelve la posición en la
    // que se encuentra. Usa el método indexOf.

    public static int buscar(Libro libro){
        
        return CatalogoLibros.IndexOf(Libro);
    }

    // buscar(String autor), busca todos los libros de ese autor y los devuelve en
    // una lista de libros.

    // buscar(String isbn), busca el libro que tiene ese isbn y lo devuelve si
    // existe. En caso de no existir devuelve null.
}
