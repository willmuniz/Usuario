
package usuario;
import java.util.ArrayList;
import java.util.List;

public class Lista {
    private String nome;
    private List<Usuario> convidados;
    private Usuario convidadoPor;

    public Lista(String nome) {
        this.nome = nome;
        this.convidados = new ArrayList<>();
        this.convidadoPor = null;
    }

    public void convidar(Usuario convidado) {
        convidados.add(convidado);
    }

    public void listarConvidados() {
        for (Usuario convidado : convidados) {
            System.out.println(nome + " convidou " + convidado.getNome());
        }
    }

    public void listarConvidadosDiretos() {
        System.out.println("Usuários convidados por " + nome + ":");
        for (Usuario convidado : convidados) {
            System.out.println("- " + convidado.getNome());
        }
    }

    public void mostrarPai() {
        if (convidadoPor != null) {
            System.out.println("O convidado de " + nome + " é " + convidadoPor.getNome());
        } else {
            System.out.println(nome + " não tem um convidado.");
        }
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
    Lista lista = new Lista("Minha Lista");

    Usuario primeiroUsuario = new Usuario("João");
    Usuario segundoUsuario = new Usuario("Maria");
    Usuario terceiroUsuario = new Usuario("Pedro");

    primeiroUsuario.convidar(segundoUsuario);
    primeiroUsuario.convidar(terceiroUsuario);
    segundoUsuario.convidar(new Usuario("Ana"));

    primeiroUsuario.listarConvidados();
    segundoUsuario.listarConvidados();
    terceiroUsuario.listarConvidados();

    primeiroUsuario.mostrarPai();
    segundoUsuario.mostrarPai();
    terceiroUsuario.mostrarPai();

    lista.listarConvidadosDiretos();
}
}
