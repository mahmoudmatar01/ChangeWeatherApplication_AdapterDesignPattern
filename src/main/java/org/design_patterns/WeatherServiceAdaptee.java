package org.design_patterns;

public class WeatherServiceAdaptee implements WeatherServiceAdapter{

    private final LegacyWeatherService legacyWeatherService;

    public WeatherServiceAdaptee(LegacyWeatherService legacyWeatherService) {
        this.legacyWeatherService = legacyWeatherService;
    }

    @Override
    public TemperatureData getCityWeatherInformationWithLangAndLate(String lang, String late) {
        String weatherData = legacyWeatherService.getCityWeatherInformation(getCity(lang,late),getCountry(lang,late));
        return convertWeatherXmlDataToTemperatureData(weatherData);
    }

    private TemperatureData convertWeatherXmlDataToTemperatureData(String weatherXmlData){
        System.out.println("Converting weather xml data to JSON Temperature Data...........");
        return new TemperatureData(weatherXmlData);
    }

    private String getCity(String lang,String late){
        System.out.println("Getting city information from lang: "+lang+", late: "+late+"...........");
        return "City";
    }

    private String getCountry(String lang,String late){
        System.out.println("Getting country information from lang: "+lang+", late: "+late+"...........");
        return "Country";
    }
}
