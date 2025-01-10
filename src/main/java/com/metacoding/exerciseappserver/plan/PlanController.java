package com.metacoding.exerciseappserver.plan;
import com.metacoding.exerciseappserver._core.auth.SessionUser;
import com.metacoding.exerciseappserver._core.error.exception.Exception403;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import com.metacoding.exerciseappserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/plan/asd")
    public ResponseEntity<?> asd(@RequestBody PlanRequest.PlanAddDTO planAdd) {
        ApiUtil.ApiResult<PlanResponse.DTO> resp = ApiUtil.success(planService.insertPlan(planAdd));

        System.out.println(resp.getResponse().toString());
        return ResponseEntity.ok(resp);
    }
}
