package com.lelyak.edu.exception;


import com.lelyak.edu.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://plus.google.com/u/0/109535268464217373186/posts"); // sent link to my Google+ page
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
