package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton, mBottomButton;
    int mStoryIndex =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryNo");
        } else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        displayStory(mStoryIndex);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    displayStory(mStoryIndex);
                } else if(mStoryIndex == 3) {
                    mStoryIndex = 6;
                    displayStory(mStoryIndex);
                }
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1) {
                    mStoryIndex = 2;
                    displayStory(mStoryIndex);
                } else if(mStoryIndex == 3) {
                    mStoryIndex = 5;
                    displayStory(mStoryIndex);
                } else if(mStoryIndex == 2) {
                    mStoryIndex = 4;
                    displayStory(mStoryIndex);
                }

            }
        });


    }
    public void displayStory(int storyIndex) {
        if(storyIndex == 1) {
            mStoryTextView.setText(R.string.T1_Story);
            mTopButton.setText(R.string.T1_Ans1);
            mBottomButton.setText(R.string.T1_Ans2);
        } else if(storyIndex == 2) {
            mStoryTextView.setText(R.string.T2_Story);
            mTopButton.setText(R.string.T2_Ans1);
            mBottomButton.setText(R.string.T2_Ans2);
        } else if(storyIndex == 3) {
            mStoryTextView.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
        } else if(storyIndex == 4) {
            mStoryTextView.setText(R.string.T4_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        } else if(storyIndex == 5) {
            mStoryTextView.setText(R.string.T5_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        } else if(storyIndex == 6) {
            mStoryTextView.setText(R.string.T6_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryNo",mStoryIndex);
    }
}
