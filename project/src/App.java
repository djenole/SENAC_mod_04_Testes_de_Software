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

                            case 2: 
                            System.out.print("adicionar um contato");
                            System.out.println();
                            System.out.println("id: ");
                            int id = sc.nextInt();
                            System.out.println("Nome: ");
                            String nome = sc.next();
                            System.out.println("Email: ");
                            String email = sc.next();
                       
                            
                            Contato contatoNovo = new Contato(id, nome, email);
                            
                            gerContatos.adicionaContato(contatoNovo);
                            
                            Contato result = gerContatos.pesquisaContato(id);
                            System.out.println(result.toString());
                            break;
                            
                            case 3:
                                System.out.print("Digite o ID do contato: ");
                                int id_contato = sc.nextInt();
                    
                                Contato removerContato = gerContatos.pesquisaContato(id_contato);

                                if(removerContato != null) {
                                    gerContatos.removeContato(id_contato);
                                    System.out.println("*** Contato removido com SUCESSO ***");
                                } else {
                                    System.out.println("comando inválido");
                                }
                                break;
                            
                            case 4:
                             continua = false;
                             System.out.println("################# Sistema Encerrado #################");
                            break;

                            default:
                            System.out.println("#################************#################");
                            System.out.println("#################************#################");
                    }
                }     
            }
            private static void printMenu() {
                System.out.println("O que voc� deseja fazer? \n");
                System.out.println("1) Consultar um contato");
                System.out.println("2) Adicionar um contato");
                System.out.println("3) Remover um contato");
                System.out.println("4) Sair");
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
