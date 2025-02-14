package org.skypro.course_paper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.course_paper.Service.JavaQuestionService;
import org.skypro.course_paper.interfac.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    public void testAddQuestion() {
        Question question = new Question("Что такое яблоко ?", "Яблоко это фрукт");
        javaQuestionService.addQuestion(question);
        assertEquals(1, javaQuestionService.getAllQuestions().size());
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question("Что такое яблоко ?", "Яблоко это фрукт");
        javaQuestionService.addQuestion(question);
        javaQuestionService.removeQuestion("Что такое яблоко ?");
        assertTrue(javaQuestionService.getAllQuestions().isEmpty());
    }

    @Test
    public void testGetAllQuestions() {
        List<Question> questions = javaQuestionService.getAllQuestions();
        assertEquals(0, questions.size());
    }
}
