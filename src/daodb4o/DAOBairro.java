/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Bairro;

public class DAOBairro  extends DAO<Bairro>{

	public Bairro read (Object chave){
		String bairro = (String) chave;	
		Query q = manager.query();
		q.constrain(Bairro.class);
		q.descend("nomeBairro").constrain(bairro);
		List<Bairro> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public List<Bairro> bairroMaisEnderecos(int n) {
		Query q3;
		q3 = manager.query();
		q3.constrain(Bairro.class);
		q3.constrain( new Filtro() );
		return q3.execute();

	}
	//todo ajeitar consulta bairroMaisEnderecos
	class Filtro implements Evaluation {
		public void evaluate(Candidate candidate) {
			Bairro b = (Bairro) candidate.getObject();
			if (b.getEnderecos().size() > 2)
				candidate.include(true);

			else

				candidate.include(false);
		}
	}
}
