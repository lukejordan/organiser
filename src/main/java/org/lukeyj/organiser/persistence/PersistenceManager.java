package org.lukeyj.organiser.persistence;

import org.lukeyj.organiser.entity.Organiser;


public class PersistenceManager {

	final String FILE_NAME = "persist.txt";
	
	final String WINDOWS_FOLDER_PATH = "c:\\cd\\temp";
	
	final String MAC_FOLDER_PATH = "~/Organiser/saves";
	final String MAC_FILE_PATH = MAC_FOLDER_PATH + "/" + FILE_NAME;
	
	final String WINDOWS_FULL_FILE_PATH = WINDOWS_FOLDER_PATH + "\\" + FILE_NAME;
	
	private String filePath;
	
	public PersistenceManager () {
		filePath = MAC_FILE_PATH;
	}
	
	public void persist(Object objectToPersist) {
		FilePersistence filePersistence = new FilePersistence ();
		filePersistence.save(objectToPersist, FILE_NAME, MAC_FOLDER_PATH);
	}

	public Organiser recall() {

		Organiser organiser = null;
		
		FilePersistence filePersistence = new FilePersistence ();
		organiser = (Organiser) filePersistence.load (filePath);
		
		return organiser;
	}
}
