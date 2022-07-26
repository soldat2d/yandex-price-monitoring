package net.da.net.yandextaxipricemonitoring.model;

import lombok.Data;

@Data
public class Options {
        private Double class_level;
        private String class_name;
        private String class_text;
        private Double min_price;
        private Double price;
        private String price_text;
        private Double waiting_time;
}
