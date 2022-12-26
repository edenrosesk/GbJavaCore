package lesson7.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metric {

    @JsonProperty("Value")
    private float value;


    // Getter Methods
    @JsonProperty("Value")
    public float getValue() {
        return value;
    }



    // Setter Methods
    @JsonProperty("Value")
    public void setValue(float value) {
        this.value = value;
    }

}
