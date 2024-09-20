package com.mycompany.tallerpoo;

public class Personal {
    private int idPersonal;
    private CodRol rol;

    Personal(){}
    Personal(int id, CodRol r){
        this.idPersonal = id;
        this.rol = r;
    }

    public CodRol getRol() {
        return rol;
    }

    public void setRol(CodRol rol) {
        this.rol = rol;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

}
