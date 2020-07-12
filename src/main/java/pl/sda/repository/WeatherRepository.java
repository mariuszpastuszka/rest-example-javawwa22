package pl.sda.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sda.domain.WeatherForecast;

import java.util.Map;

@Repository
@Slf4j
public class WeatherRepository {

    private static final String LONDEK_CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";

    private static final String CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q={city}&appid={key}";

    private static final String DEFAULT_KEY = "439d4b804bc8187953eb36d2a8c26a02";

    private final RestTemplate restTemplate;
    private final String applicationKey;


    public WeatherRepository(final RestTemplate restTemplate,
//                             @Value("${WEATHER_KEY:no-key}") final String applicationKey) {
//                             @Value("${WEATHER_KEY:null}") final String applicationKey) {
                             @Value("${weather.key}") final String applicationKey) {
        this.restTemplate = restTemplate;
        this.applicationKey = applicationKey;
        log.info("weather.key: [{}]", applicationKey);
    }

    public String readRawJson() {
        return restTemplate.getForObject(LONDEK_CONNECTION_URL, String.class);
    }

    public String readWeatherForCity(String city) {

        Map<String, String> requestParams = Map.of(
                "city", city,
                "key", DEFAULT_KEY
        );

        ResponseEntity<String> response = restTemplate.getForEntity(CONNECTION_URL, String.class, requestParams);
//        restTemplate.getForEntity(CONNECTION_URL, String.class, city, DEFAULT_KEY);
        log.info("response: [{}]", response);
        log.info("response status: [{}]", response.getStatusCode());
        response
                .getHeaders()
                .forEach((key, value) -> log.info("header key: [{}] - value: [{}]",
                    key, value));

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return "{}";
    }

    public WeatherForecast readWeatherForecastForGivenCity(String city) {
        WeatherForecast result = restTemplate.getForObject(CONNECTION_URL, WeatherForecast.class,
                Map.<String, String>of(
                        "city", city,
                        "key", DEFAULT_KEY
                ));

        log.info("received weather: [{}]", result);
        return result;
    }
}
