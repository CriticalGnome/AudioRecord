package com.criticalgnome.audio.exceptions;

import java.awt.Toolkit;

public class CollectionEmptyEx extends Exception {

	private static final long serialVersionUID = 1L;
	public CollectionEmptyEx() {
		System.out.println("Коллекция пуста!");
		Toolkit.getDefaultToolkit().beep();
		return;
	}

}
