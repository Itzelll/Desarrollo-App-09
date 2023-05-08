/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa09.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author emili
 */
@Entity
@Table(name = "empleado")
public class Empleado {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id")
   private long clave;

    @Column(name="nombre")
    String nombre;
    
    @Column(name="direccion")
    String direccion;
    
    @Column(name="telefono")
    String telefono;
    
    public Empleado(DTOEmpleado emp) {
        this.clave = emp.getClave();
        this.nombre = emp.getNombre();
        this.telefono = emp.getTelefono();
        this.direccion = emp.getDireccion();
    }

    public Empleado() {
    }
    
    
    public long getId() {
    return clave;
  }
    
     public void setId(int clave) {
    this.clave = clave;
  }
     

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
