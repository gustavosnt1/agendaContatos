/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package daodb4o;

import java.util.List;

import com.db4o.query.Query;

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
}

