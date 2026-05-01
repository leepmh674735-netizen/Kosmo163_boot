package com.winter.app.AirQualityDisplay;

import lombok.Buider;
import lombok.Getter;

@Getter
@Builder
public class AirQualityDisplayDTO {
    private String location;
    private Sting measuredAt;
    private int pm10;
    private String status;
}