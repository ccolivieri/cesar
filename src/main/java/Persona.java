public class Persona {
    private String nombre;
    private String ci;
    private int edad;

    public Persona(String unNombre, String unCi, int unaEdad){
        this.nombre = unNombre;
        this.ci = unCi;
        this.edad = unaEdad;
    }

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString(){
        return "Nombre: " + this.getNombre() + " - CI: " + this.getCi() + " - Edad: " + this.getEdad();
    }
}
