import java.util.List;

public class GerenciadoraContatos {
    private List<Contato> contatosExistentes;

    public GerenciadoraContatos(List<Contato> contatosExistentes) {
        this.contatosExistentes = contatosExistentes;
    }

    public List<Contato> getContatosExistentes() {
        return contatosExistentes;
    }

    public void adicionaContato(Contato novoContato) {
        contatosExistentes.add(novoContato);
    }

    public Contato pesquisaContato(int idContato) {
        for(Contato contato : contatosExistentes) {
            if(contato.getId() == idContato)
                return contato;
        }
        return null;
    }

    public boolean removeContato(int idContato) {
        boolean contatoRemovido = false;

        for(int i = 0; i < contatosExistentes.size();i++) {
            Contato contato = contatosExistentes.get(i);
            if(contato.getId() == idContato) {
                contatosExistentes.remove(i);
                contatoRemovido = true;
                break;
            }
        }
        return contatoRemovido;
    }


}
