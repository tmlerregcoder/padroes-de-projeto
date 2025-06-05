package estudo.padoroes.projeto;

import estudo.padoroes.projeto.facade.Facade;
import estudo.padoroes.projeto.singleton.SingletonEager;
import estudo.padoroes.projeto.singleton.SingletonLazy;
import estudo.padoroes.projeto.singleton.SingletonLazyHolder;
import estudo.padoroes.projeto.strategy.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Testes relacionados ao Design Pattern Singleton:
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

        // Testes relacionados ao Design Pattern Strategy:
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();
        Comportamento normal = new ComportamentoNormal();
        Robo robo = new Robo();
        robo.setStrategy(normal);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.setStrategy(defensivo);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.mover();
        robo.setStrategy(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();


        // Testes relacionados ao Design Patter Facade:
        Facade facade = new Facade();
        facade.migrarCliente("Thiago", "22795570");
    }
}
