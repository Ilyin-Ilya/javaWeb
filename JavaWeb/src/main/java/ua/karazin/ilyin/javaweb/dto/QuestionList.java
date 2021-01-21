package ua.karazin.ilyin.javaweb.dto;

import java.util.ArrayList;

public class QuestionList {
    private int seq_number;
    private ArrayList<QuestionDisplay> questions;

    public QuestionList() {
        this.seq_number = 0;
    }

    public int getSeq_number() {
        return seq_number;
    }

    public void setSeq_number(int seq_number) {
        this.seq_number = seq_number;
    }

    public ArrayList<QuestionDisplay> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionDisplay> questions) {
        this.questions = questions;
    }
}
