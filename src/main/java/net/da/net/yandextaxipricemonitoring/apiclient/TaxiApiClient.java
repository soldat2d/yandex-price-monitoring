package net.da.net.yandextaxipricemonitoring.apiclient;

import feign.Headers;
import io.micrometer.core.annotation.Timed;
import net.da.net.yandextaxipricemonitoring.model.YandexResponse;
import net.da.net.yandextaxipricemonitoring.properties.YandexRequestParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "yandexClient", url = "${yandex-request.url}")
public interface TaxiApiClient {
    @Timed("getPrices")
    @PostMapping
    @Headers("Content-Type: application/json")
    YandexResponse getPrice(YandexRequestParams yandexRequestParams);
}
