package pl.sda.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WeatherRepository {

    private static final String LONDEK_CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";

    private static final String CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q={city}&appid={key}";

    private RestTemplate restTemplate;


    public WeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String readRawJson() {
        return restTemplate.getForObject(LONDEK_CONNECTION_URL, String.class);
    }

    public String readWeatherForCity(String city) {
        return "";
    }
}
