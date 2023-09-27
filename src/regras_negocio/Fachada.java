package regras_negocio;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOBairro;
import daodb4o.DAOEndereco;
import daodb4o.DAOPessoa;
import daodb4o.DAOUsuario;
import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;
import modelo.Usuario;

public class Fachada {
	private Fachada() {}

	private static DAOEndereco daoendereco = new DAOEndereco();  
	private static DAOBairro daobairro = new DAOBairro(); 
	private static DAOPessoa daopessoa = new DAOPessoa(); 
	private static DAOUsuario daousuario = new DAOUsuario(); 
	public static Usuario logado;	//contem o objeto Usuario logado em TelaLogin.java

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}


	public static Bairro cadastrarBairro(String nomeBairro) throws Exception{
		DAO.begin();
		Bairro bairro = daobairro.read(nomeBairro);
		if (bairro!=null)
			throw new Exception("bairro ja cadastrado:" + " " + nomeBairro);
		bairro  = new Bairro(nomeBairro);

		daobairro.create(bairro);
		DAO.commit();
		return bairro;
	}

	public static Endereco cadastrarEndereco(String rua, int numero, String nomeBairro) throws Exception {
		DAO.begin();
		Bairro bar = daobairro.read(nomeBairro);
		if (bar==null)
			throw new Exception("Bairro não existe:" + " " + nomeBairro);

		Endereco end = new Endereco(rua, numero, nomeBairro);


		bar.adicionarEndereco(end);;
		daobairro.update(bar);
		daoendereco.create(end);
		DAO.commit();
		return end;
	}

	//todo cadastrarPessoa
	

	public static List<Bairro>  listarBairros(){
		DAO.begin();
		List<Bairro> resultados =  daobairro.readAll();
		DAO.commit();
		return resultados;
	} 

	public static List<Endereco>  listarEnderecos(){
		DAO.begin();
		List<Endereco> resultados =  daoendereco.readAll();
		DAO.commit();
		return resultados;
	}

	//todo listarPessoas

	public static List<Usuario>  listarUsuarios(){
		DAO.begin();
		List<Usuario> resultados =  daousuario.readAll();
		DAO.commit();
		return resultados;
	} 


	public static Bairro localizarBairro(String nomeBairro){
		return daobairro.read(nomeBairro);
	}
	public static Endereco localizarEndereco(String rua){
		return daoendereco.read(rua);
	}
	public static Pessoa localizarPessoa(String nome){
		return daopessoa.read(nome);
	}

	
	//------------------Usuario------------------------------------
	public static Usuario cadastrarUsuario(String nome, String senha) throws Exception{
		DAO.begin();
		Usuario usu = daousuario.read(nome);
		if (usu!=null)
			throw new Exception("Usuario ja cadastrado:" + nome);
		usu = new Usuario(nome, senha);

		daousuario.create(usu);
		DAO.commit();
		return usu;
	}
	public static Usuario localizarUsuario(String nome, String senha) {
		Usuario usu = daousuario.read(nome);
		if (usu==null)
			return null;
		if (! usu.getSenha().equals(senha))
			return null;
		return usu;
	}
}
