/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Dylan Lozano
 */
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id","nombreCompleto","edad","salario"})
public class Persona {
    
    
    private int id;
    private String nombreCompleto;
    private int edad;
    private int salario;
    
    public Persona(){}

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @XmlElement
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @XmlElement
    public int getSalario() {
        return salario;
    }
    
    public void setSalario(int salarioMinimo) {
        this.salario = (edad * salarioMinimo) / 3;
    }
    
}
