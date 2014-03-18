package br.com.univas.si5.incloud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.univas.si5.incloud.bi.UserBi;
import br.com.univas.si5.incloud.model.User;

public class IndexServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Teste");
		
		User user = new User();
		//user.setId(1l);
		user.setName("Edilson");
		
		System.out.println("Antes de UserBi");
		UserBi userBi = new UserBi();
		System.out.println("Depois de UserBi");
		userBi.save(user);
		
		System.out.println("criou o user");
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	}

}
