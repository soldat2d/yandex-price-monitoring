package net.da.net.yandextaxipricemonitoring.apiclient;

import net.da.net.yandextaxipricemonitoring.model.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yandexClient", url = "${yandex.url}")
public interface TaxiApiClient {
    @GetMapping
    Price getPrice(@RequestParam String clid, @RequestParam String apiKey, @RequestParam String rll);
}
