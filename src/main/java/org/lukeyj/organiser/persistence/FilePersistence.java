package org.lukeyj.organiser.persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FilePersistence {

	
	void save(Object oersistableObject, String fileName, String folderPath) {

		//this.organiser = organiser;
		String FULL_FILE_PATH = folderPath + "/" + fileName;
		
		File file = new File(FULL_FILE_PATH);
		File folder = new File(folderPath);

		try {
			if (!folder.exists()) {
				folder.mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}

			OutputStream file2 = new FileOutputStream(file);
			OutputStream buffer = new BufferedOutputStream(file2);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(oersistableObject);
			output.flush();
			output.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

		}
	}
	
	public Object load (String filePath) {
		Object objectRead = null;
		ObjectInput input = null;
		try {
			File file = new File(filePath);
			if (file.exists()) {
				InputStream stream = new FileInputStream(file);
				InputStream buffer = new BufferedInputStream(stream);
				input = new ObjectInputStream(buffer);
				// deserialize the List
				objectRead = input.readObject();
				// display its data
				input.close();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return objectRead;
	}
}
