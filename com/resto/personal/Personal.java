package com.mycompany.tallerpoo.com.resto.personal;

public class Personal {
    private int idPersonal;
    private CodRol rol;

    Personal(){}

    Personal(int id, CodRol r){
        this.idPersonal = id;
        this.rol = r;
    }

    public CodRol getRol() {
        return this.rol;
    }

    public void setRol(CodRol rol) {
        this.rol = rol;
    }

    public int getIdPersonal() {
        return this.idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

}
