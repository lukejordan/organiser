package org.lukeyj.organiser.entity;

import java.io.Serializable;
import java.util.Collections;


public class Organiser extends BaseTask {

	public Organiser(String name) {
		super (name);
	}


	public Story createStory(String name) {
		Story newStory = new Story (name);
		children.add(newStory);
		return newStory;
	}


	public void boostPriority(BaseTask secondStory) {
		int index = this.children.indexOf(secondStory);
		int targetLocation = index;
		if (index > 0) {
			targetLocation -= 1;
			Collections.swap(this.children, index, targetLocation);
		}

		
	}

}
