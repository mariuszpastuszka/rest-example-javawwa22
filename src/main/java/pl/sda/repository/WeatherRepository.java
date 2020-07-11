package pl.sda.repository;

import org.springframework.web.client.RestTemplate;

public class WeatherRepository {

    private static final String CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";
    private RestTemplate restTemplate;


    public WeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String readRawJson() {
        return "";
    }

    public String readWeatherForCity(String city) {
        return "";
    }
}
