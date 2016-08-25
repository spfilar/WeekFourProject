package com.zooanimals;

public class Animals {

	private int animalID = 0;
	private String animalName = null;
	private String animalType = null;
	private int animalAge = 0;
	private String animalHabitat = null;
	private String animalFood = null;
	
	public Animals() {
		super();
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public int getAnimalAge() {
		return animalAge;
	}

	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}

	public String getAnimalHabitat() {
		return animalHabitat;
	}

	public void setAnimalHabitat(String animalHabitat) {
		this.animalHabitat = animalHabitat;
	}

	public String getAnimalFood() {
		return animalFood;
	}

	public void setAnimalFood(String animalFood) {
		this.animalFood = animalFood;
	}

	@Override
	public String toString() {
		return "Animals [animalID=" + animalID + ", animalName=" + animalName + ", animalType=" + animalType
				+ ", animalAge=" + animalAge + ", animalHabitat=" + animalHabitat + ", animalFood=" + animalFood + "]";
	}
	
}
