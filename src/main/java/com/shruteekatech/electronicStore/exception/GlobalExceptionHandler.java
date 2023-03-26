package com.shruteekatech.electronicStore.exception;

import com.shruteekatech.electronicStore.constant.AppConstant;
import com.shruteekatech.electronicStore.dtos.ApiResponse;
import com.shruteekatech.electronicStore.dtos.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernotFoundException.class)
    public ResponseEntity<ApiResponse> usernotfoundExceptionhandle(UsernotFoundException e)
    {
//        String message = e.getMessage();
//        ApiResponse apiResponse = new ApiResponse(message, false);
        ApiResponse apiResponse = ApiResponse.builder().message(e.getMessage()).status(false).build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ApiResponse> emailnotfoundExceptionhandle(EmailNotFoundException e)
    {
        ApiResponse apiResponse =ApiResponse.builder().message(e.getMessage()).status(false).build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodargsNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError)error).getField();
            String defaultMessage = error.getDefaultMessage();
            resp.put(field, defaultMessage);
        });

        return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleMethodargsNotValidException(DataIntegrityViolationException ex)
    {
        ApiResponse apiResponse = new ApiResponse(AppConstant.EMAIL_MSG, false);
        return  new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadApiException.class)
    public ResponseEntity<ApiResponse> handleBadApiException(BadApiException ex)
    {
        ApiResponse apiResponse =ApiResponse.builder().message(ex.getMessage()).status(false).build();

        return  new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
