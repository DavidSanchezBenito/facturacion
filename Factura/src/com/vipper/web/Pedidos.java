package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.vipper.modelo.Pedido;
import com.vipper.persistencia.DataDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/pedidos")
public class Pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedidos() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession Sesi = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
        request.setAttribute("out", "No estas LOGEADO");
        boolean login=false;
		Cookie ck[]=request.getCookies();  
		for(Cookie e:ck){
			if ("Login".equals(e.getName())) {
				if ("True".equals(e.getValue()));
				login = true;
			}
		}
		if (login==true) {
	        request.setAttribute("out", "Error en PEDIDOS");
	        try (DataDB BD=new DataDB()) {
	        	switch (request.getParameter("accion")) {
        		case "M":
        			Pedido P = BD.uPedido(Integer.parseInt(request.getParameter("id").toString()));
        			request.setAttribute("pid", request.getParameter("id"));
                    request.setAttribute("descrip", P.getDescrip());
                    request.setAttribute("fecha", P.getFecha());
                    request.setAttribute("imptotal", String.format("%.0f",P.getTotal()));
                    request.setAttribute("DataFPago", BD.lFPago());
                    request.setAttribute("fpago", P.getId_forma_pago());
                    rd = request.getRequestDispatcher("/mpedido.jsp");
        			break;
        		case "N":
                    request.setAttribute("fecha", LocalDate.now());
                    request.setAttribute("DataFPago", BD.lFPago());
                    rd = request.getRequestDispatcher("/ipedido.jsp");
        			break;
        		default:
        			if ("GM".equals(request.getParameter("accion"))) {
        				BD.mPedido(Integer.parseInt(request.getParameter("pid")),
        				     	   LocalDate.parse(request.getParameter("fecha")),
    						       Double.parseDouble(request.getParameter("imptotal")),
    						       request.getParameter("descrip"),
    						       0, 0, 0, 0);
        			}
        			if ("GN".equals(request.getParameter("accion"))) {
        				BD.nPedido(LocalDate.parse(request.getParameter("fecha")),
        						   Double.parseDouble(request.getParameter("imptotal")),
        						   request.getParameter("descrip"),
        						   0, 0, 0, 0);
        			}
        			if ("B".equals(request.getParameter("accion"))) {
        				if (BD.bPedido(Integer.parseInt(request.getParameter("id").toString()))==false) {
        			        request.setAttribute("out", "No se puede BORRAR");
        			        break;
        				}
        			}
        			List<Pedido> OutData=BD.lPedidos();
                    request.setAttribute("OutData", OutData);
                    rd = request.getRequestDispatcher("/pedidos.jsp");
        			break;
	        	}
		    } catch (ClassNotFoundException | SQLException ex) {
		        request.setAttribute("out", "Error:"+ex.toString());
		    } catch (Exception ex) {
		        request.setAttribute("out", "Error:"+ex.toString());
		    }
		}
	    rd.forward(request, response);
	}
}