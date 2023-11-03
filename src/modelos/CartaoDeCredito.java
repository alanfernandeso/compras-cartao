package modelos;

public class CartaoDeCredito {

    private double limite;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void comprar(double valor){
        this.limite -= valor;
    }
}
