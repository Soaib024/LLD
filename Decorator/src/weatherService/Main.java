package weatherService;

import java.util.HashMap;
import java.util.Map;

interface WeatherService {
    String getWeather(String city);
}

class WeatherAPI implements WeatherService {
    @Override
    public String getWeather(String city) {
        System.out.println("Calling external API...");
        return "Sunny in " + city;
    }
}

abstract class WeatherServiceDecorator implements WeatherService{
    private final WeatherService weatherService;
    public WeatherServiceDecorator(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @Override
    public String getWeather(String city) {
        return this.weatherService.getWeather(city);
    }
}

class LogDecorator extends WeatherServiceDecorator{
    public LogDecorator(WeatherService weatherService){
        super(weatherService);
    }

    @Override
    public String getWeather(String city) {
        String resp = super.getWeather(city);
        System.out.println("[LOG] Request for: " + city);
        System.out.println("[LOG] Response: " + resp);
        return  resp;
    }
}

class CacheDecorator extends WeatherServiceDecorator{
    private Map<String, String> cache = new HashMap<>();
    public CacheDecorator(WeatherService weatherService){
        super(weatherService);
    }

    @Override
    public String getWeather(String city) {
        if (cache.containsKey(city)) {
            return cache.get(city) + " (from cache)";
        }
        String resp = super.getWeather(city);
        cache.put(city, resp);
        return resp;
    }
}

class RateLimitDecorator extends WeatherServiceDecorator {

    private int calls = 0;
    private final int limit = 3;

    public RateLimitDecorator(WeatherService weatherService) {
        super(weatherService);
    }

    @Override
    public String getWeather(String city) {
        if (calls >= limit) {
            throw new RuntimeException("Rate limit exceeded!");
        }
        calls++;
        return super.getWeather(city);
    }
}


public class Main {
    public static void main(String[] args) {
        WeatherService service = new RateLimitDecorator(new CacheDecorator(new LogDecorator(new WeatherAPI())));
        System.out.println(service.getWeather("London"));
        System.out.println(service.getWeather("London"));
        System.out.println(service.getWeather("London"));
    }
}
