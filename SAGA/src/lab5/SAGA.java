package lab5;

import easyaccept.EasyAccept;

public class SAGA {
    public static void main(String[] args) {
        args = new String[]{"lab5.facades.Facade",
                "testes_aceitacao/use_case_1.txt",
                "testes_aceitacao/use_case_2.txt",
                "testes_aceitacao/use_case_3.txt",
                "testes_aceitacao/use_case_4.txt",
                "testes_aceitacao/use_case_5.txt",
                "testes_aceitacao/use_case_6.txt",
                "testes_aceitacao/use_case_7.txt",
                "testes_aceitacao/use_case_8.txt",
        };
        EasyAccept.main(args);
    }
}