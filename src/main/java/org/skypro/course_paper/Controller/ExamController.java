package org.skypro.course_paper.Controller;

import org.skypro.course_paper.Question;
import org.skypro.course_paper.interfac.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExaminerService examinerService;

    @GetMapping("/get/{amount}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable int amount) {
        List<Question> questions = examinerService.getQuestions(amount);
        return ResponseEntity.ok(questions);
    }
}


