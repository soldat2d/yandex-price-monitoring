package net.da.net.yandextaxipricemonitoring.service;

import lombok.RequiredArgsConstructor;
import net.da.net.yandextaxipricemonitoring.apiclient.TaxiApiClient;
import net.da.net.yandextaxipricemonitoring.model.YandexResponse;
import net.da.net.yandextaxipricemonitoring.properties.YandexRequestParams;
import net.da.net.yandextaxipricemonitoring.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxiService {
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;

    public void getPrice(YandexRequestParams yandexRequestParams) {

        YandexResponse yandexResponse = taxiApiClient.getPrice(yandexRequestParams);
//        if (yandexResponse.getServiceLevels().isEmpty()) {
//            throw new RuntimeException("Data is empty");
//        }
        System.out.println(yandexResponse);
//        Double priceDouble = yandexResponse.getOptions().get(0).getPrice();
//        MomentPrice momentPrice = new MomentPrice(LocalDateTime.now(), priceDouble);
//        priceRepository.save(momentPrice);
    }
}
