package com.lukeyj.organiser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lukeyj.organiser.entity.BaseTask;
import org.lukeyj.organiser.entity.Organiser;
import org.lukeyj.organiser.entity.Story;
import org.lukeyj.organiser.persistence.PersistenceManager;
import org.lukeyj.organiser.view.OrganiserView;

public class OrganiserUserTest {

	// Boost story priority
	
	Organiser organiser;
	
	@Before
	public void setup () {

		
		organiser = new Organiser ("organiser 1");
		organiser.createStory("Story 1");
		Story currentStory = (Story) organiser.getChildren().get(0);
		currentStory.createTask("S1 - Task1");
		currentStory.createTask("S1 - Task2");
		
		organiser.createStory("Story 2");
		currentStory = (Story) organiser.getChildren().get(1);
		currentStory.createTask("S2 - Task1");
		currentStory.createTask("S2 - Task2");
		
		organiser.createStory("Story 3");
		currentStory = (Story) organiser.getChildren().get(2);
		currentStory.createTask("S3 - Task1");
		currentStory.createTask("S3 - Task2");
		
	}
	
	
	@Test
	public void testPromoteSecondStory () {
		BaseTask firstStory = organiser.getChildren().get(0);
		BaseTask secondStory = organiser.getChildren().get(1);
		assertEquals(firstStory.getName(), "Story 1");
		assertEquals(secondStory.getName(), "Story 2");
		organiser.boostPriority (secondStory);
		firstStory = organiser.getChildren().get(0);
		secondStory = organiser.getChildren().get(1);
		assertEquals(firstStory.getName(), "Story 2");
		assertEquals(secondStory.getName(), "Story 1");
		
	}

	@Test
	public void testDoublePromoteStory () {
		BaseTask firstStory = organiser.getChildren().get(0);
		BaseTask secondStory = organiser.getChildren().get(1);
		BaseTask thirdStory = organiser.getChildren().get(2);
		assertEquals(firstStory.getName(), "Story 1");
		assertEquals(secondStory.getName(), "Story 2");
		assertEquals(thirdStory.getName(), "Story 3");
		
		organiser.boostPriority (thirdStory);
		firstStory = organiser.getChildren().get(0);
		secondStory = organiser.getChildren().get(1);
		thirdStory = organiser.getChildren().get(2);
		
		assertEquals(firstStory.getName(), "Story 1");
		assertEquals(secondStory.getName(), "Story 3");
		assertEquals(thirdStory.getName(), "Story 2");
		
		organiser.boostPriority (secondStory);
		firstStory = organiser.getChildren().get(0);
		secondStory = organiser.getChildren().get(1);
		thirdStory = organiser.getChildren().get(2);
		
		assertEquals(firstStory.getName(), "Story 3");
		assertEquals(secondStory.getName(), "Story 1");
		assertEquals(thirdStory.getName(), "Story 2");
		
		
	}
	
	@Test
	public void testPersistenceAndRecall () {
		Organiser organiser = this.organiser;
		PersistenceManager persistManager = new PersistenceManager ();
		persistManager.persist(organiser);
		assertTrue(organiser != null);
		organiser = null;
		assertEquals(organiser, null);
		organiser = persistManager.recall();
		assertTrue(organiser != null);
		assertEquals(3, organiser.getChildren().size());
		assertEquals(this.organiser.getChildren().get(2).getName(), organiser.getChildren().get(2).getName());
		
	}
	
	@Test
	public void testOrganiser () {
		System.out.println("Displaying organiser: \n");
		OrganiserView.displayBoard (organiser);
	}
	
}
