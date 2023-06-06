import com.cursoceat.model.Alumno;
import servicios.AlumnoDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Alumno a = new Alumno("Maria","2B",5.3f,"2020-05-05");
        AlumnoDAO alumnoDao=new AlumnoDAO();
        // alumnoDao.create(a);
        //consultar por id
       // Alumno a=alumnoDao.read(13);
      //  a=new Alumno(13,"Josefa","3B",8.5f,"2000-04-25" );
      //  alumnoDao.update(a);
       // System.out.println("Nombre: "+ a.getNombre() + " ID: "+a.getId() + " Curso: "+ a.getCurso());
    //borrar
      //  alumnoDao.delete(13);
       // List<Alumno> miLista=new ArrayList<>();
      //  miLista=alumnoDao.readAll();
      //  for(Alumno alumno:miLista){
          //  System.out.println("Nombre: "+ alumno.getNombre() + " ID: "+alumno.getId() + " Curso: "+ alumno.getCurso());
      //  }
        List<Alumno> miLista= alumnoDao.leerCurso("1B");
         for(Alumno alumno:miLista) {
             System.out.println("Nombre: " + alumno.getNombre() + " ID: " + alumno.getId() + " Curso: " + alumno.getCurso());
         }
    }
}