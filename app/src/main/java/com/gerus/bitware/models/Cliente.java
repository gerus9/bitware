package com.gerus.bitware.models;

import java.io.Serializable;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class Cliente {

    private int Cliente_ID;
    private String Nombre_Usuario;
    private String Contraseña;
    private String Nombre;
    private String Apellidos;
    private String Correo_Electronico;
    private int Edad;
    private double Estatura;
    private double Peso;
    private int Genero_ID;
    private int Actividad_Fisica_ID;
    private int Dieta_ID;
    private int Objetivo_ID;
    private double IMC;
    private int GEB;
    private double ETA;
    private int Peso_Maximo;
    private int Peso_Minimo;
    private double AF;
    private double Gasto_Energetico_Total;
    private int Tipo_Cliente_ID;
    private boolean Activo;
    private int Orden;
    private String Fecha_Creacion;
    private String Fecha_Actualizacion;
    private int Usuario_ID;
    private boolean Visible;
    private boolean De_Sistema;

    public int getCliente_ID() {
        return Cliente_ID;
    }

    public void setCliente_ID(int Cliente_ID) {
        this.Cliente_ID = Cliente_ID;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getEstatura() {
        return Estatura;
    }

    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public int getGenero_ID() {
        return Genero_ID;
    }

    public void setGenero_ID(int Genero_ID) {
        this.Genero_ID = Genero_ID;
    }

    public int getActividad_Fisica_ID() {
        return Actividad_Fisica_ID;
    }

    public void setActividad_Fisica_ID(int Actividad_Fisica_ID) {
        this.Actividad_Fisica_ID = Actividad_Fisica_ID;
    }

    public int getDieta_ID() {
        return Dieta_ID;
    }

    public void setDieta_ID(int Dieta_ID) {
        this.Dieta_ID = Dieta_ID;
    }

    public int getObjetivo_ID() {
        return Objetivo_ID;
    }

    public void setObjetivo_ID(int Objetivo_ID) {
        this.Objetivo_ID = Objetivo_ID;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public int getGEB() {
        return GEB;
    }

    public void setGEB(int GEB) {
        this.GEB = GEB;
    }

    public double getETA() {
        return ETA;
    }

    public void setETA(double ETA) {
        this.ETA = ETA;
    }

    public int getPeso_Maximo() {
        return Peso_Maximo;
    }

    public void setPeso_Maximo(int Peso_Maximo) {
        this.Peso_Maximo = Peso_Maximo;
    }

    public int getPeso_Minimo() {
        return Peso_Minimo;
    }

    public void setPeso_Minimo(int Peso_Minimo) {
        this.Peso_Minimo = Peso_Minimo;
    }

    public double getAF() {
        return AF;
    }

    public void setAF(double AF) {
        this.AF = AF;
    }

    public double getGasto_Energetico_Total() {
        return Gasto_Energetico_Total;
    }

    public void setGasto_Energetico_Total(double Gasto_Energetico_Total) {
        this.Gasto_Energetico_Total = Gasto_Energetico_Total;
    }

    public int getTipo_Cliente_ID() {
        return Tipo_Cliente_ID;
    }

    public void setTipo_Cliente_ID(int Tipo_Cliente_ID) {
        this.Tipo_Cliente_ID = Tipo_Cliente_ID;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(String Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public String getFecha_Actualizacion() {
        return Fecha_Actualizacion;
    }

    public void setFecha_Actualizacion(String Fecha_Actualizacion) {
        this.Fecha_Actualizacion = Fecha_Actualizacion;
    }

    public int getUsuario_ID() {
        return Usuario_ID;
    }

    public void setUsuario_ID(int Usuario_ID) {
        this.Usuario_ID = Usuario_ID;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean Visible) {
        this.Visible = Visible;
    }

    public boolean isDe_Sistema() {
        return De_Sistema;
    }

    public void setDe_Sistema(boolean De_Sistema) {
        this.De_Sistema = De_Sistema;
    }
}
