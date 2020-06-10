/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polygon.model;

import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

        
import java.util.Arrays;
import org.json.simple.parser.ParseException;
/**
 *
 * @author danie
 */
public class Poly {
    
    ArrayList<String> places = new ArrayList<String>(
    Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
    
    private Polygon polygon;
    
    public Poly() throws UnsupportedEncodingException, IOException, ParseException {

        InputStream stream = Poly.class.getClassLoader().getResourceAsStream("defaultPolygon.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject polygonJson = (JSONObject)jsonParser.parse(
              new InputStreamReader(stream, "UTF-8"));
        
        this.polygon = createPolygon(polygonJson);    
    }
    
    public final Polygon createPolygon(JSONObject polygonJson) {
        final GeometryFactory gf = new GeometryFactory();
        final ArrayList<Coordinate> points = new ArrayList<>();
        
        JSONArray polygonArray = (JSONArray) polygonJson.get("polygon");
        
        for (int i = 0; i < polygonArray.size(); i++){
            JSONArray point = (JSONArray) polygonArray.get(i);
            points.add(new Coordinate((Double) point.get(0), (Double) point.get(1)));
        }
        final Polygon polygon = gf.createPolygon(new LinearRing(new CoordinateArraySequence(points
            .toArray(new Coordinate[points.size()])), gf), null);
        
        return polygon;
    }
    
    public Boolean validatePolygon(double x, double y) {
        final GeometryFactory gf = new GeometryFactory();
        final Coordinate coord = new Coordinate(x, y);
        final Point point = gf.createPoint(coord);
        return point.within(polygon);
    
    } 
    

    
}
