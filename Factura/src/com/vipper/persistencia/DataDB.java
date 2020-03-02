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

	public boolean nPedidos(LocalDate fecha,double total,String descrip,int id,int id_contrato,int id_servicio,int id_forma_pago) throws ClassNotFoundException, SQLException {
        String sql = "insert into pedidos values (?,?,?,?,?)";

		System.out.println("1");
        abrirConexion();
		System.out.println("2");
        CallableStatement stmt = miConexion.prepareCall(sql);
		System.out.println("3");
		stmt.setInt(1, 0);
        stmt.setDate(2, Date.valueOf(fecha));
        stmt.setDouble(3, total);
        stmt.setDouble(4, 0);
        stmt.setString(5, descrip);
/*
        stmt.setInt(6, id);
        stmt.setInt(7, id_contrato);
        stmt.setInt(8, id_servicio);
        stmt.setInt(9, id_forma_pago);
        */
		System.out.println("4");
        boolean rs = stmt.execute();
		System.out.println("5");
        cerrarConexion();
        return rs;
    }
}
