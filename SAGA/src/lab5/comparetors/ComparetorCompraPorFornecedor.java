package lab5.comparetors;

import lab5.comparetors.classes.Compra;
import java.util.Comparator;

public class ComparetorCompraPorFornecedor implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2){
        int comparado = c1.getFornecedor()
                .getNome()
                .compareTo(
                        c2.getFornecedor().getNome()
                );

        if (comparado == 0){
            return c1.exibePorFornecedor()
                    .compareTo(c2.exibePorFornecedor());
        }
        return comparado;
    }
}
