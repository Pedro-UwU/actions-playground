package ar.edu.itba.paw.webapp.mapper;

import ar.edu.itba.paw.exceptions.UnableToDeleteLocationException;
import ar.edu.itba.paw.webapp.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Component
@Provider
@Singleton
public class UnableToDeleteLocationExceptionMapper implements ExceptionMapper<UnableToDeleteLocationException> {

    private final MessageSource messageSource;
    @Autowired
    public UnableToDeleteLocationExceptionMapper(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @Override
    public Response toResponse(UnableToDeleteLocationException e) {
        return Response.status(Response.Status.GONE).type(MediaType.APPLICATION_JSON).entity(ErrorDTO.fromError(messageSource.getMessage("exception.unableToDeleteLC", null, LocaleContextHolder.getLocale()),null)).build();
    }
}