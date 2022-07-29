package net.da.net.yandextaxipricemonitoring.service;

import io.micrometer.core.instrument.MeterRegistry;
import net.da.net.yandextaxipricemonitoring.apiclient.TaxiApiClient;
import net.da.net.yandextaxipricemonitoring.model.MomentPrice;
import net.da.net.yandextaxipricemonitoring.model.YandexResponse;
import net.da.net.yandextaxipricemonitoring.properties.YandexRequestParams;
import net.da.net.yandextaxipricemonitoring.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaxiService {
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;
    private AtomicInteger price;

    public TaxiService(TaxiApiClient taxiApiClient, PriceRepository priceRepository, MeterRegistry meterRegistry) {
        this.taxiApiClient = taxiApiClient;
        this.priceRepository = priceRepository;
        price = new AtomicInteger();
        meterRegistry.gauge("priceTaxi", price);
    }

    public void getPrice(YandexRequestParams yandexRequestParams) {

        YandexResponse yandexResponse = taxiApiClient.getPrice(yandexRequestParams);
        if (yandexResponse.getService_levels().isEmpty()) {
            throw new RuntimeException("Data is empty");
        }
//        добавляем случайное значение так как ответ один и тот же
        price.set((int) (yandexResponse.getService_levels().get(0).getPrice()+ (int)(Math.random()*30)));
        priceRepository.save(new MomentPrice(LocalDateTime.now(), price.get()));
    }

    public List<MomentPrice> getAllPrice() {
        return priceRepository.findAll();
    }
}
