package engineRunner;

import java.util.ArrayList;
import java.util.List;

import models.RawModel;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import guis.GuiRenderer;
import guis.GuiTexture;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import textures.ModelTexture;

public class RunLoop {

	public static void main(String[] args) {

		//SETUP
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		MasterRenderer renderer = new MasterRenderer(loader);
		
		//LOAD TEXTURED MODELS
		ModelData shapeData = null;
		TexturedModel texturedShapeModel = null;
		
		shapeData = OBJFileLoader.loadOBJ("dragon");
		RawModel shapeModel = loader.loadToVAO(shapeData.getVertices(), shapeData.getTextureCoords(), shapeData.getNormals(),
				shapeData.getIndices());
		
		texturedShapeModel = new TexturedModel(shapeModel, new ModelTexture(loader.loadTexture("spotty")));
		ModelTexture texture = texturedShapeModel.getTexture();
		texture.setReflectivity(0.8f);
		texture.setShineDamper(100);		

		//ADDS AN ENTITY
		Entity entity = new Entity(texturedShapeModel, 0, 0, 0, 2);
		
		//ADD CAMERA
		Camera camera = new Camera(new Vector3f(0, 0, 35));
		
		//ADD LIGHTS
		List<Light> lights = new ArrayList<Light>();
		lights.add(new Light(new Vector3f(1, 1, 1), new Vector3f(500, 500, 1000)));
		
		/*ADD GUI
		List<GuiTexture> guis = new ArrayList<GuiTexture>();
		GuiTexture gui = new GuiTexture(loader.loadTexture("red"), new Vector2f(0.8f, 0), new Vector2f(0.2f, 1));
		guis.add(gui);*/
		
		//GuiRenderer guiRenderer = new GuiRenderer(loader);
				
		//WHILE PROGRAM IS RUNNING
		while(!Display.isCloseRequested()) {
			camera.calculateZoom();
			if(Mouse.isButtonDown(0)) {
				entity.increaseRotation();
			}
			renderer.renderScene(entity, lights, camera);
			//guiRenderer.render(guis);
			DisplayManager.updateDisplay();
		}
		
		//WHEN PROGRAM IS CLOSED
		lights.clear();
		//guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		
	}

}