package br.com.univas.si5.incloud.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.univas.si5.incloud.dao.interfaces.UserDaoInterface;
import br.com.univas.si5.incloud.model.User;

public class UserDaoImpl implements UserDaoInterface<User> {

	private EntityManager entityManager; //entityManager para utilizar o banco de dados
	
	public UserDaoImpl(EntityManager em) {
		this.entityManager = em;
	}
	
	@Override
	public void persist(Object entity) {
		
		//inicializa a transação (pega e/ou cria) uma transação
		entityManager.getTransaction().begin();
		
		//realiza a persistência do objeto
		entityManager.persist(entity);
		
		//realiza o commit da transação
		entityManager.getTransaction().commit();
	}

	@Override
	public void remove(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Query createNativeQuery(String sqlString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypedQuery<User> createQuery(String qlString, Class<User> resulClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityTransaction getTransaction() {
		
		return null;
	}

}
