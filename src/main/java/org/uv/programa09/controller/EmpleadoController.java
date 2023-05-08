package org.uv.programa09.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Itzel
 */
@RestController
@RequestMapping("/")
public class EmpleadoController {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    @GetMapping("/msg")
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/empleados/{id}")
    public DTOEmpleado obtenerEmpleado(@PathVariable("id") long id){
        DTOEmpleado emp=null;
        if (id == 10){
        emp.setClave(10);
        emp.setNombre("Sag");
        emp.setDireccion("Av 1");
        emp.setTelefono("1234");
        }
        return emp;
    }
    
    @GetMapping("/empleados")
    public List<DTOEmpleado> obtenerTodosLosEmpleado(){
        List<DTOEmpleado> lstEmpleados=new ArrayList<>();
        DTOEmpleado emp1= new  DTOEmpleado();
        emp1.setClave(10);
        emp1.setNombre("Sag");
        emp1.setDireccion("Av 1");
        emp1.setTelefono("1234");
        
        lstEmpleados.add(emp1);
        DTOEmpleado emp2= new DTOEmpleado();
        emp2.setClave(12);
        emp2.setNombre("Sag2");
        emp2.setDireccion("Av 1");
        emp2.setTelefono("1234");
        
        return lstEmpleados;
    }
    //guardarregistro
    @PostMapping("/empleados")
    public DTOEmpleado createEmpleado(@RequestBody DTOEmpleado empleadoDTO){
        Empleado empleadopojo= new Empleado();
        empleadopojo.setNombre(empleadoDTO.getNombre());
        empleadopojo.setDireccion(empleadoDTO.getDireccion());
        empleadopojo.setTelefono(empleadoDTO.getTelefono());
        
        Empleado empleadopojoNew=repositoryEmpleado.save(empleadopojo);
        
        DTOEmpleado empleadoDTONew=new DTOEmpleado();
        empleadoDTONew.setClave(empleadopojoNew.getId());
        empleadoDTONew.setNombre(empleadopojoNew.getNombre());
        empleadoDTONew.setDireccion(empleadopojoNew.getDireccion());
        empleadoDTONew.setTelefono(empleadopojoNew.getTelefono());
        return empleadoDTONew;
  }
    //update
    @PutMapping("/empleados/{id}")
  public DTOEmpleado modificarEmpleado(@PathVariable("id")Long id,
          @RequestBody DTOEmpleado empleado){
      
      return empleado;
      
  }
    //delete
    @DeleteMapping("/empleados")
    public void borrarEmpleado(@PathVariable("id") Long id){
        return ;
    }
}
