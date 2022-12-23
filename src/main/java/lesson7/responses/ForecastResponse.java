package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    @JsonProperty("DailyForecasts")
    private DailyForecast[] forecasts;

    @JsonProperty("Headline")
    private Headline headline;

    @JsonProperty("DailyForecasts")
    public DailyForecast[] getForecasts() {
        return forecasts;
    }

    @JsonProperty("DailyForecasts")
    public void setForecasts(DailyForecast[] forecasts) {
        this.forecasts = forecasts;
    }

    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }
}
