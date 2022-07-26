package net.da.net.yandextaxipricemonitoring.service;

import lombok.RequiredArgsConstructor;
import net.da.net.yandextaxipricemonitoring.apiclient.TaxiApiClient;
import net.da.net.yandextaxipricemonitoring.model.Coordinate;
import net.da.net.yandextaxipricemonitoring.model.MomentPrice;
import net.da.net.yandextaxipricemonitoring.model.Price;
import net.da.net.yandextaxipricemonitoring.properties.YandexProperties;
import net.da.net.yandextaxipricemonitoring.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaxiService {
    private final YandexProperties yandexProperties;
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;
    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.toString() + '~' + endPoint.toString();
        String clid = yandexProperties.getClid();
        String apiKey = yandexProperties.getApiKey();

        Price currentPrice = taxiApiClient.getPrice(clid, apiKey, rll);
        if (currentPrice.getOptions().isEmpty()) {
            throw new RuntimeException("Options are empty");
        }
        Double priceDouble = currentPrice.getOptions().get(0).getPrice();
        MomentPrice momentPrice = new MomentPrice(LocalDateTime.now(), priceDouble);
        priceRepository.save(momentPrice);
    }
}
