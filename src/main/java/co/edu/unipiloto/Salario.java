/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dylan Lozano
 */
@XmlRootElement
public class Salario {
    private int salario;

    public Salario() {}

    public Salario(int salarioPromedio) {
        this.salario = salarioPromedio;
    }
    
    @XmlElement
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
