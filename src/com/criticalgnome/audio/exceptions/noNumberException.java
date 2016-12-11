package com.criticalgnome.audio.exceptions;

public class noNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	public noNumberException(Throwable e) { 
        initCause(e); 
    } 
}
