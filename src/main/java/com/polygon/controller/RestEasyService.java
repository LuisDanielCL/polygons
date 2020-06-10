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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.json.simple.parser.ParseException;

@ApplicationPath("/main")
public class RestEasyService extends Application {

    private final Set < Object > singletons = new HashSet <> ();

    public RestEasyService() throws IOException, UnsupportedEncodingException, ParseException {
        singletons.add(new mainController());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}