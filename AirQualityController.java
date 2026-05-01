import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // JSON 형태로 데이터를 반환하는 REST API 컨트롤러
@RequestMapping("/api/air")
@RequiredArgsConstructor
public class AirQualityController {

    private final AirQualityService airQualityService;

    /**
     * 특정 지역의 실시간 미세먼지 정보 조회
     * 예: GET /api/air/status?userId=user01&stationName=종로구
     */
    @GetMapping("/status")
    public ResponseEntity<AirQualityResponseDTO> getAirStatus(
            @RequestParam String userId,
            @RequestParam String stationName) {

        // 서비스 호출
        AirQualityResponseDTO result = airQualityService.getRealTimeAirQuality(userId, stationName);

        if (result != null) {
            return ResponseEntity.ok(result); // 200 OK와 데이터 반환
        } else {
            return ResponseEntity.internalServerError().build(); // 500 에러 처리
        }
    }

    /**
     * 관심 지역 즐겨찾기 등록
     * 예: POST /api/air/favorite
     */
    @PostMapping("/favorite")
    public ResponseEntity<String> addFavorite(
            @RequestParam String userId,
            @RequestParam String stationName) {

        try {
            airQualityService.addFavorite(userId, stationName);
            return ResponseEntity.ok("즐겨찾기 등록 성공!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("등록 실패: " + e.getMessage());
        }
    }
}