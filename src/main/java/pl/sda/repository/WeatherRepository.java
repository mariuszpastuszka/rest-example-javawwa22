package pl.sda.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WeatherRepository {

    private static final String LONDEK_CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";

    private static final String CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q={city}&appid={key}";

    private static final String DEFAULT_KEY = "439d4b804bc8187953eb36d2a8c26a02";

    private RestTemplate restTemplate;


    public WeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String readRawJson() {
        return restTemplate.getForObject(LONDEK_CONNECTION_URL, String.class);
    }

    public String readWeatherForCity(String city) {

        Map<String, String> requestParams = Map.of(
                "city", city,
                "key", DEFAULT_KEY
        );

        restTemplate.getForEntity(CONNECTION_URL, String.class, requestParams);
//        restTemplate.getForEntity(CONNECTION_URL, String.class, city, DEFAULT_KEY);
        return "";
    }
}
