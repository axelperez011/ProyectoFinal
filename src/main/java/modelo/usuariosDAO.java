/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class usuariosDAO {
    
     Connection conexion;
     
    public usuariosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<usuarios> buscarUsuario(){
        
            PreparedStatement ps;
            ResultSet rs;
            List<usuarios> lista = new ArrayList<>();

            try{
                String consulta= "SELECT * FROM usuarios;";
                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String usuario = rs.getString("usuario");
                    String clave = rs.getString("clave");

                    usuarios usu = new usuarios(usuario,clave,id);

                    lista.add(usu);
                }
                return lista;
            } catch(SQLException e) {
                System.out.println(e.toString());
                return null;
        }
    } 
}
