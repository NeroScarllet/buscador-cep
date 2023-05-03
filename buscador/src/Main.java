import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leituraCep = new Scanner(System.in);
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        int sair = 1;
        while(sair != 0) {

            System.out.println("-------------------------------------------");
            System.out.println("Digite um número de CEP para consulta:");
            var cep = leituraCep.nextLine();

            try {
                Endereco endereco1 = consulta.buscaEndereco(cep);
                System.out.println(endereco1);
                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.salvaJson(endereco1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------------------------------");
            System.out.println("Digite 0 para sair ou 1 para consultar outro CEP");
            sair = leitura.nextInt();
        }
    }
}
