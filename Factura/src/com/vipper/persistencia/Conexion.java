/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipper.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conexion implements AutoCloseable {
    protected Connection miConexion;
    
    protected void abrirConexion() throws ClassNotFoundException, SQLException {
        //Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        String stringConexion =  "jdbc:mysql://localhost:3306/facturacion?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
                + "serverTimezone=UTC&autoReconnect=true&useSSL=false";
        miConexion = DriverManager.getConnection(stringConexion,"root","Curso2019$");
        //System.out.println("Exito al abrir la conexion");
    }
    
    protected void cerrarConexion() throws SQLException{
        miConexion.close();
    }
    
    @Override
    public void close() throws SQLException {
        if (miConexion != null) {
            if (!miConexion.isClosed()) {
                miConexion.close();
            }
        }
    }
}
