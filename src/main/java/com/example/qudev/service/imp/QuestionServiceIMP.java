package com.example.qudev.service.imp;

import com.example.qudev.model.question.QsOption;
import com.example.qudev.model.question.Question;
import com.example.qudev.model.question.SurveyVersion;
import com.example.qudev.model.request.OptionRequest;
import com.example.qudev.model.request.QuestionRequest;
import com.example.qudev.model.response.OptionResponse;
import com.example.qudev.model.response.QuestionResponse;
import com.example.qudev.model.response.SurveyVersionResponse;
import com.example.qudev.repository.QuestionRepo;
import com.example.qudev.repository.SurveyVersionRepo;
import com.example.qudev.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class QuestionServiceIMP implements QuestionService {
    final SurveyVersionRepo surveyVersionRepo;
    final QuestionRepo questionRepo;

    public QuestionServiceIMP(SurveyVersionRepo surveyVersionRepo, QuestionRepo questionRepo) {
        this.surveyVersionRepo = surveyVersionRepo;
        this.questionRepo = questionRepo;
    }

    @Override
    public SurveyVersionResponse collectQuestion(long versionId) {
        SurveyVersion version = surveyVersionRepo.fetchFullVersion(versionId)
                .orElseThrow(() -> new RuntimeException("Version not found"));
        SurveyVersionResponse response= new SurveyVersionResponse();
        response.setVersionId(version.getId());

        //collect question and options
        List<QuestionResponse> questionList = version.getQuestions()
                .stream()
                .sorted(Comparator.comparing(Question::getOrder)) // arranging in order
                .map(qu->{
                    QuestionResponse quResponse = QuestionResponse.builder()
                            .id(qu.getId())
                            .key(qu.getQuestion_key())
                            .text(qu.getQuestion_text())
                            .type(qu.getType().name())
                            .required(qu.isRequired())
                            .build();

                    //collect option each question
                    List<OptionResponse> options = qu.getOption().
                            stream()
                            .sorted(Comparator.comparing(QsOption::getOrder)) // arranging in order
                            .map(opt ->{
                                return OptionResponse.builder()
                                        .key(opt.getOption_key())
                                        .label(opt.getOption_text())
                                        .build();
                            })
                            .toList();

                    quResponse.setOptions(options);
                    return  quResponse;
                })
                .toList();

        response.setQuestions(questionList);
        return response;
    }

    @Override
    public void saveQuestion(Long versionId, QuestionRequest request) {
        SurveyVersion version = surveyVersionRepo.findById(versionId)
                .orElseThrow(() -> new RuntimeException("Version not found"));

        Question question= Question.builder()
                .order(request.getOrder())
                .question_text(request.getQuestionText())
                .question_key(request.getQuestionKey())
                .type(request.getType())
                .required(request.isRequired())
                .surveyVersion(version) // link with id
                .active(true)
                .build();

        if(request.getOptions() != null &&
                (request.getType() == Question.Type.SINGLE
                        || request.getType() == Question.Type.MULTIPLE)){

            int order=1;
            for (OptionRequest opt : request.getOptions()) {

                QsOption option=QsOption.builder()
                        .option_key(opt.getKey())
                        .option_text(opt.getLabel())
                        .order(order++)
                        .question(question) // link with id
                        .active(true)
                        .build();
                question.addOption(option);
            }
        }
        questionRepo.save(question);
    }


}
