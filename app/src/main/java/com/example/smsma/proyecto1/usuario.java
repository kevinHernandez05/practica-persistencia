package com.example.smsma.proyecto1;

import android.os.Parcel;
import android.os.Parcelable;

public class usuario implements Parcelable {

    private String nombre;
    private String acercaDe;
    private String email;
    private int repositorios;
    private int estrellas;
    private int proyectos;

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getAcercaDe() {

        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {

        this.acercaDe = acercaDe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(int repositorios) {
        this.repositorios = repositorios;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getProyectos() {
        return proyectos;
    }

    //Para el Source
    protected usuario(Parcel in) {

        this.nombre = in.readString();
        this.acercaDe = in.readString();
        this.email = in.readString();
        this.estrellas = in.readInt();
        this.proyectos = in.readInt();
        this.repositorios = in.readInt();
    }

    public void setProyectos(int proyectos) {
        this.proyectos = proyectos;
    }

    //Serializar con Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getNombre());
        dest.writeString(this.getEmail());
        dest.writeString(this.getAcercaDe());
        dest.writeInt(this.getEstrellas());
        dest.writeInt(this.getProyectos());
        dest.writeInt(this.getRepositorios());
    }

    public usuario() {
    }

    public static final Creator<usuario> CREATOR = new Creator<usuario>() {
        @Override
        public usuario createFromParcel(Parcel source) {
            return new usuario(source);
        }

        @Override
        public usuario[] newArray(int size) {
            return new usuario[size];
        }
    };
}
