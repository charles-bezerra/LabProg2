package lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompraController {
    private List<Compra> compras;

    CompraController(){
        this.compras = new ArrayList<>();
    }

    public String adiciona(String data, String nomeProduto, String descricaoProduto, Double preco){
        Compra compra = new Compra(data, nomeProduto, descricaoProduto, preco);
        this.compras.add(compra);

        return compra.toString();
    }

    public Double getDebito(){
        Double valor = 0.0;
        for (Compra compra: this.compras)
            valor += compra.getPreco();
        return valor;
    }

    public String exibeCompras(){
        StringBuilder resultado = new StringBuilder("");
        Iterator<Compra> comprasIterator = this.compras.iterator();

        while (comprasIterator.hasNext()){
            resultado.append(comprasIterator.next().toString());
            if (comprasIterator.hasNext()) resultado.append(" | ");
        }

        return resultado.toString();
    }
}

