package br.com.unimonte.consulta.exception;

public class PessoaNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
        super("Pessoa id not found : " + id);
    }

}
