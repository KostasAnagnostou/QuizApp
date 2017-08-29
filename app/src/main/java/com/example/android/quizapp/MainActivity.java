package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /*  Log Tag  */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Bind the Views with butter knife library
    @BindView(R.id.question_three_input)
    EditText mQuestionThree;
    @BindView(R.id.question_four_option_one)
    CheckBox mQuestionFourOne;
    @BindView(R.id.question_four_option_two)
    CheckBox mQuestionFourTwo;
    @BindView(R.id.question_four_option_three)
    CheckBox mQuestionFourThree;
    @BindView(R.id.question_four_option_four)
    CheckBox mQuestionFourFour;
    @BindView(R.id.question_four_option_five)
    CheckBox mQuestionFourFive;
    @BindView(R.id.question_four_option_six)
    CheckBox mQuestionFourSix;
    @BindView(R.id.question_six_option_one)
    CheckBox mQuestionSixOne;
    @BindView(R.id.question_six_option_two)
    CheckBox mQuestionSixTwo;
    @BindView(R.id.question_six_option_three)
    CheckBox mQuestionSixThree;
    @BindView(R.id.question_six_option_four)
    CheckBox mQuestionSixFour;
    @BindView(R.id.question_six_option_five)
    CheckBox mQuestionSixFive;
    @BindView(R.id.question_six_option_six)
    CheckBox mQuestionSixSix;
    @BindView(R.id.radio_group_question_one)
    RadioGroup mRadioGroupQ1;
    @BindView(R.id.radio_group_question_two)
    RadioGroup mRadioGroupQ2;
    @BindView(R.id.radio_group_question_five)
    RadioGroup mRadioGroupQ5;

    // Global Variables
    private int mFinalScore = 0;
    private int mScoreQ1;
    private int mScoreQ2;
    private int mScoreQ3;
    private int mScoreQ4;
    private int mScoreQ5;
    private int mScoreQ6;
    private boolean mCheckQ1;
    private boolean mCheckQ2;
    private boolean mCheckQ4;
    private boolean mCheckQ5;
    private boolean mCheckQ6;
    private String mCheckQ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Method to Check Question 1
     */
    @OnClick({R.id.question_one_option_one, R.id.question_one_option_two, R.id.question_one_option_three, R.id.question_one_option_four})
    public void onCheckQ1(View view) {
        mCheckQ1 = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.question_one_option_three) {
            mScoreQ1 = 10;
            Log.i(LOG_TAG, "Score Q1:" + mScoreQ1);
        } else {
            mScoreQ1 = 0;
            Log.i(LOG_TAG, "Score Q1:" + mScoreQ1);
        }
    }

    /**
     * Method to Check Question 2
     */
    @OnClick({R.id.question_two_option_one, R.id.question_two_option_two, R.id.question_two_option_three, R.id.question_two_option_four})
    public void onCheckQ2(View view) {
        mCheckQ2 = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.question_two_option_four) {
            mScoreQ2 = 10;
            Log.i(LOG_TAG, "Score Q2:" + mScoreQ2);
        } else {
            mScoreQ2 = 0;
            Log.i(LOG_TAG, "Score Q2:" + mScoreQ2);
        }
    }

    /**
     * Method to Check Question 3
     */
    public void OnCheckQ3(String answer) {
        answer = answer.replace(" ", "").toUpperCase();
        Log.i(LOG_TAG, "Question 3 has value: " + answer);
        // if the user typed something
        if (!TextUtils.isEmpty(answer)) {
            // Check Question 3
            if (answer.equals("LEBRONJAMES")) {
                mScoreQ3 = 10;
                Log.i(LOG_TAG, "Score Q3:" + mScoreQ3);
            } else {
                mScoreQ3 = 0;
                Log.i(LOG_TAG, "Score Q3:" + mScoreQ3);
            }
        }
    }

    /**
     * Method to Check Question 4
     */
    @OnClick({R.id.question_four_option_one, R.id.question_four_option_two, R.id.question_four_option_three, R.id.question_four_option_four,
            R.id.question_four_option_five, R.id.question_four_option_six})
    public void onCheckQ4(View view) {
        mCheckQ4 = mQuestionFourOne.isChecked() || mQuestionFourTwo.isChecked()
                || mQuestionFourThree.isChecked() || mQuestionFourFour.isChecked()
                || mQuestionFourFive.isChecked() || mQuestionFourSix.isChecked();

        boolean checkPerfect = mQuestionFourFour.isChecked() && mQuestionFourFive.isChecked() && mQuestionFourSix.isChecked();
        boolean isNotCheckThree = !mQuestionFourOne.isChecked() && !mQuestionFourTwo.isChecked() && !mQuestionFourThree.isChecked();

        boolean checkHalf = (mQuestionFourFour.isChecked() && mQuestionFourFive.isChecked()) ||
                (mQuestionFourFour.isChecked() && mQuestionFourSix.isChecked()) ||
                (mQuestionFourFive.isChecked() && mQuestionFourSix.isChecked());

        // if true, check these conditions and return the score
        if (mCheckQ4) {
            if (checkPerfect && isNotCheckThree) {
                mScoreQ4 = 40;
                Log.i(LOG_TAG, "Score Q4: " + mScoreQ4);
            } else if (checkHalf && isNotCheckThree) {
                mScoreQ4 = 20;
                Log.i(LOG_TAG, "Score Q4: " + mScoreQ4);
            } else {
                mScoreQ4 = 0;
                Log.i(LOG_TAG, "Score Q4: " + mScoreQ4);
            }
        }
    }

    /**
     * Method to Check Question 5
     */
    @OnClick({R.id.question_five_option_one, R.id.question_five_option_two, R.id.question_five_option_three, R.id.question_five_option_four})
    public void onCheckQ5(View view) {
        mCheckQ5 = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.question_five_option_three) {
            mScoreQ5 = 10;
            Log.i(LOG_TAG, "Score Q5:" + mScoreQ5);
        } else {
            mScoreQ5 = 0;
            Log.i(LOG_TAG, "Score Q5:" + mScoreQ5);
        }
    }

    /**
     * Method to Check Question 6
     */
    @OnClick({R.id.question_six_option_one, R.id.question_six_option_two, R.id.question_six_option_three, R.id.question_six_option_four,
            R.id.question_six_option_five, R.id.question_six_option_six})
    public void onCheckQ6(View view) {
        // Boolean mCheck6
        mCheckQ6 = mQuestionSixOne.isChecked() || mQuestionSixTwo.isChecked()
                || mQuestionSixThree.isChecked() || mQuestionSixFour.isChecked()
                || mQuestionSixFive.isChecked() || mQuestionSixSix.isChecked();

        boolean checkPerfect = mQuestionSixThree.isChecked() && mQuestionSixFour.isChecked();

        boolean isNotCheckFour = !mQuestionSixOne.isChecked() && !mQuestionSixTwo.isChecked() && !mQuestionSixFive.isChecked() &&
                !mQuestionSixSix.isChecked();

        // if true, check these conditions and return the score
        if (mCheckQ6) {
            if (checkPerfect && isNotCheckFour) {
                mScoreQ6 = 20;
                Log.i(LOG_TAG, "Score Q6: " + mScoreQ6);
            } else {
                mScoreQ6 = 0;
                Log.i(LOG_TAG, "Score Q6: " + mScoreQ6);
            }
        }
    }

    /**
     * Method to return the score
     * when the user clicks the submit button
     */
    @OnClick(R.id.submit_button)
    public void checkScore() {
        // get the user input from the Edit Text on Question 3
        mCheckQ3 = mQuestionThree.getText().toString().trim();
        Log.i(LOG_TAG, "Question 3 has value: " + mCheckQ3);
        // Check the user input
        OnCheckQ3(mCheckQ3);

        // If all the questions have been answered, display the score
        if (mCheckQ1 && mCheckQ2 && !TextUtils.isEmpty(mCheckQ3) && mCheckQ4 && mCheckQ5 && mCheckQ6) {
            mFinalScore = mScoreQ1 + mScoreQ2 + mScoreQ3 + mScoreQ4 + mScoreQ5 + mScoreQ6;
            String userScore = "You got " + mFinalScore + "/100 points." + "\n" +
                    "Your Score on Each Question: " + "\n\n" +
                    " Q1: " + mScoreQ1 + "/10 \n " +
                    "Q2: " + mScoreQ2 + "/10 \n " +
                    "Q3: " + mScoreQ3 + "/10 \n " +
                    "Q4: " + mScoreQ4 + "/40 \n " +
                    "Q5: " + mScoreQ5 + "/10 \n " +
                    "Q6: " + mScoreQ6 + "/20 ";
            Toast.makeText(this, userScore, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, getString(R.string.submit_error_message), Toast.LENGTH_LONG).show();
        }
    }

    // Method to reset the Quiz
    @OnClick(R.id.reset_button)
    public void resetButton() {
        // Reset Edit text
        mQuestionThree.setText("");

        // Reset Radio Groups
        mRadioGroupQ1.clearCheck();
        mRadioGroupQ2.clearCheck();
        mRadioGroupQ5.clearCheck();

        // Reset CheckBoxes
        mQuestionFourOne.setChecked(false);
        mQuestionFourTwo.setChecked(false);
        mQuestionFourThree.setChecked(false);
        mQuestionFourFour.setChecked(false);
        mQuestionFourFour.setChecked(false);
        mQuestionFourFive.setChecked(false);
        mQuestionFourSix.setChecked(false);
        mQuestionSixOne.setChecked(false);
        mQuestionSixTwo.setChecked(false);
        mQuestionSixThree.setChecked(false);
        mQuestionSixFour.setChecked(false);
        mQuestionSixFour.setChecked(false);
        mQuestionSixFive.setChecked(false);
        mQuestionSixSix.setChecked(false);

        // Reset Final Score
        mFinalScore = 0;
    }
}