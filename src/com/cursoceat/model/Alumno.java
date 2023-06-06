package com.cursoceat.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno {
    private int id;
    private String nombre;
    private String curso;
    private float media;
    private Date fNacimiento;

    //sugieren crear una constante con la longitud de caracteres del nombre;
    private final int TAMNOMBRE=50;

    public Alumno(int id){
    this.id=id;
    }

    public Alumno(String nombre, String curso, float media, String fNacimiento) throws  ParseException{
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        //dale formato a la fecha
        SimpleDateFormat formato=new SimpleDateFormat( "yyyy-MM-dd");

        this.fNacimiento =formato.parse(fNacimiento);
    }

    public Alumno(int id, String nombre, String curso, float media, String fNacimiento)  throws ParseException {
        this.id = id;
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        //dale formato a la fecha
        SimpleDateFormat formato=new SimpleDateFormat( "yyyy-MM-dd");

        this.fNacimiento =formato.parse(fNacimiento);//hay que agregar un ParseException para evitar el error
    }

        //metodo para delimitar caracteres en nombre

        //metodo para delimitar caracteres del curso
    public void  setNombre(String nombre){
        //utilizamos la constante TAMNOMBRE
    this.nombre=nombre.substring(0, Math.min(TAMNOMBRE, nombre.length()));

    }
    public void setCurso(String curso){
        this.curso=curso.substring(0,Math.min(2,curso.length()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getNombre() {

        return nombre;
    }

    public String getCurso() {
        return curso;
    }

}
