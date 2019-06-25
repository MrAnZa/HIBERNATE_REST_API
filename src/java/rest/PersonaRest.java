/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Persona;
import modelos.PersonaOperaciones;
 
@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
/**
 *
 * @author EliteBook
 */
public class PersonaRest {
    
    @GET
    public Response listar(){
    PersonaOperaciones po = new PersonaOperaciones();
    ArrayList<Persona> datos = po.getPersonas();
    String json = new Gson().toJson(datos);
    return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    public Response guardar(Persona personaRequest){
    PersonaOperaciones po = new PersonaOperaciones();
    po.addPersona(personaRequest);
    return Response.ok("{\"resultado\":\"guardado\"}", MediaType.APPLICATION_JSON).build();
    }
    
    @PUT
    @Path("{perId}")
    public Response actualizar(@PathParam("perId") byte perId,Persona personaRequest){
    PersonaOperaciones po = new PersonaOperaciones();
    Persona personaU =po.findPersona(perId);
    personaU.setPerNom(personaRequest.getPerNom());
    personaU.setPerApe(personaRequest.getPerApe());
    personaU.setPerEdad(personaRequest.getPerEdad());
    po.updatePersona(personaU);
    return Response.ok("{\"resultado\":\"actualizado\"}", MediaType.APPLICATION_JSON).build();
    }
    
    @DELETE
    @Path("{perId}")
    public Response deletePersona( @PathParam("perId") byte perId) {
        PersonaOperaciones po = new PersonaOperaciones();
        po.deletePersona(perId);
        return Response.ok("{\"resultado\":\"eliminado\"}", MediaType.APPLICATION_JSON).build();
        //return Response.noContent().build();
    }
}
