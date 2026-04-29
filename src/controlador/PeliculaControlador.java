/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.PeliculaDAO;
import java.util.List;
import modelo.Pelicula;
public class PeliculaControlador {
    private final PeliculaDAO dao = new PeliculaDAO();
    
    public List<Pelicula> obtenerPelicula(){
        return dao.obtenerTodos();
    }
    
    public void guardarPelicula(String titulo, String director, int lanzamiento, int duracion, String genero, String idioma, String descripcion, double recaudacion, String estudiante, int stock){
        Pelicula p = new Pelicula(0,titulo,director, lanzamiento, duracion, genero, idioma, descripcion, recaudacion, estudiante, stock);
        dao.guardar(p);
    }
}
