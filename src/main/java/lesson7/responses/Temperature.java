package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @JsonProperty("Metric")
    Metric metric;


    // Getter Methods

    @JsonProperty("Metric")
    public Metric getMetric() {
        return metric;
    }



    // Setter Methods
    @JsonProperty("Metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

}
