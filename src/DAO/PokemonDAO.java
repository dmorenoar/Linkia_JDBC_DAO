/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IPokemonDAO;
import Models.Pokemon;
import excepciones.PokemonException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author daniel.moreno
 */
public class PokemonDAO implements IPokemonDAO{

    EntrenadorDAO eDao = new EntrenadorDAO();
    
    @Override
    public void insertarPokemon(Pokemon p) throws SQLException, PokemonException {
        if(existePokemon(p)){
            throw new PokemonException("Pokemon duplicado");
        }else{
            if(eDao.existeEntrenador(p.getEntrenador())){
                String insert = "Insert into Pokemon(nombre, tipo, fuerza, entrenador) values (?,?,?,?)";
                PreparedStatement ps = GestionDAO.conexion.prepareStatement(insert);
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getTipo());
                ps.setDouble(3, p.getFuerza());
                ps.setString(4, p.getEntrenador().getNombre());
                
                //Ejecutamos la instrucción
                ps.executeUpdate();
                ps.close();
            }else{
                throw new PokemonException("El entrenador no existe");
            }
        }
    }

    @Override
    public boolean existePokemon(Pokemon p) throws SQLException {
        String select = "Select * from pokemon where nombre='" + p.getNombre() + "'";
        //String select = "Select * from pokemon where nombre =?";
        
        Statement st = GestionDAO.conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        boolean existe = false;
        
        if(rs.next())
            existe = true;
        
        rs.close();
        st.close();
    
        return existe;
    }

    @Override
    public void borrarPokemon(Pokemon p) throws SQLException, PokemonException {
        if(existePokemon(p)){
            String delete = "Delete from pokemon where nombre = '" + p.getNombre() + "'";
            Statement st = GestionDAO.conexion.createStatement();
            
            st.executeUpdate(delete);
            st.close();
            
        }else{
            throw new PokemonException("El pokemo no existe");
        }
    }

    
    
    
    @Override
    public void subirNivelPokemon(String nombre, Double fuerza) throws SQLException, PokemonException {
        
        if(existePokemon(new Pokemon(nombre))){
            String update = "Update Pokemon set fuerza = ? where nombre = ?";
            PreparedStatement ps = GestionDAO.conexion.prepareStatement(update);
            
            ps.setDouble(1, fuerza);
            ps.setString(2, nombre);
            
            ps.executeUpdate();
            ps.close();
            
        }else{
            throw new PokemonException("El pokemon no existe");
        }
    }
    
    
}
