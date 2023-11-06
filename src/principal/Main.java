package principal;

import modelos.CartaoDeCredito;
import modelos.Produto;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Produto> listaDeCompras = new ArrayList<>();
        var scan = new Scanner(System.in);

        int opcaoMenu = 1;

        System.out.println("Digite o limite do cartão: ");
        double limite = scan.nextDouble();
        var cartao = new CartaoDeCredito(limite);

        while (opcaoMenu != 0 ) {

            System.out.println("Digite a descrição da compra: ");
            String descricao = scan.next();
            System.out.println("Digite o valor da compra:");
            double valor = scan.nextDouble();

            var produto = new Produto(descricao, valor);

            if(produto.getValor() <= cartao.getLimite()){
                listaDeCompras.add(produto);
                cartao.comprar(produto.getValor());
                System.out.println("Compra realizada! \n");

            } else {
                System.out.println("Saldo insuficiente! \n");
                break;
            }

            System.out.println("[1] CONTINUAR OU [0] SAIR");
            opcaoMenu = scan.nextInt();
        }

        listaDeCompras.sort(Comparator.comparing(Produto::getValor));
        System.out.println("************************");
        System.out.println("   COMPRAS REALIZADAS   \n");
        for (Produto listaDeCompra : listaDeCompras) {
            System.out.println(listaDeCompra.toString());
        }
        System.out.println("************************");
        System.out.println("Saldo do cartão: " + cartao.getLimite() + "\n");




    }
}