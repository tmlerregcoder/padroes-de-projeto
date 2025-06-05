package estudo.padoroes.projeto.singleton;

/**
 * Singleton Lazy com Holder
 *
 * @author Thiago Marques
 * @see <a href="https://stackoverflow.com/questions/15019306/regarding-static-holder-singleton-pattern/24018148#24018148">Singleton "Lazy Holder"</a>
 */

public class SingletonLazyHolder {

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.INSTANCIA;
    }

    private static class InstanceHolder {
        private static final SingletonLazyHolder INSTANCIA = new SingletonLazyHolder();
    }

}



