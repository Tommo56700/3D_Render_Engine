package entities;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;

public class Entity {
	
	//Initialising the entity's attributes
	private TexturedModel model;
	private Vector3f position = new Vector3f(0, 0, 0);
	private float rotX, rotY, rotZ, scale;
	
	//Constructor for the class, sets all of the initial attributes
	public Entity(TexturedModel model, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	//Method to rotate the entity through the use of the mouse
	public void increaseRotation() {
		float rotChangeX = Mouse.getDX() * 0.2f;
		this.rotX += rotChangeX;
		if (this.rotX >= 360) {
			this.rotX -= 360;
		}
		if (this.rotX <= -360) {
			this.rotX += 360;
		}
		float rotChangeY = Mouse.getDY() * 0.2f;
		this.rotY -= rotChangeY;
		if (this.rotY > 80) {
			this.rotY = 80;
		}
		if (this.rotY < -70) {
			this.rotY = -70;
		}
	}
	
	
	//Getters and setters for the class' variables
	public TexturedModel getModel() {
		return model;
	}
	
	public void setModel(TexturedModel model) {
		this.model = model;
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public float getRotX() {
		return rotX;
	}
	
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}
	
	public float getRotY() {
		return rotY;
	}
	
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}
	
	public float getRotZ() {
		return rotZ;
	}
	
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
	
}
