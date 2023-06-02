package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    private String url;
    private String user;
    private String pass;

    public Connection conectar(){
        url="jdbc:mariadb://localhost:3306/instituto";
        user="root";
        pass="";
        try{
            conexion= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conexion;
    }
}
