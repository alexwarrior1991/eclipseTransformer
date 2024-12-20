package com.alejandro.eclipsetransformer.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named(value = "productoBean")
@RequestScoped
public class ProductoBean {

    // Clase Producto: Modelo simple con nombre, precio y cantidad
    public static class Producto {
        private String nombre;
        private BigDecimal precio;
        private int cantidad;

        public Producto(String nombre, BigDecimal precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public BigDecimal getPrecio() {
            return precio;
        }

        public void setPrecio(BigDecimal precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }

    // Lista de productos
    private final List<Producto> productos;

    public ProductoBean() {
        productos = new ArrayList<>();
        productos.add(new Producto("Manzana", new BigDecimal("0.99"), 120));
        productos.add(new Producto("Plátano", new BigDecimal("0.59"), 80));
        productos.add(new Producto("Pera", new BigDecimal("1.49"), 50));
        productos.add(new Producto("Naranja", new BigDecimal("0.79"), 200));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Acción de selección de producto
    public void seleccionarProducto(Producto producto) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Producto Seleccionado",
                        "Has seleccionado el producto: " + producto.getNombre()));

        System.out.println("Producto seleccionado: " + producto.getNombre());
    }

    @PostConstruct
    public void init() {
        System.out.println("ProductoBean se ha inicializado.");
    }
}
