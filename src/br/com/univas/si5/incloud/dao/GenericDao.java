package br.com.univas.si5.incloud.dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public interface GenericDao<T> {

	// Busca pela chave primaria.
//	<T> find (Class<T> entityClass, Object primaryKey);
	
	// Faz o merge do estado da entidade no contexto atual.
//	<T> void merge (T entity);
	
	// Gerencia e persiste uma instancia
	public void persist (Object entity);
	
	// Remove a instancia da entidade.
	public void remove (Object entity);
	
	// Cria uma instancia de Query para executar uma SQL nativa.
	Query createNativeQuery (String sqlString);
	
	//Cria uma instancia de TypedQuery a partir da execucao da query.
	TypedQuery <T>createQuery(String qlString, Class<T> resulClass);
	
	// Obtem o objeto que controla a transacao.
	EntityTransaction getTransaction();
	
//	CriteriaBuilder getCriteriaBuilder();
}
