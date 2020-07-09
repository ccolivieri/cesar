
public class Producto {

    private String nombre;
    private int codigo;
    private boolean importado;
    private String nroLote;
    private static int NROPRODUCTO = 0;

    public Producto(){
        this.nombre = "Desconocido";
        this.codigo = 0;
        this.importado = false;
        this.nroLote = "Desconocido";
        incrementarProducto();
    }

    public Producto(String unNombre, int unCodigo, boolean unImportado, String unNroLote){
        this.nombre = unNombre;
        this.codigo = unCodigo;
        this.importado = unImportado;
        this.nroLote = unNroLote;
        incrementarProducto();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isImportado() {
        return importado;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    private void incrementarProducto(){
        NROPRODUCTO++;
    }

    public String toString(){

        if(isImportado() == true){
            return "Nombre: " + getNombre() + " Código: " + getCodigo() + " Número de lote: " + getNroLote() + " Este producto es importado";
        }else {
            return "Nombre: " + getNombre() + " Código: " + getCodigo() + " Número de lote: " + getNroLote() + " Producto nacional";
        }
    }
}
