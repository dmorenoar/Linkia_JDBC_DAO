/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Models.Entrenador;
import excepciones.EntrenadorException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dmorenoar
 */
public interface IEntrenadorDAO {
    void insertarEntrenador(Entrenador e) throws EntrenadorException, SQLException;
    boolean existeEntrenador(Entrenador e);
    ArrayList<Entrenador> getAllEntrenadores() throws SQLException;
}
