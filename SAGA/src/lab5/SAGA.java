package lab5;

import easyaccept.EasyAccept;

import java.text.DecimalFormat;

public class SAGA {
    public static void main(String[] args) {
        args = new String[]{"lab5.Facade",
                "testes_aceitacao/use_case_1.txt",
                "testes_aceitacao/use_case_2.txt",
                "testes_aceitacao/use_case_3.txt",
                "testes_aceitacao/use_case_4.txt",
        };
        EasyAccept.main(args);
    }
}