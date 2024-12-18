package com.alejandro.eclipsetransformer.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("miBean")
@ViewScoped
@ManagedBean(value = "miBean")
public class MiBean implements Serializable {

    private String nombre;
    private List<String> listaNombres;

    // Constructor
    public MiBean() {
        listaNombres = new ArrayList<>();
    }

    public void agregar() {
        if (nombre != null && !nombre.trim().isEmpty()) {
            listaNombres.add(nombre);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Nombre agregado", "Has agregado: " + nombre));
            nombre = "";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo de nombre no puede estar vacío"));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListaNombres() {
        return listaNombres;
    }

    public void setListaNombres(List<String> listaNombres) {
        this.listaNombres = listaNombres;
    }
}
