package design.patterns.spring.service.impl;

import design.patterns.spring.model.Cliente;
import design.patterns.spring.model.Endereco;
import design.patterns.spring.repository.ClienteRepository;
import design.patterns.spring.repository.EnderecoRepository;
import design.patterns.spring.service.ClienteService;
import design.patterns.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Strategy: implementando os metodos definidos na interface
    //Facade: Abstraindo integrações com subsistemas, provendo uma interface simples.

    //Singleton: promovendo uma única instancia de objetos com Spring Autowired (Beans de escopo singleton)
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ViaCepService viaCep;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        cliente.setEndereco(enderecoRepository.findById(cep).orElseGet(()->{
          Endereco novoEndereco = viaCep.consultarCep(cep);
          enderecoRepository.save(novoEndereco);
          return novoEndereco;
        }));
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // jeito indicado no video do exercicio
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        if(clienteSalvo.isPresent()){
            salvarClienteComCep(cliente);
        }
       /* melhor jeito???
        clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setEndereco(cliente.getEndereco());
                    clienteExistente.setNome(cliente.getNome());
                    return clienteRepository.save(clienteExistente);
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente com ID " + id + " não encontrado."
                )); */
    }

    @Override
    public void deletar(Long id) {

        clienteRepository.deleteById(id);

        clienteRepository.findById(id)
                .ifPresentOrElse(
                        clienteExistente -> clienteRepository.delete(clienteExistente),
                        () -> {
                            throw new ResponseStatusException(
                                    HttpStatus.NOT_FOUND, "Cliente com ID " + id + " não encontrado."
                            );
                        }
                );
    }
}
