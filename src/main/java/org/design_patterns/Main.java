package org.design_patterns;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ThirdPartyWeatherService thirdPartyWeatherService = new ThirdPartyWeatherService();
        LegacyWeatherService legacyWeatherService = new LegacyWeatherService(thirdPartyWeatherService);
        WeatherServiceAdapter weatherServiceAdapter = new WeatherServiceAdaptee(legacyWeatherService);
        String temperatureXmlData = legacyWeatherService.getCityWeatherInformation("Tanta","Egypt");
        System.out.println(temperatureXmlData);
        System.out.println("------------------------------------------------------------");
        TemperatureData temperatureData = weatherServiceAdapter.getCityWeatherInformationWithLangAndLate("1234","5678");
        System.out.println(temperatureData.temperatureData());
    }
}