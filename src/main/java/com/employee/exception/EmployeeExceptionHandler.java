package com.employee.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String methodArgumentValidException(MethodArgumentNotValidException invalidException, Model model) {
		Map<String, String> invalidmsg = new HashMap<String, String>();
		invalidException.getBindingResult().getFieldErrors().forEach(error -> {
			invalidmsg.put(error.getField(), error.getDefaultMessage());
		});
		model.addAttribute("invalidmsg", invalidmsg);
		return "forward:/registrationpage";

	}

	@ResponseBody
	@ExceptionHandler(NoSuchElementException.class)
	public String noSuchElementExceptionHandler() {
		return "NO DATA FOUND";
	}
}
