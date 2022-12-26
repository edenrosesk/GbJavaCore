package lesson7;

import lesson7.enums.Functionality;
import lesson7.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_FROM_DB);
    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_WEATHER_FROM_DB:
                getWeatherFromDb();
                break;
        }
    }

    private void getCurrentWeather() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.NOW);
    }

    private void getWeatherIn5Days() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }

    private void getWeatherFromDb() throws SQLException {
        weatherProvider.getWeatherFromDb();
    }
}