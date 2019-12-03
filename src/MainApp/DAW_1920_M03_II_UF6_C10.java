/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import DAO.EntrenadorDAO;
import DAO.GestionDAO;
import DAO.PokemonDAO;
import Models.Entrenador;
import Models.Pokemon;
import excepciones.EntrenadorException;
import excepciones.PokemonException;
import java.sql.SQLException;
import java.util.Scanner;
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
        PokemonDAO pDao = new PokemonDAO();
        
        
        Entrenador ash = new Entrenador("Ash", "615228945");
        Entrenador brock = new Entrenador("Brock", "11111");
        
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 10.0,  brock);

        try {

            //Establecemos la conexión
            System.out.println("Estableciendo la conexión");
            dao.conectar();

            //Testeando insertar un entrenador
            System.out.println("Insertando entrenador");
            //eDao.insertarEntrenador(brock);
            System.out.println("Entrenador insertado correctamente");

            //Testeando insertar pokemon
            System.out.println("Insertando pokemon");
            //pDao.insertarPokemon(pikachu);
            System.out.println("Pokemon insertado");
            
            //Borrar pokemon
            System.out.println("Eliminando pokemon");
            //pDao.borrarPokemon(pikachu);
            System.out.println("Pokemon eliminado");
            
            //Modificar valor pokemon
            System.out.println("Subir nivel al pokemon");
            Scanner sc = new Scanner(System.in);
            /*
            System.out.println("Introduce el nombre del pokemon a modificar");
            String nombre = sc.next();
            System.out.println("Introduce la nueva fuerza");
            Double fuerza = sc.nextDouble();
            
            pDao.subirNivelPokemon(nombre, fuerza);
            System.out.println("Pokemon ha subido de nivel");
            */
            
            //Obtener todos los entrenadores
            for(Entrenador e: eDao.getAllEntrenadores()){
                System.out.println(e);
            }
            
            //Realizamos la desconexión
            System.out.println("Desconectando..");
            dao.desconectar();
            System.out.println("Desconexión realizada");

        } catch (SQLException e) {
            System.out.println("Error con:" + e.getMessage());
       /* } catch (EntrenadorException ex) {
            System.out.println("Error insertando el entreandor: " + ex.getMessage());*/
        /*} catch (PokemonException p) {
            System.out.println("Error insertando el pokemon: " + p.getMessage());
        }*/
        }
    }

}
