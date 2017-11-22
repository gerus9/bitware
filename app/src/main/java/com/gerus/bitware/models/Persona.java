package com.gerus.bitware.models;

/**
 * Created by gerus-mac on 21/11/17.
 */

public class Persona {

    public static final char GENERO_MASCULINO = 'M';
    public static final char GENERO_FEMENINO = 'F';

    public static final int PESO_DEBAJO = -1;
    public static final int PESO_NORMAL = 0;
    public static final int PESO_SOBREPESO = 1;

    public static final int PESO_MIN_MASCULINO = 20;
    public static final int PESO_MAX_MASCULINO = 25;
    public static final int PESO_MIN_FEMENINO = 19;
    public static final int PESO_MAX_FEMENINO = 24;

    private static final byte MAYOR_EDAD = 18;

    private String nombre = "";
    private String apPaterno = "";
    private String apMaterno = "";
    private int edad = 0;
    private int nss;
    private char genero = GENERO_MASCULINO;
    private float peso = 0;
    private float altura = 0;

    public Persona() {

    }

    public Persona(String nombre, String apPaterno, String apMaterno, int edad, char genero) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.genero = genero;
    }

    public Persona(String nombre, String apPaterno, String apMaterno, int edad, int nss, char genero, float peso, float altura) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.nss = nss;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNss() {
        return nss;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if (comprobarSexo((genero))) {
            this.genero = genero;
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int calcularIMC() throws Exception {
        float pesoIdeal = peso / (altura * altura);
        int min = (genero == GENERO_MASCULINO) ? PESO_MIN_MASCULINO : PESO_MIN_FEMENINO;
        int max = (genero == GENERO_MASCULINO) ? PESO_MAX_MASCULINO : PESO_MAX_FEMENINO;
        return obtenerPesoIdeal(min, max, pesoIdeal);
    }

    private int obtenerPesoIdeal(int min, int max, float pesoIdeal) {
        return (pesoIdeal < min) ? PESO_DEBAJO : (pesoIdeal < max ? PESO_SOBREPESO : PESO_NORMAL);
    }

    public boolean esMayorEdad() {
        return this.edad >= MAYOR_EDAD;
    }

    private boolean comprobarSexo(char genero) {
        return (genero == GENERO_MASCULINO || genero == GENERO_FEMENINO);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", edad=" + edad +
                ", nss=" + nss +
                ", genero=" + genero +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
