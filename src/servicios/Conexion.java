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
        //Existe documentacion donde indica que no necesitas invocar el Driver.class, pero si lo necesitas!!!
        //Estos valores no cambian, por lo cual prodrian ser FINAL(Constantes en los atributos de la clase)
        //insertar en url utf-8 para asegurarnos de que reconozca caracteres especiales

        url="jdbc:mysql://localhost:3306/instituto?useUnicode=true&characterEncoding=utf-8";
        user="root";
        pass="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        }
        catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conexion;
    }
}
