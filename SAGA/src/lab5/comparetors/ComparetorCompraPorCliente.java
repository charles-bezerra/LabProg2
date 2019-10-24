package lab5.comparetors;

import lab5.classes.Compra;
import java.util.Comparator;

public class ComparetorCompraPorCliente implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2){
        int comparado = c1.getCliente()
                .getNome()
                .compareTo(
                        c2.getCliente().getNome()
                );

        if (comparado == 0){
            return c1.exibePorCliente()
                    .compareTo(c2.exibePorCliente());
        }
        return comparado;
    }
}
