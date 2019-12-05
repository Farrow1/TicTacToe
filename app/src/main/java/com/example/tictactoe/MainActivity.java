package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    char mBoard[] = new char[9];
    Button mGameButtons[] = new Button[9];
    int counter;
    TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mGameStatus;


        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);

        mGameButtons[0] = btn_1;
        mGameButtons[1] = btn_2;
        mGameButtons[2] = btn_3;
        mGameButtons[3] = btn_4;
        mGameButtons[4] = btn_5;
        mGameButtons[5] = btn_6;
        mGameButtons[6] = btn_7;
        mGameButtons[7] = btn_8;
        mGameButtons[8] = btn_9;

        status = (TextView) findViewById(R.id.status);

        for(int i = 0;  i < 9; i++) {
            mBoard[i] = ' ';
        }
    }

    protected void newGame(View view){
        for(int i = 0; i < 9; i++) {
            mBoard[i] = ' ';
            mGameButtons[i].setText(" ");
        }
        btn_1.setEnabled(true);
        btn_2.setEnabled(true);
        btn_3.setEnabled(true);
        btn_4.setEnabled(true);
        btn_5.setEnabled(true);
        btn_6.setEnabled(true);
        btn_7.setEnabled(true);
        btn_8.setEnabled(true);
        btn_9.setEnabled(true);

        status.setText(" ");
        counter = 0;
    }

    public void setPlayerMove(View view){
            Button current = (Button) findViewById(view.getId());


            switch(view.getId()) {
                case R.id.btn_1:
                    if (mBoard[0] == ' ' && mBoard[0] != 'O') {
                        current.setText("X");
                        mBoard[0] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_2:
                    if(mBoard[1] == ' ' && mBoard[1] != 'O') {
                        current.setText("X");
                        mBoard[1] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_3:
                    if(mBoard[2] == ' ' && mBoard[2] != 'O') {
                        current.setText("X");
                        mBoard[2] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_4:
                    if(mBoard[3] == ' ' && mBoard[3] != 'O') {
                        current.setText("X");
                        mBoard[3] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_5:
                    if(mBoard[4] == ' ' && mBoard[4] != 'O') {
                        current.setText("X");
                        mBoard[4] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_6:
                    if(mBoard[5] == ' ' && mBoard[5] != 'O') {
                        current.setText("X");
                        mBoard[5] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_7:
                    if(mBoard[6] == ' '&& mBoard[6] != 'O') {
                        current.setText("X");
                        mBoard[6] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_8:
                    if(mBoard[7] == ' '&& mBoard[7] != 'O') {
                        current.setText("X");
                        mBoard[7] = 'X';
                        current.setEnabled(false);
                    }
                    break;
                case R.id.btn_9:
                    if(mBoard[8] == ' ' && mBoard[8] != 'O') {
                        current.setText("X");
                        mBoard[8] = 'X';
                        current.setEnabled(false);
                    }
                    break;
            }
            counter++;
            int win = checkForWinner();
            if (win ==0)
                getComputerMove();
            if (win == 1)
                status.setText("You have won :)");
            if (win == 2)
                status.setText("You have lost :(");
            if (win == 3)
                status.setText("You have Tied? :/");



    }

    protected void getComputerMove() {

        Random random = new Random();
        int rnd = random.nextInt(9);

        while(true){

            if(mBoard[rnd] == ' '){
                mGameButtons[rnd].setText("O");
                mBoard[rnd] = 'O';

                break;
            }
            rnd = random.nextInt(9);
        }
        counter++;
        int win = checkForWinner();
        if (win == 1)
            status.setText("You have won :)");
        if (win == 2)
            status.setText("You have lost :(");
        if (win == 3)
            status.setText("You have Tied? :/");

    }

    protected int checkForWinner(){

        int hasWon = 0;

        if((mBoard[0] =='X' && mBoard[1] =='X' && mBoard[2] =='X') ||
                (mBoard[3] =='X' && mBoard[4] =='X' && mBoard[5] =='X') ||
                (mBoard[6] =='X' && mBoard[7] =='X' && mBoard[8] =='X')){
            hasWon=1;

            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;
        }

        else if((mBoard[0] =='X' && mBoard[4] =='X' && mBoard[8] =='X') ||
                (mBoard[2] =='X' && mBoard[4] =='X' && mBoard[6] =='X')){
            hasWon=1;
            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;

        }

        else if((mBoard[0] =='X' && mBoard[3] =='X' && mBoard[6] =='X') ||
                (mBoard[1] =='X' && mBoard[4] =='X' && mBoard[7] =='X') ||
                (mBoard[2] =='X' && mBoard[5] =='X' && mBoard[8] =='X')){
            hasWon=1;
            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;
        }

        else if((mBoard[0] =='O' && mBoard[1] =='O' && mBoard[2] =='O') ||
                (mBoard[3] =='O' && mBoard[4] =='O' && mBoard[5] =='O') ||
                (mBoard[6] =='O' && mBoard[7] =='O' && mBoard[8] =='O')){
            hasWon=2;
            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;
        }
        else if((mBoard[0] =='O' && mBoard[4] =='O' && mBoard[8] =='O') ||
                (mBoard[2] =='O' && mBoard[4] =='O' && mBoard[6] =='O')){
            hasWon=2;
            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;
        }
        else if((mBoard[0] =='O' && mBoard[3] =='O' && mBoard[6] =='O') ||
                (mBoard[1] =='O' && mBoard[4] =='O' && mBoard[7] =='O') ||
                (mBoard[2] =='O' && mBoard[5] =='O' && mBoard[8] =='O')){
            hasWon=2;
            btn_1.setEnabled(false);
            btn_2.setEnabled(false);
            btn_3.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
            btn_7.setEnabled(false);
            btn_8.setEnabled(false);
            btn_9.setEnabled(false);
            counter = 0;
        }
        else if(counter == 9) {
            hasWon = 3;
            counter = 0;
        }
        return hasWon;
    }
}
