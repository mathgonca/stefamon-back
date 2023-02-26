package com.stefanini.resources;

import com.stefanini.dto.jogador.JogadorRequest;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @Inject
    JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(jogadorService.pegarPorId(id)).build();
    }

    @GET
    @Path("/todos")
    public Response listarTodos() {
        return Response.status(Response.Status.OK).entity(jogadorService.listarTodos()).build();
    }

    @POST
    public Response salvar(@Valid JogadorRequest jogador) {
        jogadorService.salvar(jogador);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("{id}")
    public Response alterar(@PathParam("id") Long id, @Valid JogadorRequest jogador) {
        jogadorService.alterar(id, jogador);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
