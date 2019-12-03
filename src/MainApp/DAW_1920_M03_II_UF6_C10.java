/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import DAO.EntrenadorDAO;
import DAO.GestionDAO;
import Models.Entrenador;
import Models.Pokemon;
import excepciones.EntrenadorException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmorenoar
 */
public class DAW_1920_M03_II_UF6_C10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        GestionDAO dao = new GestionDAO();
        EntrenadorDAO eDao = new EntrenadorDAO();

        Entrenador ash = new Entrenador("Ash", "615228945");
        Entrenador brock = new Entrenador("Brock", "11111");
        
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", ash);

        try {

            //Establecemos la conexión
            System.out.println("Estableciendo la conexión");
            dao.conectar();

            
            
            //Testeando insertar un entrenador
            System.out.println("Insertando entrenador");
            eDao.insertarEntrenador(brock);
            System.out.println("Entrenador insertado correctamente");


            //Realizamos la desconexión
            System.out.println("Desconectando..");
            dao.desconectar();
            System.out.println("Desconexión realizada");

        } catch (SQLException e) {
            System.out.println("Error con:" + e.getMessage());
        } catch (EntrenadorException ex) {
            System.out.println("Error insertando el entreandor: " + ex.getMessage());
        }
    }

}
