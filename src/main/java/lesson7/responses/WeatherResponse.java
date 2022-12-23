package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("Temperature")
    Temperature temperature;


// Getter Methods

    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return weatherText;
    }

    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }



// Setter Methods



    public void setWeatherText(String WeatherText) {
        this.weatherText = WeatherText;
    }


    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

}

