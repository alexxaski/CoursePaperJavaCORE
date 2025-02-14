package org.skypro.course_paper.interfac;

import org.skypro.course_paper.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(String questionText);
    List<Question> getAllQuestions();
}


