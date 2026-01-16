package biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

public class CatalogoLibros {

    private List<Libro> lista;

    public CatalogoLibros() {
       lista = new ArrayList<>(100);
    }

    // cantidad(): devuelve el numero de Libros de la lista.

    public int cantidad() {
        return lista.size();
    }

    // estaVacia(): devuelve si la lista de libros está vacía.
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    // obtener(int pos): devuelve el libro que se encuentra en la posición indicada.
    public Libro obtener(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            return lista.get(pos);
        }
        return null;
    }

    // cambiar(int pos, Libro nuevo): cambia el libro de la posición indicada por el
    // nuevo libro proporcionado.
    public void cambiar(int pos, Libro nuevo) {
        if (pos > 0 && pos < lista.size()) {
            lista.set(pos, nuevo);
        }
    }

    // guardar(Libro libro): agrega al final de la lista el libro pasado.
    public void guardar(Libro libro) {
        lista.add(libro);
    }

    // eliminar(int pos): elimina el libro que se encuentra en la posición indicada.
    public void eliminar(int pos) {
        if (pos>0 && pos<lista.size()) {
            
        }
        lista.remove(pos);
    }

    // eliminar(String isbn), elimina el objeto libro que tiene ese isbn si se
    // encuentra en la lista.

    public void eliminarISBN(String isbn) {
        Libro aux = buscarIsbn(isbn);
        if (aux!=null) {
           lista.remove(aux); 
        }

        /*for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getISBN().equals(isbn)) {
                lista.remove(i);
                break;
            }
        }*/ 
    }

    // buscar(Libro libro), busca el libro en la lista y devuelve la posición en la
    // que se encuentra. Usa el método indexOf.

    public int buscar(Libro libro){
        return lista.indexOf(libro);
    }

    // buscar(String autor), busca todos los libros de ese autor y los devuelve en
    // una lista de libros.

    public ArrayList<Libro> buscarAutor(String autor){
        var listaAutores = new ArrayList<Libro>();
        for (Libro libro : lista) {
            if (autor.equalsIgnoreCase(libro.getAutor())) {
                listaAutores.add(libro);
            }
        }
        return listaAutores;
    }

    // buscar(String isbn), busca el libro que tiene ese isbn y lo devuelve si
    // existe. En caso de no existir devuelve null.

    public Libro buscarIsbn (String isbn){
        for (Libro libro : lista) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    //imprimir
   public void imprimir(){
    lista.forEach(System.out::println);
   }


}
