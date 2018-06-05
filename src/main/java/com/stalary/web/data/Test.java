package com.stalary.web.data;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/05/11
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        UserQuestion.Question.ChoiceQuestion choiceQuestion1 = new UserQuestion.Question.ChoiceQuestion(1001L, "A", "B");
        UserQuestion.Question.ChoiceQuestion choiceQuestion2 = new UserQuestion.Question.ChoiceQuestion(1002L, "A", "B");

        UserQuestion.Question.TextQuestion textQuestion1 = new UserQuestion.Question.TextQuestion(2001L, 28);
        UserQuestion.Question.TextQuestion textQuestion2 = new UserQuestion.Question.TextQuestion(2002L, 99);

        Thread.sleep(100);
        UserQuestion.Question question1 = new UserQuestion.Question(Arrays.asList(choiceQuestion1, choiceQuestion2), Arrays.asList(textQuestion1, textQuestion2), 88, System.currentTimeMillis());
        UserQuestion.Question question2 = new UserQuestion.Question(Arrays.asList(choiceQuestion1, choiceQuestion2), Arrays.asList(textQuestion1, textQuestion2), 68, System.currentTimeMillis());

        Map<Long, UserQuestion.Question> map = new LinkedHashMap<>();
        map.put(1L, question1);
        map.put(2L, question2);
        UserQuestion userQuestion = new UserQuestion(map);
        userQuestion.getQuestionMap().put(3L, question1);
        System.out.println(gson.toJson(userQuestion));
    }


    @Data
    @AllArgsConstructor
    static class UserQuestion {

        Map<Long, Question> questionMap;

        @Data
        @AllArgsConstructor
        static class Question {

            /**
             * 主观题
             */
            private List<ChoiceQuestion> choiceQuestions;

            /**
             * 客观题
             */
            private List<TextQuestion> textQuestionList;

            /**
             * 正确率
             */
            private int rate;

            private long time;


            @Data
            @AllArgsConstructor
            static class ChoiceQuestion {

                private Long questionId;

                /**
                 * 用户答案
                 */
                private String answer;

                /**
                 * 正确答案
                 */
                private String right;

            }

            @Data
            @AllArgsConstructor
            static class TextQuestion {

                private Long questionId;

                /**
                 * 分数
                 */
                private int score;
            }
        }
    }

}