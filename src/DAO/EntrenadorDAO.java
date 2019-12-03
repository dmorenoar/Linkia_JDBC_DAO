/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IEntrenadorDAO;
import Models.Entrenador;
import excepciones.EntrenadorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmorenoar
 */
public class EntrenadorDAO implements IEntrenadorDAO {

    @Override
    public void insertarEntrenador(Entrenador e) throws EntrenadorException, SQLException {
        if (existeEntrenador(e)) {
            throw new EntrenadorException("El entrenador ya existe");
        } else {
            String insert = "Insert into Entrenador(nombre, telefono) values (?,?)";
            
            //Usaremos el preparedStatement
            PreparedStatement ps = GestionDAO.conexion.prepareStatement(insert);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getTelefono());
            
            //Ejecutamos la consulta
            ps.executeUpdate();
            
            //Cerramos nuestro PreparedStatement
            ps.close();
        }
    }

    @Override
    public boolean existeEntrenador(Entrenador e) {

        boolean existe = false;

        //Construimos la consulta
        String select = "Select * from Entrenador where nombre='" + e.getNombre() + "'";

        try {
            //Creamos el statement con la conexion
            Statement st = GestionDAO.conexion.createStatement();

            //Ejecutamos la consulta
            ResultSet rs = st.executeQuery(select);

            //Comprobamos si el resulset ha encontrado algo
            if (rs.next()) {
                existe = true;
            }

            //Cerramos el statement y el resulset
            rs.close();
            st.close();

        } catch (SQLException ex) {
            System.out.println("Error comprobando si existe entrenador");
        }

        return existe;
    }

    @Override
    public ArrayList<Entrenador> getAllEntrenadores() throws SQLException {
        
        ArrayList<Entrenador> listEntrenadores = new ArrayList<>();
        
        String select = "Select * from Entrenador";
        Statement st = GestionDAO.conexion.createStatement();
        
        ResultSet rs = st.executeQuery(select);
        
        while(rs.next()){
            
            Entrenador e = new Entrenador();
            e.setNombre(rs.getString("nombre"));
            e.setTelefono(rs.getString("telefono"));     
            listEntrenadores.add(e);
            
        }
        
        rs.close();
        st.close();
        
        return listEntrenadores;
    }

}
