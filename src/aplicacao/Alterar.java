
package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar(){
		manager = Util.conectarBanco();
		alterar();
		Util.desconectar();
		
		System.out.println("fim da aplicacao");
	}
	
	public void alterar() {
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain("Gustavo");
		List<Pessoa> resultado = q.execute();
		
		if(resultado.size()>0) {
			Pessoa p = resultado.get(0);
			p.setGrauAmizade(5);
			manager.store(p);
			manager.commit();
			System.out.println("Alteracao feita.");
		} else
			System.out.println("Não encontrado");
			
	}

	public static void main(String[] args) {
		new Alterar();
	}
}
