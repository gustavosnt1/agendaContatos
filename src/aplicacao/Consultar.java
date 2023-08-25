package aplicacao;


import java.util.List;


import com.db4o.ObjectContainer;
/*import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;*/
import com.db4o.query.Query;

import modelo.Pessoa;


public class Consultar {
	protected ObjectContainer manager;

	public Consultar(){
		manager = Util.conectarBanco();
		consultar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void consultar(){
		System.out.println("Procurar Gustavo");
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain("Gustavo");
		List<Pessoa> resultados = q.execute();
		if (resultados.size()>0) {
			Pessoa p = resultados.get(0);
			System.out.println("Gustavo encontrado"); 
		}
		else 
			System.out.println("Gustavo nao encontrado");
			
	}
	
	public static void main(String[] args) {
		new Consultar();
	}
}

