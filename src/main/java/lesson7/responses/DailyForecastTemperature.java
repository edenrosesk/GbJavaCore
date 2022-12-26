package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecastTemperature {
    @JsonProperty("Minimum")
    TemperatureValue minimum;

    @JsonProperty("Maximum")
    TemperatureValue maximum;

    @JsonProperty("Minimum")
    public TemperatureValue getMinimum() {
        return minimum;
    }

    @JsonProperty("Minimum")
    public void setMinimum(TemperatureValue minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("Maximum")
    public TemperatureValue getMaximum() {
        return maximum;
    }

    @JsonProperty("Maximum")
    public void setMaximum(TemperatureValue maximum) {
        this.maximum = maximum;
    }
}
