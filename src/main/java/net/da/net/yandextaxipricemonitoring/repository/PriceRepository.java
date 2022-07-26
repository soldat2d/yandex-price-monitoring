package net.da.net.yandextaxipricemonitoring.repository;

import net.da.net.yandextaxipricemonitoring.model.MomentPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<MomentPrice, Long> {
}
