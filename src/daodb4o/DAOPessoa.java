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
import modelo.Pessoa;

public class DAOPessoa extends DAO<Pessoa>{

	public Pessoa read (Object chave) {
		String nomePessoa = (String) chave;
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain(nomePessoa);
		List<Pessoa> resultados =  q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public List<Pessoa> grauAmizadeConsulta(int grauAmizade) {
		Query q;
		q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("grauAmizade").constrain(grauAmizade);
		return q.execute();
	}

	public List<Pessoa> pessoasMoramBairro(String nomeBairro) {
		Query q2;
		q2 = manager.query();
		q2.constrain(Pessoa.class);
		q2.descend("endereco").descend("bairro").descend("nomeBairro").constrain(nomeBairro);
		return q2.execute();
	}

}

