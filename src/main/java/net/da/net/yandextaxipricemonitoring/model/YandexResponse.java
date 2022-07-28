package net.da.net.yandextaxipricemonitoring.model;

import lombok.Data;

import java.util.List;

@Data
public class YandexResponse {
      private String distance;
      private String time;
      private List<ServiceLevel> serviceLevels;
}
