package org.skypro.course_paper.Service;

import org.skypro.course_paper.Question;
import org.skypro.course_paper.interfac.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> javaQuestions = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        javaQuestions.add(question);
    }

    @Override
    public void removeQuestion(String questionText) {
        javaQuestions.removeIf(q -> q.getQuestion().equals(questionText));
    }

    @Override
    public List<Question> getAllQuestions() {
        return javaQuestions;
    }
}
