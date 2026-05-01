package com.witer.app.AirQuality

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class AirQualityService {

    private final AirQualityMapper airQualityMapper;
    private final RestTemplate restTemplate;

    // 공공데이터 포털에서 발급받은 인증키
    private final String SERVICE_KEY = "YOUR_ENCODED_SERVICE_KEY";
    private final String API_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";

    /**
     * 특정 측정소의 실시간 미세먼지 정보를 가져오는 메서드
     */
    public AirQualityResponseDTO getRealTimeAirQuality(String userId, String stationName) {

        // 1. 공공데이터 API 호출을 위한 URL 생성 (URI 빌더 사용으로 인코딩 문제 방지)
        URI uri = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("returnType", "json")
                .queryParam("numOfRows", "1")
                .queryParam("pageNo", "1")
                .queryParam("stationName", stationName)
                .queryParam("dataTerm", "DAILY")
                .queryParam("ver", "1.0")
                .build(true) // 이미 인코딩된 키를 쓸 경우 true
                .toUri();

        try {
            // 2. API 호출 및 DTO 바인딩
            AirQualityResponseDTO response = restTemplate.getForObject(uri, AirQualityResponseDTO.class);

            // 3. API 호출 성공 시 로그 기록 (Mapper 활용)
            if (response != null && "00".equals(response.getResponse().getHeader().getResultCode())) {
                airQualityMapper.insertApiLog(userId, uri.toString(), "SUCCESS");
                return response;
            }

        } catch (Exception e) {
            // 4. 예외 발생 시 로그 기록
            airQualityMapper.insertApiLog(userId, uri.toString(), "FAIL: " + e.getMessage());
        }

        return null;
    }

    /**
     * 즐겨찾기 지역 추가 로직
     */
    public void addFavorite(String userId, String stationName) {
        airQualityMapper.insertFavoriteLocation(userId, stationName);
    }
}