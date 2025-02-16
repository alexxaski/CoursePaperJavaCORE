package org.skypro.course_paper.Controller;

import org.skypro.course_paper.Question;
import org.skypro.course_paper.Service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @Autowired
    private JavaQuestionService javaQuestionService;

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestParam String question, @RequestParam String answer) {
        Question newQuestion = new Question(question, answer);
        javaQuestionService.addQuestion(newQuestion);
        return ResponseEntity.ok("Question added successfully");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.removeQuestion(question);
        return ResponseEntity.ok("Question removed successfully");
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = javaQuestionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
}

