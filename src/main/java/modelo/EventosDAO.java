
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EventosDAO {
    
    Connection conexion;
    
    public EventosDAO() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Eventos> listarEventos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Eventos> lista = new ArrayList<>();
        
        try{
            
            ps = conexion.prepareStatement("SELECT id,nombre_evento,nombre_persona,fecha,hora FROM eventos");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String evento = rs.getString("nombreEvento");
                String persona = rs.getString("nombrePersona");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                
                Eventos eventos = new Eventos(id,evento,persona,fecha,hora);
                
                lista.add(eventos);
                        
            }
            
            return lista;
            
        } catch(SQLException e) {
        
            System.out.println(e.toString());
            
            return null;
    }
} 
    
    public Eventos mostrarEvento(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        Eventos evento = null;
        
        try{
            
            ps = conexion.prepareStatement("SELECT id,nombre_evento,nombre_persona,fecha,hora FROM eventos WHERE id=?");
            
            ps.setInt(1,_id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nomevento = rs.getString("nombreEvento");
                String persona = rs.getString("nombrePersona");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                
                evento = new Eventos(id,nomevento,persona,fecha,hora);
                
                                      
            }
            
            return evento;
            
        } catch(SQLException e) {
        
            System.out.println(e.toString());
            
            return null;
    }
} 

    public boolean insertar(Eventos evento){
        
        PreparedStatement ps;
      
        
        try{
            
            ps = conexion.prepareStatement("INSERT INTO eventos (nombre_evento,nombre_persona,fecha,hora) VALUES (?,?,?,?)");
            
            ps.setString(1, evento.getNomEvento());
            ps.setString(2, evento.getNomPersona());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            
            
            ps.execute();
            
            return true;
            
        } catch(SQLException e) {
        
            System.out.println(e.toString());
            
            return false;
        }
    }
    
    public boolean actualizar(Eventos evento){
        
        PreparedStatement ps;
      
        
        try{
            
            ps = conexion.prepareStatement("UPDATE eventos SET nombre_evento=?,nombre_persona=?,fecha=?,hora=? WHRE id=?");
            
            ps.setString(1, evento.getNomEvento());
            ps.setString(2, evento.getNomPersona());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getId());
            
            ps.execute();
            
            return true;
            
        } catch(SQLException e) {
        
            System.out.println(e.toString());
            
            return false;
        }
    }
    
    public boolean eliminar(int _id){
        
        PreparedStatement ps;
      
        
        try{
            
            ps = conexion.prepareStatement("DELETE FROM eventos WHRE id=?");
            
            ps.setInt(1, _id);
            
            ps.execute();
            
            return true;
            
        } catch(SQLException e) {
        
            System.out.println(e.toString());
            
            return false;
        }
    }
    
    
}