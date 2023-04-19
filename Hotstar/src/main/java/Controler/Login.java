package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Userdao.Userdao;
import Userdto.Userdto;

@WebServlet("/Login")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int cid=Integer.parseInt( req.getParameter("cid"));
	String password=req.getParameter("pwd");
	
	Userdao dao=new Userdao();
	
	Userdto dto=dao.find(cid);
	
	if(dto==null){
		resp.getWriter().print("<h1> incorrect customer id");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}else{
		if(dto.getPassword().equals(password)){
			req.getSession().setAttribute("dto", dto);
			resp.getWriter().print("<h1>login successfull</h1>");
			req.getRequestDispatcher("hotstar.html").include(req, resp);
		}else{
			resp.getWriter().print("<h1>incorrect password</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}
}
