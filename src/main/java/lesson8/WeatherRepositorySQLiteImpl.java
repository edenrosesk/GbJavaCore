package lesson8;

import lesson7.ApplicationGlobalState;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherRepositorySQLiteImpl implements WeatherRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL\n" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    String selectWeatherQuery = "SELECT city, date_time, weather_text, temperature FROM weather";

    public WeatherRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
        createTableIfNotExists();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeather(Weather weather) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getText());
            saveWeather.setDouble(4, weather.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<Weather> getAllSavedData() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement selectWeather = connection.prepareStatement(selectWeatherQuery)) {

            List<Weather> result = new ArrayList<>();
            ResultSet resultSet = selectWeather.executeQuery();
            while (resultSet.next()) {
                result.add(new Weather(
                        resultSet.getString("city"),
                        resultSet.getString("date_time"),
                        resultSet.getString("weather_text"),
                        resultSet.getDouble("temperature")
                        ));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on get weather objects");
    }
}
