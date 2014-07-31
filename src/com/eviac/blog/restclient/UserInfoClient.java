package com.eviac.blog.restclient;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserInfoClient 
{	
	public static final String BASE_URI = "http://localhost:8080/RESTfulWS";
	public static final String PATH_NAME = "/UserInfoService/name/";
	public static final String PATH_AGE = "/UserInfoService/age/";
	public static final String PATH_CREATE_USER = "/UserInfoService/createUser/";
	public static final String PATH_UPDATE_USER = "/UserInfoService/updateUser/";
	public static final String PATH_DELETE_USER = "/UserInfoService/deleteUser/";
	
	public static void main(String[] args) 
	{
		String name = "Piyush";
		int age = 25;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);
		
		WebResource nameResource = resource.path(PATH_NAME + name);
		System.out.println("Client Response \n"
		+ getClientResponse(nameResource));
		System.out.println("Response \n" + getResponse(nameResource) + "\n\n");
		
		WebResource ageResource = resource.path(PATH_AGE + age);
		System.out.println("Client Response \n"
		+ getClientResponse(ageResource));
		System.out.println("Response \n" + getResponse(ageResource) + "\n\n");
		
		WebResource createResource = resource.path(PATH_CREATE_USER + name);
		System.out.println("Client Response \n"
		+ createClientResponse(createResource));
		System.out.println("Response \n" + createResponse(createResource) + "\n\n");
		
		WebResource updateResource = resource.path(PATH_UPDATE_USER + name);
		System.out.println("Client Response \n"
		+ updateClientResponse(updateResource));
		System.out.println("Response \n" + updateResponse(updateResource)  + "\n\n");
		
		WebResource deleteResource = resource.path(PATH_DELETE_USER + name  + "\n\n");
		System.out.println("Client Response \n"
		+ deleteClientResponse(deleteResource));
		System.out.println("Response \n" + deleteResponse(deleteResource)  + "\n\n");
		
		
	}
	
	/**
	* Returns client response.
	* e.g : 
	* GET http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Pavithra 
	* returned a response status of 200 OK
	* 
	* @param service
	* @return
	*/
	private static String getClientResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class)
				.toString();
	}
	
	
	/**
	* Returns the response as XML
	* e.g : <User><Name>Piyush</Name></User> 
	* 
	* @param service
	* @return
	*/
	private static String getResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}
	
	private static String createClientResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).post(ClientResponse.class)
				.toString();
	}
	
	private static String createResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).post(String.class);
	}
	
	private static String updateClientResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).put(ClientResponse.class)
				.toString();
	}
	
	private static String updateResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).put(String.class);
	}
	
	private static String deleteClientResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).delete(ClientResponse.class)
				.toString();
	}
	
	private static String deleteResponse(WebResource resource) 
	{
		return resource.accept(MediaType.TEXT_XML).delete(String.class);
	}
}