/**
 * @(#)GetExam.java, 2018-01-10.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.tikucrawl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * GetExam
 *
 * @author lirongqian
 * @since 2018/01/10
 */
@Slf4j
public class GetExam {

    private static final String questionUrl = "http://ws075x.corp.youdao.com:19970/tiku/question/update?force=true";

    private static String quizUrl = "http://ws075x.corp.youdao.com:19970/tiku/quiz/update";

    private static ObjectMapper jackson = new ObjectMapper();

    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        String s = httpJsonGet("https://api.566.com/APP/exam8/Tiku/Paper/430/16447154/143126807/GetPaper/_apple/780063694f3d6c912c10944050db7506");
        JsonNode paperEntity = jackson.readTree(s).get("PaperResult").get("PaperEntity");
        /*// 获取题目信息
        JsonNode tKQuestionsBasicEntityList = paperEntity.get("TKQuestionsBasicEntityList");
        // 获取公用的题目信息
        JsonNode tKContextQuestionsEntityList = paperEntity.get("TKContextQuestionsEntityList");
        int index = 0;
        int sectionLen = tKQuestionsBasicEntityList.size();
        String paperName = paperEntity.get("PaperName").textValue();
        // 过滤字符
        if (paperName.contains("【")) {
            paperName = paperName.split("【")[0];
        }
        // 构建分类树
        long categoryId = 0;
        if (paperName.contains("四")) {
            categoryId = 3;
        } else if (paperName.contains("六")) {
            categoryId = 5;
        }
        // 获取题目日期
        String[] date = paperName.split("[\\u4e00-\\u9fa5]");
        String pastYear = date[0] + "." + date[1];
        List<QuizContent.Section> sectionList = new ArrayList<>(sectionLen);
        for (int i = 0; i < sectionLen; i++) {
            // 存储Section
            JsonNode sectionNode = tKQuestionsBasicEntityList.get(i);
            QuizContent.Section section = new QuizContent.Section();
            section.setId(i + 1);
            section.setIntroduction(sectionNode.get("QuestionDescription").textValue());
            section.setTitle(sectionNode.get("QuestionTitle").textValue());
            JsonNode questionNode = sectionNode.get("QuestionsEntityList");
            int amount = sectionNode.get("Quantity").intValue();
            double score = 0;
            List<Long> bigQuestionList = new ArrayList<>();
            String pattern = sectionNode.get("ShortTitle").textValue();
            // 存储BigQuestion
            if (pattern.contains("Listening")) {
                BigQuestion bigQuestion = new BigQuestion();
                JsonNode bigQuestionNode = questionNode.get(0);
                String audioUrl = bigQuestionNode.get("AudioUrl") == null ? "" : bigQuestionNode.get("AudioUrl").textValue();
                // 上传音频到ios转换地址，调用线程池
                audioUrl = NosUtils.transUrl(audioUrl, "xue");
                fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                bigQuestion.setPattern(QuestionPattern.LISTENING);
                bigQuestion.setParentId(-1);
                bigQuestion.updateContent(new Listening(sectionNode.get("QuestionDescription").textValue(), audioUrl));
                int subSize = questionNode.size();
                List<BigQuestion> subQuestionList = new ArrayList<>(subSize);
                for (int j = 0; j < amount; j++) {
                    JsonNode subQuestionNode = questionNode.get(j);
                    score += subQuestionNode.get("QuestionScore").doubleValue();
                    BigQuestion subQuestion = new BigQuestion();
                    subQuestion.setPattern(QuestionPattern.SINGLE_CHOICE);

                    fillQuestion(subQuestion, categoryId, pastYear, paperName);

                    JsonNode optionsNode = subQuestionNode.get("QuestionContentKeyValue");
                    int optionSize = optionsNode.size();
                    List<String> options = new ArrayList<>(optionSize);
                    for (int k = 0; k < optionSize; k++) {
                        options.add(optionsNode.get(k).get("Value").textValue());
                    }
                    subQuestion.setAnswer(subQuestionNode.get("QuestionsAnswerEntity").get("AnswerArray").get(0).textValue());
                    subQuestion.setExplain(subQuestionNode.get("QuestionsAnswerEntity").get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    subQuestion.updateContent(new ChoiceQuestion(subQuestionNode.get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", "").replaceAll("\\.","<br/>"), options));
                    subQuestionList.add(subQuestion);
                }
                bigQuestion.setQuestions(subQuestionList);
                bigQuestionList.add(submit(bigQuestion));
                amount = 1;
            } else if (pattern.contains("Writing")) {
                for (int j = 0; j < amount; j++) {
                    score += questionNode.get(j).get("QuestionScore").doubleValue();
                    JsonNode bigQuestionNode = questionNode.get(j);
                    BigQuestion bigQuestion = new BigQuestion();

                    fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                    bigQuestion.setPattern(QuestionPattern.WRITING);
                    bigQuestion.updateContent(new Essay(bigQuestionNode.get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", "")));
                    bigQuestion.setAnswer(bigQuestionNode.get("QuestionsAnswerEntity").get("AnswerArray").get(0).textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    bigQuestion.setParentId(-1);
                    bigQuestion.setExplain(bigQuestionNode.get("QuestionsAnswerEntity").get("FormatContent").textValue().replaceAll("书面解析，稍后推出", "").replaceAll("<p>|</p>|<\\\\/p>", ""));
                    bigQuestionList.add(submit(bigQuestion));
                }
            } else if (pattern.contains("Reading A")) {
                BigQuestion bigQuestion = new BigQuestion();

                fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                bigQuestion.setPattern(QuestionPattern.WORD_CHOICE);
                bigQuestion.setParentId(-1);
                String passage = tKContextQuestionsEntityList.get(index++).get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", "");
                passage = passage.replaceAll("\\(", "?_");
                passage = passage.replaceAll("\\)", "_?").replaceAll("<p>|</p>|<\\\\/p>", "");
                passage = passage.replaceAll("_____", "");
                List<String> choicesValue = new ArrayList<>();
                List<BigQuestion> subQuestionList = new ArrayList<>();
                List<String> choicesKey = new ArrayList<>();
                int keys = questionNode.get(0).get("QuestionContentKeyValue").size();
                for (int j = 0; j < keys; j++) {
                    choicesKey.add(String.valueOf((char) ('A' + j)));
                }
                for (int j = 0; j < amount; j++) {
                    score += questionNode.get(j).get("QuestionScore").doubleValue();
                    JsonNode keyValue = questionNode.get(0).get("QuestionContentKeyValue").get(j);
                    choicesValue.add(keyValue.get("Value").textValue());
                    JsonNode subQuestionNode = questionNode.get(j).get("QuestionsAnswerEntity");
                    BigQuestion subQuestion = new BigQuestion();

                    fillQuestion(subQuestion, categoryId, pastYear, paperName);

                    subQuestion.updateContent(new ChoiceQuestion("题目内容", choicesKey));
                    subQuestion.setAnswer(subQuestionNode.get("AnswerArray").get(0).textValue());
                    subQuestion.setExplain(subQuestionNode.get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    subQuestion.setPattern(QuestionPattern.SINGLE_CHOICE);
                    subQuestionList.add(subQuestion);
                }
                amount = 1;
                bigQuestion.updateContent(new PassageChoice(Collections.singletonList(passage), choicesValue));
                bigQuestion.setQuestions(subQuestionList);
                bigQuestionList.add(submit(bigQuestion));
            } else if (pattern.contains("Reading B")) {
                BigQuestion bigQuestion = new BigQuestion();

                fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                bigQuestion.setPattern(QuestionPattern.PASSAGE_MATCH);
                bigQuestion.setParentId(-1);
                List<String> choices = new ArrayList<>();
                List<BigQuestion> subQuestionList = new ArrayList<>();
                int keys = questionNode.get(0).get("QuestionContentKeyValue").size();
                for (int j = 0; j < keys; j++) {
                    choices.add(String.valueOf((char) ('A' + j)));
                }
                for (int j = 0; j < amount; j++) {
                    score += questionNode.get(j).get("QuestionScore").doubleValue();
                    JsonNode subQuestionNode = questionNode.get(j).get("QuestionsAnswerEntity");

                    BigQuestion subQuestion = new BigQuestion();

                    fillQuestion(subQuestion, categoryId, pastYear, paperName);

                    subQuestion.updateContent(new ChoiceQuestion(questionNode.get(j).get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""), choices));
                    subQuestion.setAnswer(subQuestionNode.get("AnswerArray").get(0).textValue());
                    subQuestion.setExplain(subQuestionNode.get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    subQuestion.setPattern(QuestionPattern.SINGLE_CHOICE);
                    subQuestionList.add(subQuestion);
                }
                String description = tKContextQuestionsEntityList.get(index++).get("FormatContent").textValue();
                String pattern1 = "<p>(.*?)</p>";
                Pattern pattern2 = Pattern.compile(pattern1);
                Matcher matcher = pattern2.matcher(description);
                List<String> choiceValue = new ArrayList<>();
                while (matcher.find()) {
                    choiceValue.add(matcher.group().replaceAll("<p>|</p>|<\\\\/p>", "").replaceAll("\\[[A-Z]\\]", ""));
                }
                amount = 1;
                bigQuestion.updateContent(new PassageMatch("段落匹配", choiceValue));
                bigQuestion.setQuestions(subQuestionList);
                bigQuestionList.add(submit(bigQuestion));
            } else if (pattern.contains("Reading C")) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < amount; j++) {
                    score += questionNode.get(j).get("QuestionScore").doubleValue();
                    int contextQuestionId = questionNode.get(j).get("ContextQuestionId").intValue();
                    map.put(contextQuestionId, map.getOrDefault(contextQuestionId, 0) + 1);
                }
                amount = map.size();
                int start = 0;
                for (int j = 0; j < map.size(); j++) {
                    BigQuestion bigQuestion = new BigQuestion();

                    fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                    bigQuestion.setPattern(QuestionPattern.READING);
                    bigQuestion.setParentId(-1);
                    String passage = tKContextQuestionsEntityList.get(index++).get("FormatContent").textValue();
                    List<String> passages = new ArrayList<>();
                    String pattern1 = "<p>(.*?)</p>";
                    Pattern pattern2 = Pattern.compile(pattern1);
                    Matcher matcher = pattern2.matcher(passage);
                    while (matcher.find()) {
                        passages.add(matcher.group().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    }
                    bigQuestion.updateContent(new Reading(passages));
                    List<BigQuestion> subQuestionList = new ArrayList<>();
                    int k;
                    index--;
                    int contextQuestionId = tKContextQuestionsEntityList.get(index++).get("ContextId").intValue();
                    for (k = start; k < start + map.get(contextQuestionId); k++) {
                        BigQuestion subQuestion = new BigQuestion();
                        fillQuestion(subQuestion, categoryId, pastYear, paperName);

                        JsonNode subQuestionNode = questionNode.get(j);
                        List<String> choices = new ArrayList<>();
                        for (int m = 0; m < subQuestionNode.get("QuestionContentKeyValue").size(); m++) {
                            choices.add(subQuestionNode.get("QuestionContentKeyValue").get(m).get("Value").textValue());
                        }
                        subQuestion.updateContent(new ChoiceQuestion(questionNode.get(k).get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""), choices));
                        subQuestion.setAnswer(subQuestionNode.get("QuestionsAnswerEntity").get("AnswerArray").get(0).textValue());
                        subQuestion.setExplain(subQuestionNode.get("QuestionsAnswerEntity").get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                        subQuestion.setPattern(QuestionPattern.SINGLE_CHOICE);
                        subQuestionList.add(subQuestion);
                    }
                    start = k;
                    bigQuestion.setQuestions(subQuestionList);
                    bigQuestionList.add(submit(bigQuestion));
                }
            } else if (pattern.contains("Translation")) {
                for (int j = 0; j < amount; j++) {
                    score += questionNode.get(j).get("QuestionScore").doubleValue();
                    JsonNode bigQuestionNode = questionNode.get(j);
                    BigQuestion bigQuestion = new BigQuestion();

                    fillQuestion(bigQuestion, categoryId, pastYear, paperName);

                    bigQuestion.setPattern(QuestionPattern.ESSAY);
                    bigQuestion.updateContent(new Essay(bigQuestionNode.get("FormatContent").textValue().replaceAll("<p>|</p>|<\\\\/p>", "")));
                    bigQuestion.setAnswer(bigQuestionNode.get("QuestionsAnswerEntity").get("AnswerArray").get(0).textValue().replaceAll("<p>|</p>|<\\\\/p>", ""));
                    bigQuestion.setParentId(-1);
                    bigQuestion.setExplain(bigQuestionNode.get("QuestionsAnswerEntity").get("FormatContent").textValue().replaceAll("书面解析，稍后推出", "").replaceAll("<p>|</p>|<\\\\/p>", ""));
                    bigQuestionList.add(submit(bigQuestion));
                }
            }
            section.setScore(score);
            section.setQuestions(bigQuestionList);
            sectionList.add(section);
            section.setAmount(amount);
        }
        // 存储QuizContent
        QuizContent quizContent = new QuizContent();
        quizContent.setPattern("exam");
        quizContent.setSections(sectionList);
        CacheApi.httpJsonPost(String.format(quizUrl + "?id=%s&title=%s&pattern=%s", -System.currentTimeMillis(), paperName, "exam"), quizContent);
        // 关闭线程池
        NosUtils.shutDownPool();*/
    }

    /*private static void fillQuestion(BigQuestion bigQuestion, long categoryId, String pastYear, String paperName) {
        bigQuestion.setId(-System.currentTimeMillis());
        bigQuestion.setCategoryId(categoryId);
        bigQuestion.setType("真题");
        bigQuestion.setPastYear(pastYear);
        bigQuestion.setSource(paperName);
        bigQuestion.setUpdateTime(System.currentTimeMillis());
    }*/

    /*private static long submit(BigQuestion bigQuestion) throws IOException {
        String s = CacheApi.httpJsonPost(questionUrl, bigQuestion);
        JsonNode jsonNode = jackson.readTree(s).get("data");
        return jsonNode.get("id").longValue();
//        System.out.println(bigQuestion);
//        return 1;
    }*/

    public static String httpJsonGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("fake-user", "robot");
        // try-with-resources
        try (CloseableHttpResponse ret = HttpClient.get(httpGet)) {
            int statusCode = ret.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                log.warn("request failed with code:" + statusCode);
                return null;
            }
            HttpEntity entity = ret.getEntity();
            String responseStr = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            log.info("httpJsonGet: " + url + "; " + responseStr);
            return responseStr;
        } catch (Exception e) {
            log.warn("httpJsonGet failure!", e);
            return null;
        }
    }

}