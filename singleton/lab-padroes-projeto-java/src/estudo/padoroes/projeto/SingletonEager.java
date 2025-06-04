package estudo.padoroes.projeto;

/**
* Singleton "apressado" (Lazy Singleton)
* Chamado de singleton apressado porque a instância é criada ao rodar a aplicação.
* 
* @author Thiago Marques
*/

public class SingletonEager {

    private static final SingletonEager instancia = new SingletonEager();
    private SingletonEager() {
        super();
    }
    public static SingletonEager getInstancia() {
        return instancia;
    }
}
