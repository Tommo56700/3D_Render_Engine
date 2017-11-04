package toolbox;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;

public class Maths {
	
	public static Matrix4f createTransformationMatrix(Vector2f translation, Vector2f scale) {
		Matrix4f transformationMatrix = new Matrix4f();
		transformationMatrix.setIdentity();
		Matrix4f.translate(translation, transformationMatrix, transformationMatrix);
		Matrix4f.scale(new Vector3f(scale.x, scale.y, 1f), transformationMatrix, transformationMatrix);
		return transformationMatrix;
	}
	
	public static Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry, float rz, float scale) {
		Matrix4f transformationMatrix = new Matrix4f();
		transformationMatrix.setIdentity();
		Matrix4f.translate(translation, transformationMatrix, transformationMatrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(1,0,0), transformationMatrix, transformationMatrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(0,1,0), transformationMatrix, transformationMatrix);
		Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1), transformationMatrix, transformationMatrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), transformationMatrix, transformationMatrix);
		return transformationMatrix;
	}
	
	public static Matrix4f createViewMatrix(Camera camera){
		Matrix4f viewMatrix = new Matrix4f();
		viewMatrix.setIdentity();
		Matrix4f.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1,0,0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0,1,0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRoll()), new Vector3f(0,0,1), viewMatrix, viewMatrix);
		Vector3f negativeCameraPos = new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z);
		Matrix4f.translate(negativeCameraPos, viewMatrix, viewMatrix);
		return viewMatrix;
	}
	
}