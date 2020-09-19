package pl.mwyrzyk.transitapi.transit.serialization;

import pl.mwyrzyk.transitapi.transit.dto.DailyReportDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Optional;

public final class TransitSerializator {

    public static final int TOTAL_DISTANCE_FACTOR = 3;
    public static final String TOTAL_DISTANCE_UNIT = "km";
    public static final String TOTAL_PRICE_UNIT = "PLN";


    public static DailyReportDto toDailyReport(Object[] dailyReport) {
        DailyReportDto dailyReportDto = new DailyReportDto();
        dailyReportDto.setTotalDistance(Optional.ofNullable(dailyReport[0])
                .map(Object::toString)
                .map(distance -> distance.substring(0, distance.length() - TOTAL_DISTANCE_FACTOR))
                .orElse(BigInteger.ZERO.toString()) + TOTAL_DISTANCE_UNIT);
        dailyReportDto.setTotalPrice( Optional.ofNullable(dailyReport[1])
                .map(Object::toString)
                .orElse(BigInteger.ZERO.toString()) + TOTAL_PRICE_UNIT);
        return dailyReportDto;
    }
}
