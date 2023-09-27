/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package appconsole;

import daodb4o.Util;
import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;
import modelo.Usuario;
import regras_negocio.Fachada;

public class Listar {

	public Listar() {
		try {
			Fachada.inicializar();
			System.out.println("\n---listagem de bair:");
			for(Bairro b: Fachada.listarBairros())
				System.out.println(b);

			System.out.println("\n---listagem de end:");
			for(Endereco e: Fachada.listarEnderecos())
				System.out.println(e);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Listar();
	}
}