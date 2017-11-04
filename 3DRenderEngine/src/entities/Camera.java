package entities;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	//Initialising the camera's attributes
	private Vector3f position;
	private float pitch = 0;
	private float yaw = 0;
	private float roll = 0;
	
	//Constructor for the class, takes in a Vector position for where to spawn
	public Camera(Vector3f position){
		this.position = position;
	}
	
	//Method to increase/decrease zoom of camera through the use of the scroll wheel
	public void calculateZoom() {
		float zoomLevel = Mouse.getDWheel() * 0.01f;
		this.position.z -= zoomLevel;
		if (this.position.z < 15) {
			position.z = 15;
		}
		if (this.position.z > 60) {
			this.position.z = 60;
		}
	}

	//Getters for class' variables
	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
}