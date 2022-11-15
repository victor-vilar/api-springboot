package tests.entities;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.domain.Client;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestClient {
	public static void main(String[] args) {
		
		
		ClientDao dao = new ClientDao(EntityManagerBuilder.getEntityManager());
		Client cliente = new Client("Teste de Safadeza");
		cliente.setCpfCnpj("12525299701");
		dao.saveClient(cliente);
		
		
		
		
	}
}
