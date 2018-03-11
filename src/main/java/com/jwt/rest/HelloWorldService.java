package com.jwt.rest;
 
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.jwt.domain.Customer;

import com.jwt.persistence.CustomerDAO;
import com.sun.jersey.api.NotFoundException;
  
@Path("/hello")
public class HelloWorldService {
  
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name) {
  
        String output = "Welcome   : " + name;
  
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/get")
    public Response getCustomer(@QueryParam("id") String id) throws Exception {
    	if(id == null){
    		throw new WebApplicationException(Response.Status.PRECONDITION_FAILED);
    	}
    	try
        {
            Integer.parseInt(id);
        }
        catch(NumberFormatException e)
        {
            throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
        }
//    	CustomerDAO dao = new CustomerDAO();
//		Customer customer = dao.getCustomer(id);
//		String output = "Dit is:" + customer.getName() +" "+customer.getLastname() + "," + customer.getStraat()+ ","+ customer.getNummer()+"." ;
        return Response.status(200).entity("gevonden").build();
    }
    
    @POST
    @Path("/add")
    public Response addCustomer(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("adress") String adress, @FormParam("streetnumber") int streetnumber) throws Exception {
    	
			CustomerDAO dao = new CustomerDAO();
			dao.AddCustomer(firstname, lastname, adress, streetnumber);
			String output = "output";
	        return Response.status(200).entity(output).build();
			
    }
    
    @DELETE
    @Path("/delete")
    public Response deleteCustomer(@FormParam("id") int id) throws Exception {
    	CustomerDAO dao = new CustomerDAO();
    	dao.DeleteCustomer(id);
    	String output = "output";
        return Response.status(200).entity(output).build();	}
    
    
    @PUT
    @Path("/update")
    public Response updateCustomer(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("adress") String adress, @FormParam("streetnumber") int streetnumber, @FormParam("id") int id) throws Exception {
    	
    	CustomerDAO dao = new CustomerDAO();
    	dao.UpdateCustomer(firstname, lastname, adress, streetnumber, id);
    	String output = "output";
        return Response.status(200).entity(output).build();	}   
}

