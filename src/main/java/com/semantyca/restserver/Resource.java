package com.semantyca.restserver;

import com.semantyca.elastic.ESHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Resource {
    private static final String API_VERSION = "0.0.1-SNAPSHOT";

    @POST
    @Path("/post")
    public String post() {
        return "{\"msg\": \"Ola! Este e um POST pedido\"}";
    }

    @GET
    @Path("/get")
    public String get() {
        return "{Ola! Este e um GET pedido}";
    }

    @GET
    @Path("/gettoken/{am}/{oauth2}/{authorize}")
    @Produces(MediaType.TEXT_HTML)
    public String getToken(@PathParam("am") String  am,
                           @PathParam("oauth2") String  OAuth2,
                           @PathParam("authorize") String authorize,
                           @QueryParam("realm") String realm,
                           @QueryParam("service") String service,
                           @QueryParam("response_type") String response_type,
                           @QueryParam("client_id") String client_id,
                           @QueryParam("scope") String scope,
                           @QueryParam("redirect_uri") String redirect_uri,
                           @QueryParam("nonce") String nonce,
                           @QueryParam("state") String state
                           ) {
        System.out.println("login");
        String login = "<!DOCTYPE html><html><body>" +
                "<form method=\"post\"  action=\"login\">" +
                "<label for=\"username\">Username</label>" +
                "<input type=\"text\" id=\"username\" placeholder=\"Username\" name=\"username\"/><br/>" +
                "<label for=\"password\">Password</label>" +
                "<input type=\"password\" id=\"password\" placeholder=\"Password\" name=\"password\"/>" +
                "<button type=\"submit\">Log in</button>" +
       "</form></body></html>";
       return login;
    }

    @POST
    @Path("/gettoken/am/oauth2/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username, @FormParam("password") String password ) {
        System.out.println(username + " " + password);
        return Response.ok().header("Content-Type", "application/json").build();
    }

    @GET
    @Path("/populate")
    @Produces(MediaType.TEXT_HTML)
    public String getToken(){
        ESHandler handler = new ESHandler();
        handler.putdata();
        return "ok";
    }


}