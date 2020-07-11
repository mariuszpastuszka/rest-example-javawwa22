package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
