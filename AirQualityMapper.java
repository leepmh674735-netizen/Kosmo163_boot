package com.winer.app.AitQualityty

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AirQualityMapper {

    List<AirQualityDisplay> selectFavoriteLocations(String userId);

    int insertFavoriteLocation(String userId, String stationName)

    int deleteFavoriteLocation(String userId, String stationName)

    void insertApiLog(String userId, String requestUrl, String status);
}
