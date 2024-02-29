import classes.ConsultaCEP;
import classes.Endereco;
import classes.GeraArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um número de CEP para consulta: ");
        var cep = leitura.nextLine();
        ConsultaCEP consultaCEP = new ConsultaCEP();

        try {
        Endereco novoEndereco = consultaCEP.buscaEndereco(cep);
        System.out.println(novoEndereco);
        GeraArquivo geraArquivo = new GeraArquivo();
        geraArquivo.salvaJson(novoEndereco);


        }catch (RuntimeException e){
            System.out.println("Não conseguir obter o endereço para esse cep");
            System.out.println("Finalizando a aplicação");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
