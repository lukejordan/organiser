package org.lukeyj.organiser.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseTask implements Serializable {

	protected String name;
	protected List<BaseTask> children = new ArrayList<BaseTask> ();

	public BaseTask (String name) {
		this.name= name;
	}
	
	public String getName() {
		return name;
	}

	public List<BaseTask> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ": [name=" + name + "]";
	}

}
