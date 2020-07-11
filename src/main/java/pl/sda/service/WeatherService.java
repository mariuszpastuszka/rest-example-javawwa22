package pl.sda.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.repository.WeatherRepository;

@Slf4j
@Service
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

    public String getWeatherForCity(String city) {
        String result = repository.readWeatherForCity(city);
        log.info("city [{}] weather [{}]", city, result);
        return result;
    }
}
