#Polygon Validation

This project was create using netbeans in the version 11, using the JDK 8.

#####Technologies
* Resteasy for handle the HTTP request
* simple.json to handle the polygon creation
* jts from vivid solutions for the creation of the polygon

#####Running
This web application was tested with wildfly in the version 19.1.0, and was deployed using the manager console.

To deploy the application the steps are the following:

* Start wildfly
* Go to port 9990 and insert valid admin credentials
* Go to deploy and put the builded .war there
* you can make a get to the following url to test it ``http://localhost:8080/polygon-1.0-SNAPSHOT/main/polygon/validPoint``
* The get to the URL needs a Json body, so make sure to check the valid and invalid case to see some examples.

Another way to run it is to put the .war in wilfly/standalone and run the standalone.bat in the case of windows it will be running in the same url

#####Valid Case
This is a valid JSON using the default polygon, this should return TRUE.
```
{
    "x": 9.990,
    "y": -84.1
}
```

#####Invalid Case
This is an invalid JSON using the default polygon, this should return FALSE.
```
{
    "x": 9.200,
    "y": -84.322
}
```