package br.com.unimonte.consulta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    
    private String nome;
	private String endereco;
	private String complemento;
	private String numero;
	private String cep;
	private String tel;
	private String cpf;
	

    public Pessoa() {
    }

    

    public Pessoa(Long id, String nome, String endereco, String complemento, String numero, String cep, String tel,
			String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.tel = tel;
		this.cpf = cpf;
	}
    
    public Pessoa(String nome, String endereco, String complemento, String numero, String cep, String tel,
			String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.tel = tel;
		this.cpf = cpf;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", tel='" + tel + '\'' +
                ", cpf=" + cpf +
                '}';
    }

}
