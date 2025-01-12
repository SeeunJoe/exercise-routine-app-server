package com.metacoding.exerciseappserver.recode;

import com.metacoding.exerciseappserver._core.auth.SessionUser;
import com.metacoding.exerciseappserver._core.error.exception.Exception403;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import com.metacoding.exerciseappserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RecodeController {
    private final RecodeService recodeService;

    @GetMapping("/api/recode")
    public ResponseEntity<?> userinfo(@SessionUser User sessionUser) {
        RecodeRequest.RecodeDTO recodeDTO = recodeService.findAllRecodeByUserId(sessionUser.getId());

        return ResponseEntity.ok(ApiUtil.success(recodeDTO));
    }

    // 아래는 recode로 plan 테이블을 수동으로 옮겨담을 때 사용하는 용도
//    @GetMapping("/recode-all")
//    public ResponseEntity<?> userinfoASDF() {
//        recodeService.updateAllUserPlan();
//        return ResponseEntity.ok(ApiUtil.success(null));
//    }

}
