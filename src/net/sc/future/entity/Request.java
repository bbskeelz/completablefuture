package net.sc.future.entity;

public class Request {

	public int id;
	public String name;
	public Integer[] data;
	
	public Response response;
	

	public Request(int id, String name, Integer[] data) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.response = new Response(id, data.length);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
