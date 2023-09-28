/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package appconsole;

import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar() {
		try {
			Fachada.inicializar();
			System.out.println("cadastrando bairro...");
			Fachada.cadastrarBairro("Centro");
			Fachada.cadastrarBairro("Mangabeira");
			Fachada.cadastrarBairro("JoseAmerico");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("cadastrando endereco...");
			Fachada.cadastrarEndereco("Exemplo1", 111, "Centro");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("cadastrando pessoa...");
			Fachada.cadastrarPessoa("Gustavo", "Exemplo1", 111, "Centro", 3, "03102002");
			Fachada.cadastrarPessoa("Gustavo1", "Exemplo1", 111, "Centro", 3, "03102002");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("\nfim do programa !");
	}


	public static void main(String[] args) {
		new Cadastrar();
	}
}
