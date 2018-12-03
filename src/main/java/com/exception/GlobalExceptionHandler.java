package com.exception;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import com.model.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
		super();
	}

	@ExceptionHandler({ AuthException.class, ContentNotAllowedException.class })
	@Nullable
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof AuthException) {
			HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
			AuthException unfe = (AuthException) ex;

			return handleAuthException(unfe, headers, status, request);
		} else if (ex instanceof ContentNotAllowedException) {
			HttpStatus status = HttpStatus.FORBIDDEN;
			ContentNotAllowedException cnae = (ContentNotAllowedException) ex;
			return handleContentNotAllowedException(cnae, headers, status, request);
		} else {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}
	
	protected ResponseEntity<ApiError> handleAuthException(	AuthException 	ex,
															HttpHeaders 	headers, 
															HttpStatus 		status, 
															WebRequest 		request) {
		List<String> errorMessages = Collections.singletonList(ex.getMessage());
		return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
	}
	
	protected ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException 	ex,
																		HttpHeaders 				headers, 
																		HttpStatus 					status, 
																		WebRequest 					request) {
		List<String> errorMessages = ex.getErrors().stream()
										.map(contentError -> 
												contentError.getObjectName() 	+ 
												" "								+ 
												contentError.getDefaultMessage())
										.collect(Collectors.toList());

		return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
	}

	protected ResponseEntity<ApiError> handleExceptionInternal(	Exception ex, 
																@Nullable ApiError body,
																HttpHeaders headers, 
																HttpStatus status, 
																WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<ApiError>(body, headers, status);
	}

}
