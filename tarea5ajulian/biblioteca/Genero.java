package biblioteca;

public enum Genero {
    NOVELA("Narrativa de ficción de considerable extensión"),
    FICCION("Obra literaria de imaginación"),
    POESIA("Composición literaria en verso"),
    RELATO("Narración breve de hechos reales o imaginarios");

    private final String descripcion;

    Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
