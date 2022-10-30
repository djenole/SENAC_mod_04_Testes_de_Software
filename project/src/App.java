import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static GerenciadoraContatos gerContatos;
    public static void main(String[] args) throws Exception {
        inicializaSistemaContatos();

        Scanner sc = new Scanner(System.in);
        boolean continua = true;

       
        while (continua) {
            printMenu();

            int opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    System.out.print("Digite o ID do contato: ");
                    int idContato = sc.nextInt();
                    
                    Contato contato = gerContatos.pesquisaContato(idContato);

                    if(contato != null)
                        System.out.println(contato.toString());
                        else
                            System.out.println("Contato não encontrado");
                        
                            pulaLinha();
                            break;
                
            }
        }     
    }
    private static void printMenu() {
        System.out.println("O que voc� deseja fazer? \n");
        System.out.println("1) Consultar por um cliente");
        System.out.println("2) Consultar por uma conta corrente");
        System.out.println("3) Ativar um cliente");
        System.out.println("4) Desativar um cliente");
        System.out.println("5) Sair");
        System.out.println();   
    }

    private static void pulaLinha() {
        System.out.println("\n");
    }
    
    private static void inicializaSistemaContatos() {
        List<Contato> contatosExistentes = new ArrayList<>();


        Contato contato01 = new Contato(1, "Djenole", "djenole@gmail.com");
        Contato contato02 = new Contato(2, "Jubileu", "jubileu@email.com");

        contatosExistentes.add(contato01);
        contatosExistentes.add(contato02);

        gerContatos = new GerenciadoraContatos(contatosExistentes);
    }

    
}
