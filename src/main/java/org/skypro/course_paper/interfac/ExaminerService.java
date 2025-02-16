package org.skypro.course_paper.interfac;

import org.skypro.course_paper.Question;
import java.util.List;


public interface ExaminerService {
    List<Question> getQuestions(int amount);
}


