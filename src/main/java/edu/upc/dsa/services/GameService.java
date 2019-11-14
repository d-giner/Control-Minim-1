package edu.upc.dsa.services;


import edu.upc.dsa.*;
import edu.upc.dsa.Objecte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;


@Api(value = "/usuaris", description = "Endpoint to Usuari Service")
@Path("/usuaris")
public class GameService {

    private GameManager tm;

    public GameService() {
        this.tm = GameManagerImpl.getInstance();

        if (tm.consultarNombreUsuaris() == 0) {
            this.tm.afegirUsuari("Condis", "Mercadona", "");
            this.tm.afegirUsuari("Pepe", "Fon", "");
            this.tm.afegirUsuari("Logi", "Tech", "");
        }
    }

    @GET
    @ApiOperation(value = "Obtenir usuaris", notes = "_")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<Usuari> users = this.tm.obtenirLlistaUsuaris();

        GenericEntity<List<Usuari>> entity = new GenericEntity<List<Usuari>>(users) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get a user", notes = "_")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class),
            @ApiResponse(code = 404, message = "Usuari no trobat")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuari(@PathParam("id") String id) {
        Usuari t = this.tm.getUsuari(id);
        if (t == null) return Response.status(404).build();
        else return Response.status(201).entity(t).build();
    }

    /** Funcions fetes però que per algún motiu, peta el main */

//    @PUT
//    @ApiOperation(value = "Modificar un usuari", notes = "_")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful"),
//            @ApiResponse(code = 404, message = "Usuari no trobat")
//    })
//    @Path("/")
//    public Response updateUser(String id, String name, String surname) {
//
//        Usuari mu = this.tm.modificarUsuari(id, name, surname);
//
//        if (mu == null) return Response.status(404).build();
//        else return Response.status(201).build();
//    }

//    @POST
//    @ApiOperation(value = "Afegir nou usuari.", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response=Usuari.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addUser(String id, String name, String surname) {
//        if (tm.getUsuari(id)==null)  return Response.status(500).entity(tm.getUsuari(id)).build();
//        this.tm.afegirUsuari(id, name,  surname);
//        return Response.status(201).entity(tm.getUsuari(id)).build();
//    }
}