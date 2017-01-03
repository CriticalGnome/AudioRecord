/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.criticalgnome.audio.beans.Collection;

public class FileOperations {

	/**
	 * Load previously saved collection from file
	 * @param myCollection Empty collection
	 * @return Loaded collection or empty collection in case of error
	 */
	public static Collection loadSession(Collection myCollection) {
		try {
			FileInputStream is = new FileInputStream("Files/Collection.bin");
			ObjectInputStream ois = new ObjectInputStream(is);
			myCollection = (Collection) ois.readObject();
			ois.close();
			System.out.println("\nПредыдущая сессия успешно импротирована.");
		} catch (FileNotFoundException e) {
			System.out.println("\nПредыдущая сессия не найдена. Будем использовать пустую коллекцию.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myCollection;
	}

	/**
	 * Save collection to file
	 * @param myCollection Current collection state
	 */
	public static void saveSession(Collection myCollection) {
		try {
			FileOutputStream os = new FileOutputStream("Files/Collection.bin");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(myCollection);
			oos.close();
			System.out.println("Сессия успешно сохранена.");
		} catch (FileNotFoundException e) {
			System.out.println("Не удалось сохранить сессию. Скорее всего в текущем каталоге отсутствует папка \"Files\".");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
