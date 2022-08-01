package net.da.net.yandextaxipricemonitoring.repository;

import io.micrometer.core.annotation.Timed;
import net.da.net.yandextaxipricemonitoring.model.MomentPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<MomentPrice, Long> {
    @Timed("findAll")
    List<MomentPrice> findAll();
}
