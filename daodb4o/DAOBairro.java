/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;

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

}
