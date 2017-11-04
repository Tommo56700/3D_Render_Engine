package entities;

import org.lwjgl.util.vector.Vector3f;

public class Light {
	
	//Initialising the light's attributes
	private Vector3f color, position;
	private Vector3f attenuation = new Vector3f(1, 0, 0);

	//Constructor for the class, sets all of the initial values (for a global light)
	public Light(Vector3f color, Vector3f position) {
		this.color = color;
		this.position = position;
	}

	//Constructor for the class, sets all of the initial values (for a light with an attenuation factor)
	public Light(Vector3f color, Vector3f position, Vector3f attenuation) {
		this.color = color;
		this.position = position;
		this.attenuation = attenuation;
	}
	
	
	//Getters and setters for the class' variables
	public Vector3f getAttenuation() {
		return attenuation;
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

}
