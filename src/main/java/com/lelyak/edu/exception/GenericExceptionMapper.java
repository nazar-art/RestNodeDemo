package com.lelyak.edu.exception;


import com.lelyak.edu.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "https://plus.google.com/u/0/109535268464217373186/posts"); // sent link to my Google+ page
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}
