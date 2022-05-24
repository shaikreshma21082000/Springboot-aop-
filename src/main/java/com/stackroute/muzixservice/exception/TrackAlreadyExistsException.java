package com.stackroute.muzixservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT ,reason = "Track already Exsists")
public class TrackAlreadyExistsException extends Exception {
}
