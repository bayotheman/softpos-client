package com.tm30.softposclient.controller;



import com.tm30.softposclient.model.payload.Response;
import com.tm30.softposclient.model.payload.ResponseImpl;
import jakarta.validation.ValidationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value
			= {Exception.class})
	protected ResponseEntity<Object> handleConflict(
			Exception ex) {

		Response<String> response = ResponseImpl.create();
		response.setSuccessful(false);
		response.setMessage(ex.getLocalizedMessage());
		if(ex instanceof MethodArgumentNotValidException detail ) {
			ObjectError error = detail.getBindingResult().getAllErrors().get(0);
			response.setMessage(error.getDefaultMessage());
		}
		else if(ex instanceof WebClientResponseException){
			response.setMessage(ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
		}else if(ex instanceof ValidationException | ex instanceof WebClientRequestException){
			response.setMessage(ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			response.setMessage(ex.getLocalizedMessage());
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}


	@Override
	protected ResponseEntity<Object> handleExceptionInternal(@NotNull Exception ex, Object response,
	                                                         @NotNull HttpHeaders headers,
	                                                         @NotNull HttpStatusCode statusCode,
	                                                         @NotNull WebRequest request) {
		return handleConflict(ex);
	}


}
