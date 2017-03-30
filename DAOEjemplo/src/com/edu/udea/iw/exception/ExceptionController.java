package com.edu.udea.iw.exception;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class ExceptionController extends Exception {
	//clase personalizada para el manejo de las excepciones 
	public ExceptionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionController(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionController(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionController(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionController(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
