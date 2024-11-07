package org.design_patterns;

public class LegacyWeatherService {

    private final ThirdPartyWeatherService thirdPartyWeatherService;

    // constructor to inject dependency
    public LegacyWeatherService(ThirdPartyWeatherService thirdPartyWeatherService) {
        this.thirdPartyWeatherService = thirdPartyWeatherService;
    }

    public String getCityWeatherInformation(String city,String country){
        return thirdPartyWeatherService.getWeatherData(city,country);
    }

}
