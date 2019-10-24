package lab5.comparetors;

import lab5.comparetors.classes.Compra;
import java.util.Comparator;

public class ComparetorCompraPorData implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2){
        int comparado = c1.getData()
                .compareTo(c2.getData());

        if (comparado == 0){
            return c1.exibePorData()
                    .compareTo(c2.exibePorData());
        }
        return comparado;
    }
}
