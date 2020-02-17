package net.sc.future.entity;

public class Response {

	public int id;
	public Integer[] data;
	public Response(int id, int size) {
		this.id = id;
		this.data = new Integer[size];
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}

	
}
