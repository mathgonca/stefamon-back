package com.stefanini.resources;

import com.stefanini.dto.stefamon.StefamonResponse;
import com.stefanini.service.StefamonService;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stefamon")
public class StefamonResource {
    @Inject
    StefamonService service;

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "200",
            description = "Lista de Stefamon retornada com sucesso.",
            content = @Content(
                    schema = @Schema(
                            type = SchemaType.ARRAY,
                            implementation = StefamonResponse.class
                    ))
    )
    public Response listarTodos() {
        List<StefamonResponse> responseList = service.listarTodos();
        return Response
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(responseList)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Stefamon retornado com sucesso.",
                    content = @Content(schema = @Schema(implementation = StefamonResponse.class))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Não foi encontrado um Stefamon com o Id procurado.",
                    content = @Content(schema = @Schema(
                            type = SchemaType.STRING,
                            defaultValue = "Não foi encontrado um Stefamon com o Id procurado."
                    ))
            )
    })
    public Response pegarPorId(@PathParam("id") Long id) {
        StefamonResponse response = service.pegarPorId(id);
        return Response
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(response)
                .build();
    }
}
