package org.design_patterns;

public class ThirdPartyWeatherService {

    public String getWeatherData(String city,String country){
        System.out.println("Fetching weather information for country: "+country+" in city: "+city);
        return "These are weather information in XML format";
    }
}
