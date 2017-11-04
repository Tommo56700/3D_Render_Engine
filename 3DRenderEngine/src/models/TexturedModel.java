package models;

import textures.ModelTexture;

public class TexturedModel {
	
	//Initialises the textured model's values
	private RawModel rawModel;
	private ModelTexture texture;
	
	//Constructor for the class, takes in the rawmodel data and the modeltexture data
	public TexturedModel(RawModel model, ModelTexture texture) {
		this.rawModel = model;
		this.texture = texture;
	}

	//Getter's for the class' variables
	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return texture;
	}
	
}