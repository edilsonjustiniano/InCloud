package br.com.univas.si5.incloud.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Classe que irá retornar uma instância única do nosso 
 * EntityManager
 * 
 * EntityManager: Gerenciadores de entidade controlam a criação e remoção de classes entidade;
 */
public class HibernateUtil {

	private static final EntityManagerFactory entityManagerFactory = buildSessionFactory();

	
	/**
	 * DesignPattern para retornar sempre apenas uma instância.
	 * esse método que irá fazer toda a minha fábrica de entityManager
	 * @return
	 */
	private static EntityManagerFactory buildSessionFactory() {
		
		try {
			return Persistence.createEntityManagerFactory("InCloud"); //criar a fábrica
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * método utilizado para obter uma entityManager
	 * @return
	 */
	public static EntityManager getEntitymanagerfactory() {
		return entityManagerFactory.createEntityManager();
	}
	

}
