package aplicacao;

import java.time.LocalDate;
import java.util.Date;

import com.db4o.ObjectContainer;

import modelo.Bairro;
import modelo.Endereco;
import modelo.Pessoa;



public class Cadastrar {
	protected ObjectContainer manager;

	public Cadastrar(){
		manager = Util.conectarBanco();
		cadastrar();
		Util.desconectar();
		
		System.out.println("fim da aplicacao");
	}

	public void cadastrar(){
		System.out.println("Cadastrando...");

        Bairro bairro1 = new Bairro("Centro");
        Bairro bairro2 = new Bairro("Mangabeira");
        Bairro bairro3 = new Bairro("JoseAmerico");
        manager.store(bairro1);
        manager.store(bairro2);
        manager.store(bairro3);
        manager.commit();

        Endereco endereco1 = new Endereco(1, "Exemplo1",111, bairro1);
        Endereco endereco2 = new Endereco(2, "Exemplo2",222, bairro2);
        Endereco endereco3 = new Endereco(3, "Exemplo3",333, bairro3);
        manager.store(endereco1);
        manager.store(endereco2);
        manager.store(endereco3);
        manager.commit();
        
        Pessoa pessoa1 =  new Pessoa("Gustavo", endereco1, 1, new Date(2002-03-10));
        Pessoa pessoa2 =  new Pessoa("Alic", endereco2, 2, new Date(2002-03-10));
        Pessoa pessoa3 =  new Pessoa("Caio", endereco3, 3, new Date(2000-03-10));
        manager.store(pessoa1);
        manager.store(pessoa2);
        manager.store(pessoa3);
        manager.commit();
        
	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


