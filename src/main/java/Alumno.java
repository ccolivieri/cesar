public class Alumno extends Persona{
    private int nroEstudiante;
    private boolean tienePrevia;
    private String grupo;

    public Alumno(String unNombre, String unCi, int unaEdad, int unNroEst){
        super(unNombre, unCi, unaEdad);
        this.nroEstudiante = unNroEst;
        this.tienePrevia = false;
        this.grupo = "1A";
    }

    public void setNroEstudiante(int nroEstudiante) {
        this.nroEstudiante = nroEstudiante;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setTienePrevia(boolean tienePrevia) {
        this.tienePrevia = tienePrevia;
    }

    public int getNroEstudiante() {
        return nroEstudiante;
    }

    public String getGrupo() {
        return grupo;
    }

    public String isTienePrevia() {
        String previa = "No";

        if(tienePrevia == true){
            previa = "Si";
        }
        return previa;
    }

    public String toString(){
        return super.toString() + " - Número de estudiante: " + this.getNroEstudiante() + " - Tiene previa: " + this.isTienePrevia() + " - Grupo: " + this.getGrupo();
    }
}
