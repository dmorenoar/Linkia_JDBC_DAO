/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dmorenoar
 */
public class GestionDAO {
    
    public static Connection conexion;
    
    //Métodos de conexión y desconexión
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ligapokemon"; //Conexión con el driver JDBC
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }
    
    public void desconectar() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }
}
