package com.alejandro.eclipsetransformer.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

//@ManagedBean(value = "layoutBean")
@ViewScoped
@Named("layoutBean")
public class LayoutBean implements Serializable {

    private String headerText;
    private String menuText;
    private String contentText;

    public LayoutBean() {
        this.headerText = "Bienvenido al Encabezado";
        this.menuText = "Opciones del Menú Lateral";
        this.contentText = "Este es el contenido principal.";
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
