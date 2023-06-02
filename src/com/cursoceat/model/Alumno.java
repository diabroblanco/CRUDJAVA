package com.cursoceat.model;

import java.util.Date;

public class Alumno {
    private int id;
    private String nombre;
    private String curso;
    private float media;
    private Date fNacimiento;

    //sugieren crear una constante con la longitud de caracteres del nombre;
    private final int TAMNOMBRE=50;

    public Alumno(){

    }

    public Alumno(int id, String nombre, String curso, float media, Date fNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.media = media;
        this.fNacimiento = fNacimiento;
    }

}
