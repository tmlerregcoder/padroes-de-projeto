package estudo.padoroes.projeto;

/**
* Singleton Lazy com Holder 
* 
* @see <a href="https://stackoverflow.com/questions/15019306/regarding-static-holder-singleton-pattern/24018148#24018148">Singleton "Lazy Holder"</a>
* @author Thiago Marques
*/

public class SingletonLazyHolder {
    
    
    private SingletonLazyHolder() {
        super();
    }
    
    private static class InstanceHolder {
        private static final SingletonLazyHolder INSTANCIA = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.INSTANCIA;
    }

}



