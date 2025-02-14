package org.skypro.course_paper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.course_paper.Service.ExaminerServiceImpl;
import org.skypro.course_paper.interfac.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void testGetQuestions() {
        List<Question> mockQuestions = Arrays.asList(
                new Question("Question 1", "Answer 1"),
                new Question("Question 2", "Answer 2"),
                new Question("Question 3", "Answer 3")
        );

        when(questionService.getAllQuestions()).thenReturn(mockQuestions);

        List<Question> selectedQuestions = examinerService.getQuestions(2);

        assertEquals(2, selectedQuestions.size());
        assertTrue(mockQuestions.containsAll(selectedQuestions));
    }
}
