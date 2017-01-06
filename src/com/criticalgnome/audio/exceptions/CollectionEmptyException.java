package com.criticalgnome.audio.exceptions;

import java.awt.Toolkit;

public class CollectionEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	public CollectionEmptyException() {
		System.out.println("Коллекция пуста!");
		Toolkit.getDefaultToolkit().beep();
		return;
	}

}
