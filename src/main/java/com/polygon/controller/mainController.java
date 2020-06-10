/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polygon.controller;

/**
 *
 * @author danie
 */
        
import com.polygon.model.Point;
import com.polygon.model.Poly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;

@Path("polygon")
public class mainController {
    
    private final Poly polygon;
    
    public mainController () throws IOException, UnsupportedEncodingException, ParseException {
        this.polygon = new Poly();
    }
    
   @GET
   @Path("/validPoint")
   @Consumes("application/json")
   @Produces("application/json")
   public Response validPoint(Point point) {
       String result = "{\"isValidPoint\":" + polygon.validatePolygon(point.getX(), point.getY()) + "}";
       return Response.ok(result).build();
       
   }
}
