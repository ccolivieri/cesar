public class Perecedero extends Producto{

    private int diasCaducar;

    public Perecedero(String unNombre, float unPrecio, int diasCaducar){
        super(unNombre, unPrecio);
        this.diasCaducar = diasCaducar;
        this.setPeso(Constantes.PESO_PERECEDERO);
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    public String toString(){
        return super.toString() + " - Cantidad de días a caducar: " + this.getDiasCaducar();
    }

    public float calcular(int cantidad){
        float precioFinal = super.calcular(cantidad);

        if(diasCaducar == 1){
            precioFinal = this.getPrecio() / 4;
        }else if(diasCaducar == 2){
            precioFinal = this.getPrecio() / 3;
        }else if(diasCaducar == 3){
            precioFinal = this.getPrecio() / 2;
        }
        return precioFinal;
    }
}
