package lesson8;

import java.sql.SQLException;
import java.util.List;


public interface WeatherRepository {

    boolean saveWeather(Weather weather) throws SQLException;

    List<Weather> getAllSavedData() throws SQLException;
}