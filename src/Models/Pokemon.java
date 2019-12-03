/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author dmorenoar
 */
public class Pokemon {

    private String nombre;
    private String tipo;
    private Double fuerza;
    private Entrenador entrenador;

    public Pokemon() {
    }

    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    public Pokemon(String nombre, String tipo, Double fuerza, Entrenador entrenador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.entrenador = entrenador;
    }

    public Double getFuerza() {
        return fuerza;
    }

    public void setFuerza(Double fuerza) {
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", tipo=" + tipo + ", entrenador=" + entrenador + '}';
    }
}
