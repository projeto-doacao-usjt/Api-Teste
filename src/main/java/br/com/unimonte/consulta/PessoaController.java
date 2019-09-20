package br.com.unimonte.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import br.com.unimonte.consulta.exception.*;

import java.util.List;
import java.util.Map;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping("/pessoas")
    List<Pessoa> findAll() {
        return repository.findAll();
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Pessoa newBook(@RequestBody Pessoa newPessoa) {
        return repository.save(newPessoa);
    }

    @GetMapping("/pessoas/{id}")
    Pessoa findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    Pessoa saveOrUpdate(@RequestBody Pessoa newPessoa, @PathVariable Long id) {

		
        return repository.findById(id)
                .map(x -> {
                    x.setNome(newPessoa.getNome());
                    x.setEndereco(newPessoa.getEndereco());
                    x.setComplemento(newPessoa.getComplemento());
                    x.setNumero(newPessoa.getNumero());
                    x.setCep(newPessoa.getCep());
                    x.setTel(newPessoa.getTel());
                    x.setCpf(newPessoa.getCpf());
                    
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPessoa.setId(id);
                    return repository.save(newPessoa);
                });
    }

    @PatchMapping("/pessoas/{id}")
    Pessoa patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String nome = update.get("nome");
                    if (!StringUtils.isEmpty(nome)) {
                        x.setNome(nome);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new PessoaUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new PessoaNotFoundException(id);
                });

    }

    @DeleteMapping("/pessoas/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
