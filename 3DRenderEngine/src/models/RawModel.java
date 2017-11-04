package models;

public class RawModel {
	
	private int vaoID, vertexCount;
	
	//Constructor for a raw model, takes in a VAO ID and the vertex count of a model.
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}

	//method to return a raw model's VAO ID
	public int getVaoID() {
		return vaoID;
	}

	//method to return a raw model's vertex count
	public int getVertexCount() {
		return vertexCount;
	}

}
