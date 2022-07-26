package net.da.net.yandextaxipricemonitoring.model;

import lombok.Data;

import java.util.List;

@Data
public class Price {
      private String currency;
      private Double distance;
      private List<Options> options;
      private String time;
}
