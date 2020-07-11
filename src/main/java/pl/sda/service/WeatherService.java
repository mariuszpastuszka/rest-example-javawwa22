package pl.sda.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.repository.WeatherRepository;

@Slf4j
public class WeatherService {

    private WeatherRepository repository;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public String getWeatherForLondek() {
        String jsonWeather = repository.readRawJson();
        log.info("json weather: {}", jsonWeather);

        return jsonWeather;
    }
}
