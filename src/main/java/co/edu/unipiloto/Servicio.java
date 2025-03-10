/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dylan Lozano
 */
@Path("service")
public class Servicio {
    
    private static Map<Integer,Persona> personas = new HashMap<Integer,Persona>();
    
    static{
        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona();
            int id = i++;
            persona.setId(id);
            persona.setNombreCompleto("Persona " + id);
            persona.setEdad(new Random().nextInt(40)+1);
            persona.setSalario(1423500);
            personas.put(id, persona);
        }
    }
    
    @GET
    @Path("/getPersonaPorIDXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersonaPorIDXML(@PathParam("id")int Id){
        return personas.get(Id);
    }
    
    @GET
    @Path("/salarioPromedioEnXML")
    @Produces(MediaType.APPLICATION_XML)
    public Salario salarioPromedioEnXML(){
        int salarioTotal = 0;
        for(Persona p : personas.values()){
            salarioTotal += p.getSalario();
        }
        
        int salarioPromedio = salarioTotal / personas.size(); 
        return new Salario(salarioPromedio);
    }
    
    @GET
    @Path("/salarioTotalEnJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Salario salarioTotalEnJSON(){
        int salarioTotal = 0;
        for(Persona p : personas.values()){
            salarioTotal += p.getSalario();
        }
        return new Salario(salarioTotal);
    }
    
    @GET
    @Path("/getPersonaPorIDJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonaPorIDJSON(@PathParam("id")int Id){
        return personas.get(Id);
    }
    
    @GET
    @Path("/getPersonasEnXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getPersonasEnXML(){
        return new ArrayList<Persona>(personas.values());
    } 
    
    @GET
    @Path("/getPersonasEnJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getPersonasEnJSON(){
        return new ArrayList<Persona>(personas.values());
    } 
    
    @POST
    @Path("/agregarPersonaEnJSON")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persona agregarPersonaEnJSON(Persona persona){
        System.out.println(persona.getId());
        personas.put(persona.getId(), persona);
        return persona;
    }
}