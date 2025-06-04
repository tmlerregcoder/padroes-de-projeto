package estudo.padoroes.projeto;

/**
 * Singleton "preguiçoso" (Lazy Singleton)
 * 
 * Chamado de singleton preguiçoso porque a instância é criada apenas quando é realmente necessária.
 * 
 * @author Thiago Marques
 */

public class SingletonLazy {

    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia() {
        if (instancia == null) {
            instancia = new SingletonLazy();
        }
        return instancia;
    }

    public void exibirMensagem() {
        System.out.println("Exibindo mensagem do Singleton Lazy");
    }

}
