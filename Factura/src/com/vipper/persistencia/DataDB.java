/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.vipper.modelo.Pedido;

/**
 *
 * @author usuario
 */
public class DataDB extends Conexion {

	public boolean verPass(String usu,String pass) throws ClassNotFoundException, SQLException {
		boolean D1=false;
        String sql = "select 1 from usuarios where usuario=? and password=?";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        stmt.setString(1,usu);
        stmt.setString(2,pass);
        ResultSet rs = stmt.executeQuery();
        D1=rs.next();        
        cerrarConexion();
        return D1;
    }
	
	/* CRUD PEDIDOS */
	
	public List<Pedido> lPedidos() throws ClassNotFoundException, SQLException {
		List<Pedido> D1=new ArrayList<>();
        String sql = "select * from pedidos";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            D1.add(new Pedido(rs.getInt(1),rs.getDate(2).toLocalDate(),
            		          rs.getDouble(3),rs.getDouble(4),
            		          rs.getString(5),rs.getInt(6),
            		          rs.getInt(7),rs.getInt(8),
            		          rs.getInt(9)));
        }
        cerrarConexion();
        return D1;
    }

	public Pedido uPedido(int id) throws ClassNotFoundException, SQLException {
		Pedido D1=null;
        String sql = "select * from pedidos where id_pedido=?";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            D1 = new Pedido(rs.getInt(1),rs.getDate(2).toLocalDate(),
            	            rs.getDouble(3),rs.getDouble(4),
            		        rs.getString(5),rs.getInt(6),
            		        rs.getInt(7),rs.getInt(8),
            		        rs.getInt(9));
        }
        cerrarConexion();
        return D1;
    }
	
	public boolean nPedido(LocalDate fecha,double total,String descrip,int id,int id_contrato,int id_servicio,int id_forma_pago) throws ClassNotFoundException, SQLException {
        String sql = "insert into pedidos (fecha,total,importe_facturado,descrip) values (?,?,0,?)";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        stmt.setDate(1,Date.valueOf(fecha),Calendar.getInstance());
        stmt.setDouble(2, total);
        stmt.setString(3, descrip);
/*
        stmt.setInt(6, id);
        stmt.setInt(7, id_contrato);
        stmt.setInt(8, id_servicio);
        stmt.setInt(9, id_forma_pago);
        */
        boolean rs = stmt.execute();
        cerrarConexion();
        return rs;
    }
	
	public boolean mPedido(int pid,LocalDate fecha,double total,String descrip,int id,int id_contrato,int id_servicio,int id_forma_pago) throws ClassNotFoundException, SQLException {
        String sql = "update pedidos set fecha=?,total=?,importe_facturado=0,descrip=? where id_pedido=?";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        stmt.setDate(1,Date.valueOf(fecha),Calendar.getInstance());
        stmt.setDouble(2, total);
        stmt.setString(3, descrip);
/*
        stmt.setInt(6, id);
        stmt.setInt(7, id_contrato);
        stmt.setInt(8, id_servicio);
        stmt.setInt(9, id_forma_pago);
        */

        stmt.setInt(4, pid);
        boolean rs = stmt.execute();
        cerrarConexion();
        return rs;
    }

	public boolean bPedido(int id) throws ClassNotFoundException, SQLException {
		boolean D1=false;
        String sql = "delete * from pedidos where id_pedido=?";

        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        stmt.setInt(1, id);
        D1 = stmt.execute();
        cerrarConexion();
        return D1;
    }

	/* FORMA DE PAGO */
	
	public HashMap<Integer,String> lFPago() throws ClassNotFoundException, SQLException {
		HashMap<Integer,String> D1 = new HashMap<>();
		String sql = "select id_formadepago,descripcion from formadepago";
		
        abrirConexion();
        CallableStatement stmt = miConexion.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            D1.put(rs.getInt(1),rs.getString(2));
        }
        cerrarConexion();
		return D1;
	}

	/* CRUD CLIENTES */

	/* CRUD SERVICIOS */

	/* CRUD FACTURAS */
}
