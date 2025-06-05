package estudo.padoroes.projeto.singleton;

/**
 * Singleton "apressado" (Lazy Singleton)
 * Chamado de singleton apressado porque a instância é criada ao rodar a aplicação.
 *
 * @author Thiago Marques
 */

public class SingletonEager {

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }
}
