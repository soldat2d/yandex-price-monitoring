package net.da.net.yandextaxipricemonitoring.scheduler;

import lombok.RequiredArgsConstructor;
import net.da.net.yandextaxipricemonitoring.model.Coordinate;
import net.da.net.yandextaxipricemonitoring.properties.CoordinateProperties;
import net.da.net.yandextaxipricemonitoring.service.TaxiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {
    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());
        taxiService.getPrice(startPoint, endPoint);
    }
}
