package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.domain.WeatherForecast;
import pl.sda.service.WeatherService;

@RestController
@Slf4j
public class WeatherRestController {

    private WeatherService service;


    public WeatherRestController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/londek")
    public String weather1() {
        log.info("weather for londek");
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

    @PostMapping("/londek")
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherForecast saveWeatherForecast(@RequestBody WeatherForecast objectToSave) {
        log.debug("object to save: [{}]", objectToSave);
        // saving object
        return objectToSave;
    }

    @PostMapping("/londek1")
    public ResponseEntity<WeatherForecast> saveWeatherForecast1(@RequestBody WeatherForecast objectToSave) {
        log.debug("object to save: [{}]", objectToSave);
        // saving object


        return objectToSave;
    }
}
