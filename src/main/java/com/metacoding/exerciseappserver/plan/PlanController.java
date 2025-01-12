package com.metacoding.exerciseappserver.plan;
import com.metacoding.exerciseappserver._core.auth.SessionUser;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import com.metacoding.exerciseappserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlanController {
    private final PlanService planService;

    @GetMapping("/api/plan/user")
    public ResponseEntity<?> userinfo(@SessionUser User sessionUser) {
        ApiUtil.ApiResult<PlanResponse.UserWeekInfoDTO> resp = ApiUtil.success(planService.findUserWeekInfo(sessionUser.getId()));
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/plan/{id}")
    public ResponseEntity<?> savePlan(@PathVariable Integer id, @RequestBody PlanRequest.PlanAddDTO planAdd) {
        ApiUtil.ApiResult<PlanResponse.DTO> resp = ApiUtil.success(planService.insertPlan(id, planAdd));

        return ResponseEntity.ok(resp);
    }
    @GetMapping("/plan/detail/{id}")
    public ResponseEntity<?> plan(@PathVariable Integer id) {
        PlanResponse.DetailPlanDTO detailPlanDTO = planService.findByPlanId(id);
        return ResponseEntity.ok(ApiUtil.success(detailPlanDTO));
    }

    @PutMapping("/plan/update")
    public ResponseEntity<?> planUpdate(@RequestBody PlanRequest.UpdatePlanDTO requestDTO){
        PlanResponse.UpdatePlanDTO updatePlanDTO = planService.updatePlan(requestDTO);

        return ResponseEntity.ok(ApiUtil.success(updatePlanDTO));
    }

    // 요일 별 운동 계획 상세보기 화면에 요일 별 운동 계획 리스트 출력 (user_id와 day(요일) 필요)
    @GetMapping("/api/plan")
    public ResponseEntity<?> plan(@RequestParam("day") String day, @SessionUser User sessionUser) {
        List<PlanResponse.PlanOfDayDTO> plans = planService.findPlanOfDay(sessionUser.getId(), day);
        ApiUtil.ApiResult<List<PlanResponse.PlanOfDayDTO>> resp = ApiUtil.success(plans);
        return  ResponseEntity.ok(resp);
    }

    // 요일 별 운동 계획 리스트에서 운동 삭제
    @DeleteMapping("/api/plan/{id}/{weekName}")
    public ResponseEntity<?> deletePlan(@SessionUser User sessionUser, @PathVariable Integer id, @PathVariable String weekName) {

        planService.deleteByPlanId(sessionUser, id, weekName);
        return ResponseEntity.ok(ApiUtil.success(null));
    }
}