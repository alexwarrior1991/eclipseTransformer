package com.alejandro.eclipsetransformer.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("beanEjemplo")
@ManagedBean(value = "beanEjemplo")
@ViewScoped
public class BeanEjemplo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private List<String> listaUsuarios;

    public BeanEjemplo() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario() {
        if (nombre != null && !nombre.isEmpty()) {
            listaUsuarios.add(nombre);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario agregado", nombre));
            nombre = "";
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre no puede estar vacio"));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
