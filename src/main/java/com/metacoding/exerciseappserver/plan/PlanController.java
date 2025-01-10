package com.metacoding.exerciseappserver.plan;
import com.metacoding.exerciseappserver._core.auth.SessionUser;
import com.metacoding.exerciseappserver._core.error.exception.Exception403;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import com.metacoding.exerciseappserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PlanController {
    private final PlanService planService;
    @GetMapping("/api/plan/user")

    public ResponseEntity<?> userinfo(@SessionUser User sessionUser) {
//        if (sessionUser.getId() != id) {
//            throw new Exception403("해당 정보에 접근할 권한이 없습니다 : "+id);
//        }
        ApiUtil.ApiResult<PlanResponse.UserWeekInfoDTO> resp = ApiUtil.success(planService.findUserWeekInfo(sessionUser.getId()));
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<?> plan(@PathVariable Integer id) {
        PlanResponse.DetailPlanDTO detailPlanDTO = planService.findByPlanId(id);
        return ResponseEntity.ok(ApiUtil.success(detailPlanDTO));
    }

    @PutMapping("/plan/update")
    public ResponseEntity<?> planUpdate(@RequestBody PlanRequest.UpdatePlanDTO requestDTO){
        System.out.println("요청온 데이터: " + requestDTO.getId());
        System.out.println("요청온 데이터: " + requestDTO.getExerciseSet());
        System.out.println("요청온 데이터: " + requestDTO.getRepeat());
        PlanResponse.UpdatePlanDTO updatePlanDTO = planService.updatePlan(requestDTO);

        return ResponseEntity.ok(ApiUtil.success(updatePlanDTO));
    }

    // 요일 별 운동 계획 상세보기 화면에 요일 별 운동 계획 리스트 출력 (user_id와 day(요일) 필요)
    // TODO : 데이터 넘어오는거 확인 후 매핑 url앞에 /api 붙이기 (인증 가능하도록)
    @GetMapping("/plan/{id}")
    public ResponseEntity plan(@PathVariable Integer id, @RequestParam("day") String day) {
        System.out.println(id); // user_id 확인용 출력
        System.out.println(day); // 요일 확인용 출력
    return  ResponseEntity.ok(null);
    }
}
