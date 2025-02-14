package org.skypro.course_paper.Service;

import org.skypro.course_paper.Question;
import org.skypro.course_paper.interfac.ExaminerService;
import org.skypro.course_paper.interfac.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Autowired
    private QuestionService questionService;

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough questions available");
        }
        List<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();
        while (randomQuestions.size() < amount) {
            int randomIndex = random.nextInt(allQuestions.size());
            Question randomQuestion = allQuestions.get(randomIndex);
            if (!randomQuestions.contains(randomQuestion)) {
                randomQuestions.add(randomQuestion);
            }
        }
        return randomQuestions;
    }
}


