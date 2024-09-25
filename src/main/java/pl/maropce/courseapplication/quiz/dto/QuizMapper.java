package pl.maropce.courseapplication.quiz.dto;

import pl.maropce.courseapplication.quiz.Quiz;

public class QuizMapper {

    public static QuizDTO toDto(Quiz quiz) {
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setId(quiz.getId());
        quizDTO.setTitle(quiz.getTitle());

        return quizDTO;
    }
}
