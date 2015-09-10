package org.lukeyj.organiser.persistence;

import org.lukeyj.organiser.entity.Organiser;


public class PersistenceManager {

	String FOLDER_PATH = "c:\\cd\\temp";
	String FILE_NAME = "persist.txt";


	public void persist(Object objectToPersist) {
		FilePersistence filePersistence = new FilePersistence ();
		filePersistence.save(objectToPersist, FILE_NAME, FOLDER_PATH);
	}

	public Organiser recall() {
		String FULL_FILE_PATH = FOLDER_PATH + "\\" + FILE_NAME;
		Organiser organiser = null;
		
		FilePersistence filePersistence = new FilePersistence ();
		organiser = (Organiser) filePersistence.load (FULL_FILE_PATH);
		
		return organiser;
	}
}
