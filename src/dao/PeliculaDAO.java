/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Pelicula;
import conexion.CreateConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PeliculaDAO {
    private final CreateConnection connFactory = new CreateConnection();
    
    public List<Pelicula>obtenerTodos(){
        
        List<Pelicula> lista = new ArrayList<>();
            String sql = "SELECT * FROM pelicula";
        try(Connection conn = connFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            while(rs.next()){
                Pelicula p = new Pelicula(rs.getInt("id"),
                rs.getString("titulo"),rs.getString("director"),rs.getInt("lanzamiento"), rs.getInt("duracion"), rs.getString("genero"), rs.getString("idioma")
                ,rs.getString("descripcion"), rs.getDouble("recaudacion"), rs.getString("estudiante"), rs.getInt("stock"));
                
                lista.add(p);
                ps.close();
                conn.close();
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
        
    }
    
    public boolean guardar(Pelicula p){
        String sql = "INSERT INTO pelicula(titulo,director, lanzamiento, duracion, genero, idioma, descripcion, idioma,estudiante, stock) values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = connFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, p.getLanzamiento());
            ps.setInt(4, p.getDuracion());
            ps.setString(5, p.getGenero());
            ps.setString(6, p.getIdioma());
            ps.setString(7, p.getDescripcion());
            ps.setDouble(8, p.getRecaudacion());
            ps.setString(9, p.getEstudiante());
            ps.setInt(10, p.getStock());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
