# ChangeWeatherApplication_AdapterDesignPattern

This project demonstrates the **Adapter Design Pattern** by creating an adapter that allows for interaction with a legacy weather service. The legacy service returns weather data in XML format, which is then converted to a more usable format (in this case, JSON-like `TemperatureData`). This design pattern enables compatibility between incompatible interfaces without modifying the existing service.

## Project Structure

The project consists of the following components:

1. **ThirdPartyWeatherService (Class)**
   - Represents a third-party weather service that provides weather data in XML format.
   - `getWeatherData(String city, String country)`: Returns weather information in XML format based on the provided city and country.

2. **LegacyWeatherService (Class)**
   - Wraps `ThirdPartyWeatherService`, making it easier to interact with by offering a simpler method: `getCityWeatherInformation(String city, String country)`.
   - Uses dependency injection to access the third-party service and retrieve weather data.

3. **WeatherServiceAdapter (Interface)**
   - Defines the new interface for the adapter.
   - `getCityWeatherInformationWithLangAndLate(String lang, String late)`: Retrieves weather data based on geographical coordinates (latitude and longitude).

4. **WeatherServiceAdaptee (Class)**
   - Implements `WeatherServiceAdapter` and adapts the legacy service to the new interface.
   - Converts XML data returned by `LegacyWeatherService` to a more usable `TemperatureData` format.
   - Uses helper methods to retrieve city and country information based on latitude and longitude.

5. **TemperatureData (Record)**
   - Represents the weather data in JSON-like format after conversion.
   - Holds the `temperatureData` field, encapsulating the weather information as a string.

6. **Main (Driver Class)**
   - Demonstrates the Adapter Design Pattern by retrieving weather data both directly from the legacy service (in XML format) and via the adapter (in JSON-like format).
   - Prints both formats to illustrate the transformation.

## How It Works

1. **Adapter Design Pattern**:
   - The Adapter Pattern is used to bridge between the `LegacyWeatherService` interface, which uses city and country for weather data, and a new interface that accepts latitude and longitude coordinates.
   - The adapter (`WeatherServiceAdaptee`) converts the XML format from `LegacyWeatherService` into a JSON-like `TemperatureData` format.

2. **Data Conversion**:
   - `WeatherServiceAdaptee` retrieves city and country data using latitude and longitude.
   - Once data is fetched from the legacy service, the adapter converts XML to `TemperatureData` format using `convertWeatherXmlDataToTemperatureData`.

## Sample Output

Running the `Main` class produces output similar to:

```plaintext
Fetching weather information for country: Egypt in city: Tanta
These are weather information in XML format
------------------------------------------------------------
Getting city information from lang: 1234, late: 5678...........
Getting country information from lang: 1234, late: 5678...........
Converting weather xml data to JSON Temperature Data...........
These are weather information in XML format
```


## Key Takeaways
- Adapter Design Pattern: Enables compatibility between different interfaces, allowing for flexible, reusable code.
- Data Transformation: The adapter provides an opportunity to transform data formats (XML to JSON), improving usability.
- Maintainability: The adapter isolates changes to `LegacyWeatherService`, making it easier to replace or upgrade third-party services in the future.


## Usage
1. Clone the repository and navigate to the project directory.
2. Compile the project files.
3. Run the Main class to see the Adapter Design Pattern in action, simulating weather data retrieval in different formats.
