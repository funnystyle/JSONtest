package com.funnystyle.jsontest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class NotFoundException extends RuntimeException {
    // ...
	NotFoundException(String msg) {
		
	}
}