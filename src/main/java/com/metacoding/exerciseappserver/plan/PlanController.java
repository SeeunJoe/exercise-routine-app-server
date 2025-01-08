package com.metacoding.exerciseappserver.plan;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PlanController {
    private final PlanService planService;
    // TODO : 로그인 구현 완료 후 sessionUser 어노테이션 + 주석 해제
    @GetMapping("/plan/user/{id}")
    public ResponseEntity<?> userinfo(@PathVariable Integer id) {

//        if (sessionUser.getId() != id) {
//            throw new Exception403("해당 정보에 접근할 권한이 없습니다 : "+id);
//        }
        ApiUtil.ApiResult<PlanResponse.UserWeekInfoDTO> resp = ApiUtil.success(planService.findUserWeekInfo(id));
        return ResponseEntity.ok(resp);
    }
}
