package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.vipper.persistencia.DataDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession Sesi = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
        request.setAttribute("out", "Error en LOGIN");
        try (DataDB BD=new DataDB()) {
			String usu=request.getParameter("nombre").toString();
			String pas=request.getParameter("pass").toString();
			if (BD.verPass(usu,pas)) {
				response.addCookie(new Cookie("Login","True"));
				rd = request.getRequestDispatcher("/menu.html");
			} else { 
                request.setAttribute("out", "Contraseña o Usuario no reconocido.");
			}
	    } catch (ClassNotFoundException | SQLException ex) {
	        request.setAttribute("out", "Error:"+ex.toString());
	    } catch (Exception ex) {
	        request.setAttribute("out", "Error:"+ex.toString());
	    }
	    rd.forward(request, response);
	}
}
