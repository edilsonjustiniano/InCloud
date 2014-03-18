package br.com.univas.si5.incloud.bi;

import br.com.univas.si5.incloud.dao.HibernateUtil;
import br.com.univas.si5.incloud.dao.implement.UserDaoImpl;
import br.com.univas.si5.incloud.model.User;

public class UserBi {

	/*
	 * Dao
	 */
	private UserDaoImpl dao;
	
	public UserBi() {
		System.out.println("Construct");
		dao = new UserDaoImpl(HibernateUtil.getEntitymanagerfactory());
	}
	
	public void save(User user){
		System.out.println("aqui  User = " + user.getName());
		dao.persist(user);
	}
}
