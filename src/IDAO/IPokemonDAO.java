/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Models.Pokemon;
import excepciones.PokemonException;
import java.sql.SQLException;

/**
 *
 * @author daniel.moreno
 */
public interface IPokemonDAO {
    void insertarPokemon(Pokemon p) throws SQLException, PokemonException;
    boolean existePokemon(Pokemon p) throws SQLException;
    void borrarPokemon(Pokemon p) throws SQLException, PokemonException;
    void subirNivelPokemon(String nombre, Double fuerza) throws SQLException, PokemonException;
}
