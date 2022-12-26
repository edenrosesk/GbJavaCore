package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Temperature")
    DailyForecastTemperature temperature;

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Temperature")
    public DailyForecastTemperature getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(DailyForecastTemperature temperature) {
        this.temperature = temperature;
    }
}
