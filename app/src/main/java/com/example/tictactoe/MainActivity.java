package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0; // 0 for X, 1 for O
    int count = 0; // To count the moves

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void Check(View view) {
        Button btnCurrent = (Button) view;

        // If the button is already clicked, do nothing
        if (!btnCurrent.getText().toString().equals("")) {
            return;
        }

        count++; // Increment move count

        // Set text based on turn
        if (flag == 0) {
            btnCurrent.setText("X");
            flag = 1;
        } else {
            btnCurrent.setText("O");
            flag = 0;
        }

        // Get current button texts
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();

        // Check for a winner
        if (checkWinner()) {
            return;
        }

        // Check for a draw
        if (count == 9) {
            Toast.makeText(this, "Game is Drawn!", Toast.LENGTH_SHORT).show();
            newGame();
        }
    }

    private boolean checkWinner() {
        // Winning conditions
        if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
            announceWinner(b1);
            return true;
        } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
            announceWinner(b4);
            return true;
        } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
            announceWinner(b7);
            return true;
        } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
            announceWinner(b1);
            return true;
        } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
            announceWinner(b2);
            return true;
        } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
            announceWinner(b3);
            return true;
        } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
            announceWinner(b1);
            return true;
        } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
            announceWinner(b3);
            return true;
        }
        return false;
    }

    private void announceWinner(String winner) {
        Toast.makeText(this, "Winner is: " + winner, Toast.LENGTH_SHORT).show();
        newGame();
    }

    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }

    public void resetGame(View view) {
        newGame();
        Toast.makeText(this, "Game has been reset!", Toast.LENGTH_SHORT).show();
    }
}
