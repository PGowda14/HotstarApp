package Controler;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Userdao.Userdao;
import Userdto.Userdto;

@WebServlet("/Create")
public class Create extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String phoneno = req.getParameter("phoneno");
	String password = req.getParameter("pwd");
	String gender = req.getParameter("gender");
	String dob = req.getParameter("dob");
	Date date = Date.valueOf(dob);
	
	Userdao dao=new Userdao();
	
	if(dao.find(Long.parseLong(phoneno)).isEmpty() && dao.find(email).isEmpty()){
		Userdto dto=new Userdto();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhoneno(Long.parseLong(phoneno));
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setDob(date);
		
		dao.save(dto);
		Userdto dto2=dao.find(email).get(0);
		resp.getWriter().print("<h1> Account created successfull<h1>");
		resp.getWriter().print("<h1>your customer id is: "+dto2.getCid()+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
		
	}else{
		resp.getWriter().print("<h1>the given number/email is already exists plese enter the new number</h1>");
	}
}
}
