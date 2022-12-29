package lesson7;

import lesson7.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, SQLException;
    void getWeatherFromDb() throws SQLException;

}
