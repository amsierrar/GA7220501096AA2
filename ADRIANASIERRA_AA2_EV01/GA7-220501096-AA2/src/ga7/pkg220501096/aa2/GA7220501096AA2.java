/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ga7.pkg220501096.aa2;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GA7220501096AA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario="root";
        String password="Sena2025";
        String url="jdbc:mysql://localhost:3306/tecquim";
        Connection conexion;
        Statement statement;
        ResultSet resu;
        
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GA7220501096AA2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            resu=statement.executeQuery("SELECT * FROM proveedor");
            resu.next();
            do{
                System.out.println(resu.getInt("Nit")+"|"+ resu.getString("Nombre_proveedor")+"|"+ resu.getString("Tel_proveedor")+"|"+ resu.getString("Contacto_proveedor"));
            }while (resu.next());
            
            //Insert
            statement.executeUpdate("INSERT INTO proveedor VALUES(987654323,'Productos químicos latinos',2368547,'Cesar Mora','cmora@pql.com','calle olmos 456','Buenos Aires','Argentina','Ninguno')");
            resu=statement.executeQuery("SELECT * FROM proveedor");
            resu.next();
            do{
                System.out.println(resu.getInt("Nit")+"|"+ resu.getString("Nombre_proveedor")+"|"+ resu.getString("Tel_proveedor")+"|"+ resu.getString("Contacto_proveedor"));
            }while (resu.next());
            
            //Update
             statement.executeUpdate("UPDATE proveedor SET Contacto_proveedor='Colombia Perez' WHERE Nit=987654321");
            resu=statement.executeQuery("SELECT * FROM proveedor");
            resu.next();
            do{
                System.out.println(resu.getInt("Nit")+"|"+ resu.getString("Nombre_proveedor")+"|"+ resu.getString("Tel_proveedor")+"|"+ resu.getString("Contacto_proveedor"));
            }while (resu.next());
            
            //Delete
             statement.executeUpdate("DELETE from proveedor WHERE Nit=987654321");
            resu=statement.executeQuery("SELECT * FROM proveedor");
            resu.next();
            do{
                System.out.println(resu.getInt("Nit")+"|"+ resu.getString("Nombre_proveedor")+"|"+ resu.getString("Tel_proveedor")+"|"+ resu.getString("Contacto_proveedor"));
            }while (resu.next());
        
        } catch (SQLException ex) {
            Logger.getLogger(GA7220501096AA2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
