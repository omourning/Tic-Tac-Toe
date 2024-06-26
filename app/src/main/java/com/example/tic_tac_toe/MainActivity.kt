package com.example.tic_tac_toe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tic_tac_toe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tic_Tac_Toe()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun Tic_Tac_Toe(){

    val turn = arrayOf("X","O")
    var turnNumber = 1
    var board = remember { mutableStateListOf(
        mutableStateListOf("","",""),
        mutableStateListOf("","",""),
        mutableStateListOf("","","")) }
    var winner by remember { mutableStateOf("")}
    var gameOver by remember { mutableStateOf(false) }

    fun winCondition(board: List<List<String>>): String{

        for (i in 0..2) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != "") {
                gameOver = true
                return board[i][0] + " Wins!"
            }
        }

        for (i in 0..2) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != "") {
                gameOver = true
                return board[0][i] + " Wins!"
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ""){
            gameOver = true
            return board[0][0] + " Wins!"
        }

        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ""){
            gameOver = true
            return board[0][2] + " Wins!"
        }

        var tie = true
        for (i in 0..2){
            for (j in 0..2){
                if (board[i][j] == ""){
                    tie = false
                }
            }
        }
        if (tie){
            return "Tie!"
        }

        return ""
    }

    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.padding(36.dp))
        Row {
            Button(
                onClick = {

                    if (board[0][0] == "" && !gameOver){
                        board[0][0] = if(turnNumber % 2 != 0){
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                    Text(text = board[0][0], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[0][1] == "" && !gameOver) {
                        board[0][1] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                Text(text = board[0][1], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[0][2] == "" && !gameOver) {
                        board[0][2] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                Text(text = board[0][2], fontSize = 50.sp)

            }
        }
        Row {
            Button(
                onClick = {

                    if (board[1][0] == "" && !gameOver){
                        board[1][0] = if(turnNumber % 2 != 0){
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                Text(text = board[1][0], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[1][1] == "" && !gameOver) {
                        board[1][1] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                Text(text = board[1][1], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[1][2] == "" && !gameOver) {
                        board[1][2] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)) {

                Text(text = board[1][2], fontSize = 50.sp)

            }
        }
        Row {
            Button(
                onClick = {

                    if (board[2][0] == "" && !gameOver) {
                        board[2][0] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)
            ) {

                Text(text = board[2][0], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[2][1] == "" && !gameOver) {
                        board[2][1] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)
            ) {

                Text(text = board[2][1], fontSize = 50.sp)

            }
            Button(
                onClick = {

                    if (board[2][2] == "" && !gameOver) {
                        board[2][2] = if (turnNumber % 2 != 0) {
                            turn[0]
                        } else {
                            turn[1]
                        }
                        winner = winCondition(board)
                        turnNumber += 1
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(100.dp)
                    .width(100.dp)
            ) {

                Text(text = board[2][2], fontSize = 50.sp)

            }
        }
        
        Spacer(Modifier.padding(30.dp))
        Text(winner, fontSize = 40.sp, fontWeight = FontWeight.Bold)
    }
}