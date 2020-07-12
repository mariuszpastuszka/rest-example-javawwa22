package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.domain.WeatherForecast;
import pl.sda.service.WeatherService;

@RestController
public class WeatherRestController {

    private WeatherService service;


    public WeatherRestController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/londek")
    public String weather1() {
        return service.getWeatherForLondek();
    }

    @GetMapping("/weather/city/{city}")
    public String weatherForCity(@PathVariable String city) {
        return service.getWeatherForCity(city);
    }

    @GetMapping("/weather-forecast/{city}")
    public WeatherForecast weatherForecast(@PathVariable String city) {
        return service.getWeatherForecastForCity(city);
    }
}
