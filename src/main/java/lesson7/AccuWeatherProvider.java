package lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.enums.Periods;
import lesson7.responses.ForecastResponse;
import lesson7.responses.WeatherResponse;
import lesson8.Weather;
import lesson8.WeatherRepository;
import lesson8.WeatherRepositorySQLiteImpl;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    WeatherRepository repository = new WeatherRepositorySQLiteImpl();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            var weatherResponse = new ObjectMapper().readValue(response.body().string(), WeatherResponse[].class);
            var weather = weatherResponse[0];

            Weather weatherData = new Weather(ApplicationGlobalState.getInstance().getSelectedCity(),
                    java.time.LocalDateTime.now().toString(),
                    weather.getWeatherText(),
                    (double)weather.getTemperature().getMetric().getValue());
            repository.saveWeather(weatherData);

            System.out.println("В городе " + weatherData.getCity() + " " + weatherData.getText() + ", температура "
                    + weatherData.getTemperature() + " градусов по Цельсию");

        } else if(periods.equals(Periods.FIVE_DAYS)){
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            var forecastResponse = new ObjectMapper().readValue(response.body().string(), ForecastResponse.class);
            System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity() + " будет " + forecastResponse.getHeadline().getText() + ", температура ожидается следующая: ");
            for (var dailyForecast : forecastResponse.getForecasts()) {
                System.out.println(dailyForecast.getDate() + " - от " + dailyForecast.getTemperature().getMinimum().getValue()
                        + " до " + dailyForecast.getTemperature().getMaximum().getValue()
                        + " градусов по Цельсию");
            }
        }
    }

    @Override
    public void getWeatherFromDb() throws SQLException {
        var weathers = repository.getAllSavedData();
        for (var weather : weathers) {
            System.out.println("В городе " + weather.getCity() + " " + weather.getLocalDate() + " " + weather.getText() + ", температура "
                    + weather.getTemperature() + " градусов по Цельсию");
        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }


}
