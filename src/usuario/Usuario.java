package usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Usuario> convidados;
    private Usuario pai;

    public Usuario(String nome) {
        this.nome = nome;
        this.convidados = new ArrayList<>();
        this.pai = null;
    }

    public Usuario(String nome, Usuario pai) {
        this(nome);
        this.pai = pai;
    }

    public void convidar(Usuario convidado) {
        convidados.add(convidado);
    }

    public void listarConvidados() {
        for (Usuario convidado : convidados) {
            System.out.println(nome + " convidou " + convidado.getNome());
        }
    }

    public void mostrarPai() {
        if (pai != null) {
            System.out.println("O convidado de " + nome + " é " + pai.getNome());
        } else {
            System.out.println(nome + " não tem um convidado.");
        }
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        Usuario primeiroUsuario = new Usuario("João");
        Usuario segundoUsuario = new Usuario("Maria", primeiroUsuario);
        Usuario terceiroUsuario = new Usuario("Pedro", primeiroUsuario);

        primeiroUsuario.convidar(new Usuario("Ana"));
        primeiroUsuario.convidar(new Usuario("Carlos"));
        segundoUsuario.convidar(new Usuario("Alice"));

        primeiroUsuario.listarConvidados();
        segundoUsuario.listarConvidados();
        terceiroUsuario.listarConvidados();

        primeiroUsuario.mostrarPai();
        segundoUsuario.mostrarPai();
        terceiroUsuario.mostrarPai();
    }
}
