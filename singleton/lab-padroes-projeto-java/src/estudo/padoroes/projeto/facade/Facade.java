package estudo.padoroes.projeto.facade;

import subsistema1.crm.CrmService;
import substistema2.cep.CepApi;

/**
 * Imagine que você tenna uma base de clientes que deseja migrar de um banco para um novo, ou incrementar uma base atual.
 */

public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);
        CrmService.gravarCliente(nome, cep, estado, cidade);

    }
}
