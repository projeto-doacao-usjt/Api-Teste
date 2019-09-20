package br.com.unimonte.consulta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import br.com.unimonte.consulta.Pessoa;


@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(PessoaRepository repository) {
        return args -> {
            repository.save(new Pessoa("Fulano", "Rua das Olivias", "do lado do bar", "435", "53454-030", "13996045353", "4543534"));
            repository.save(new Pessoa("Fulano2", "Rua das Olivias", "do lado do bar", "435", "53454-030", "13996045353", "4543534"));
        
        };
    }
}