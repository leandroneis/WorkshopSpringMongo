package com.leandroneis.workshopmongo.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//Anotacao para indicar que a classe irá tratar possíveis erros nas requisições.
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) //Necessario incluir essa anotacao com a classe responsavel do erro.
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não Encontrado",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
