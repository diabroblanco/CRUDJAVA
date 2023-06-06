package servicios;

import com.cursoceat.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
La clase AlumnosDao es una convensión donde se unen realizan una serie de métodos que
van a ser utilizados para acceder a la BBDD(listar, buscan, borrar, insertar...etc)
Como necesita acceder a la BBDD hereda de Conexion
 */
public class AlumnoDAO extends Conexion {
    String sql;

    /*
    El metodo create inserta un nuevo alumno a la BBDD
     */
    public void create(Alumno a) {
        Connection con = conectar();
        sql = "INSERT INTO alumnos (nombre,curso,media,fnac) VALUES (?,?,?,?);";
        //tenemos que capturar un posible error al generar la consulta por medio de un try-catch
        try {
            escribir(a, con, sql, "update");

            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //mostrar un alumno según su id
    public Alumno read(int id) {
        Alumno a = null;
        sql = "SELECT *FROM alumnos WHERE cod=?;";
        try {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                Float media = rs.getFloat("media");
                String curso = rs.getString("curso");
                String fnac = rs.getString("fnac");
                a = new Alumno(id, nombre, curso, media, fnac);
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return a;
    }

    //eSTE METODO ESCRIBIR REEMPLAZA EL CODIGO QUE ES DUPLICADO ENTRE CREAR Y ACTUALIZAR
    public void escribir(Alumno a, Connection con, String sql, String opcion) throws SQLException {
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, a.getNombre());
        pt.setString(2, a.getCurso());
        pt.setFloat(3, a.getMedia());
        //La fecha de nacimiento la recibimos como tipo java.util.date y la debemos castear a java.sql.date
        java.sql.Date sqlDate = new java.sql.Date(a.getfNacimiento().getTime());
        pt.setDate(4, sqlDate);
        if (opcion.equals("update")) {
            pt.setInt(5, a.getId());
        }
        pt.executeUpdate();
    }

    public void update(Alumno a) {
        if (a != null) {
            sql = "UPDATE alumnos SET nombre=?,curso=?, media=?,fnac=? WHERE cod=?;";
            try {
                Connection con = conectar();
                escribir(a, con, sql, "update");
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        sql = "DELETE FROM  alumnos WHERE cod=?;";
        try {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            pt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Crear lista con todos los datos de la tabla
    public List<Alumno> readAll() {
        List<Alumno> lista = new ArrayList<>();
        sql = "SELECT * FROM alumnos;";
        try {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int id = rs.getInt("cod");
                String curso = rs.getString("curso");
                float media = rs.getFloat("media");
                String fnac = rs.getString("fnac");
                Alumno a = new Alumno(id, nombre, curso, media, fnac);
                lista.add(a);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return lista;
    }

   public List<Alumno> leerCurso(String cursoComun) {
       List<Alumno> verCurso = new ArrayList<>();
       Alumno a = null;
       sql = "SELECT *FROM alumnos WHERE curso=?;";
       try {
           Connection con = conectar();
           PreparedStatement pt = con.prepareStatement(sql);
           pt.setString(1,cursoComun);
           ResultSet rs = pt.executeQuery();
           while (rs.next()) {
               String nombre = rs.getString("nombre");
               Float media = rs.getFloat("media");
               String curso = rs.getString("curso");
               String fnac = rs.getString("fnac");
               int id = rs.getInt("cod");
               a = new Alumno(id, nombre, curso, media, fnac);
               verCurso.add(a);

           }
           con.close();
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }

   return verCurso;
   }
}
