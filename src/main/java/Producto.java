public class Producto {

    private String nombre;
    private float precio;

    public Producto(String unNombre, float unPrecio){
        this.nombre = unNombre;
        this.precio = unPrecio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Nombre: " + this.getNombre() + " - Precio: " + this.getPrecio();
    }

    public float calcular(int cantidad){
        return this.getPrecio() * cantidad;
    }
}
