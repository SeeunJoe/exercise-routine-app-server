package com.metacoding.exerciseappserver.fitness;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FitnessService {
    private final FitnessRepository fitnessRepository;


    public List<FitnessResponse.ExerciseListDTO> getFitnessList() {

        return fitnessRepository.findAll().stream()
                .map(FitnessResponse.ExerciseListDTO::new)
                .toList();
    }

/*    Board board = boardRepository.findByIdJoinUserAndReply(id)
            .orElseThrow(() -> new Exception404("해당 id의 게시글이 없습니다 : "+id));
        return new BoardResponse.DetailDTO(board, sessionUser);*/

    public List<FitnessResponse.ListByCateDTO> getFitnessListByCate(int categoryId) {
        return fitnessRepository.findById(categoryId).stream()
                .map(FitnessResponse.ListByCateDTO::new)
                .toList();


    }
}
