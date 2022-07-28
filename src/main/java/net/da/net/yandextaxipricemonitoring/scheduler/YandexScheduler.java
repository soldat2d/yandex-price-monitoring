package net.da.net.yandextaxipricemonitoring.scheduler;

import lombok.RequiredArgsConstructor;
import net.da.net.yandextaxipricemonitoring.properties.YandexRequestParams;
import net.da.net.yandextaxipricemonitoring.service.TaxiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {
    private final YandexRequestParams yandexRequestParams;
    private final TaxiService taxiService;

    @Scheduled(fixedDelay = 120_000)
    public void yandexUpdatePrice() {
        taxiService.getPrice(yandexRequestParams);
    }
}
