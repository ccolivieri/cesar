public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String unNombre, float unPrecio, String unTipo){
        super(unNombre, unPrecio);
        this.tipo = unTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return super.toString() + " - Tipo: " + this.getTipo();
    }
}
