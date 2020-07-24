public class Profesor extends Persona{
    private String materia;
    private float salario;

    public Profesor(String unNombre, String unCi, int unaEdad, String unaMateria, float unSalario){
        super(unNombre, unCi, unaEdad);
        this.materia = unaMateria;
        this.salario = unSalario;
    }

    public Profesor(){
        super();
    }

    public String getMateria() {
        return materia;
    }

    public float getSalario() {
        return salario;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String toString(){
        return super.toString() + " - Materia: " + this.getMateria() + " - Salario: " + this.getSalario();
    }
}
