
public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int nroPaginas;

    public Libro(){
        this.isbn = 0;
        this.titulo = "Sin título";
        this.autor = "Desconocido";
        this.nroPaginas = 0;
    }

    public Libro(int unIsbn, String unTitulo, String unAutor, int nroPaginas){
        this.isbn = unIsbn;
        this.titulo = unTitulo;
        this.autor = unAutor;
        this.nroPaginas = nroPaginas;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNroPaginas(int nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public String toString(){
        return "El libro con ISBN " + getIsbn() + " creado por el autor " + getAutor() + " tiene " + getNroPaginas() + " páginas";
    }
}
