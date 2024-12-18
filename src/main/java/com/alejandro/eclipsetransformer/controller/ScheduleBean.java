package com.alejandro.eclipsetransformer.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Named("scheduleBean")
@ViewScoped
@ManagedBean(value = "scheduleBean")
public class ScheduleBean implements Serializable {

    private ScheduleModel eventosModel;
    private Evento evento;

    public ScheduleBean() {
        eventosModel = new DefaultScheduleModel(); // Inicializa el modelo de eventos
        evento = new Evento(); // Inicializa el evento actual
    }

    public void agregarEvento() {
        if (Objects.isNull(evento.getTitulo()) || evento.getTitulo().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El título es obligatorio."));
            return;
        }
        if (Objects.isNull(evento.getFechaInicio()) || Objects.isNull(evento.getFechaFin())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las fechas son obligatorias."));
            return;
        }
        if (evento.getFechaFin().isBefore(evento.getFechaInicio())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de fin debe ser posterior a la de inicio."));
            return;
        }

        ScheduleEvent scheduleEvent = DefaultScheduleEvent.builder()
                .title(evento.getTitulo())
                .startDate(evento.getFechaInicio())
                .endDate(evento.getFechaFin())
                .build();

        eventosModel.addEvent(scheduleEvent); //Agregar al calendario

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento agregado", evento.getTitulo()));

        //Limpiar formulario
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ScheduleModel getEventosModel() {
        return eventosModel;
    }

    public void setEventosModel(ScheduleModel eventosModel) {
        this.eventosModel = eventosModel;
    }

    public static class Evento {
        private String titulo;
        private LocalDateTime fechaInicio;
        private LocalDateTime fechaFin;

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public LocalDateTime getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(LocalDateTime fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public LocalDateTime getFechaFin() {
            return fechaFin;
        }

        public void setFechaFin(LocalDateTime fechaFin) {
            this.fechaFin = fechaFin;
        }
    }
}
