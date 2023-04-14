package com.guptaji.resource;

import com.guptaji.entity.Author;
import com.guptaji.repository.AuthorRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/author")
public class AuthorResource {

    @Inject
    public AuthorRepo authorRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorDetails(){
        return Response.ok(authorRepo.listAll()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertAuthorDetails(Author author){
        authorRepo.persist(author);
        if (authorRepo.isPersistent(author)){
            return Response.ok("Done dana done done").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
