package com.example.tictactoels


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoels.databinding.ActivitySingleplayerBinding



class SingleplayerActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySingleplayerBinding


    private var count = 0
    private var computerMove = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingleplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun aiClick(){
        binding.turnText.setText("Turn X")

        val buttons = listOf(
            binding.r1c1,
            binding.r1c2,
            binding.r1c3,
            binding.r2c1,
            binding.r2c2,
            binding.r2c3,
            binding.r3c1,
            binding.r3c2,
            binding.r3c3
        ).filter { it.text.isEmpty() }

        if(computerMove == 1){
            count ++
            var rndButton = buttons.random()
            rndButton.text = "O"
            rndButton.isClickable = false
            computerMove = 0

        }
    }

    fun clicked(view: View) {
        binding.turnText.setText("Turn X")
        Thread.sleep(1500)
        val currentButton = view as Button

        if(computerMove == 0) {

            count ++
            currentButton.text = "X"
            currentButton.isClickable = false
            computerMove = 1

        }

        val r1C1 = binding.r1c1.text.toString()
        val r1C2 = binding.r1c2.text.toString()
        val r1C3 = binding.r1c3.text.toString()

        val r2C1 = binding.r2c1.text.toString()
        val r2C2 = binding.r2c2.text.toString()
        val r2C3 = binding.r2c3.text.toString()

        val r3C1 = binding.r3c1.text.toString()
        val r3C2 = binding.r3c2.text.toString()
        val r3C3 = binding.r3c3.text.toString()

        // Pirmā rinda horizontāli
        if (r1C1 == r1C2 && r1C2 == r1C3 && r1C3 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C1", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Otrā rinda horizontāli
        } else if (r2C1 == r2C2 && r2C2 == r2C3 && r2C3 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r2C1!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Trešā rinda horizontāli
        } else if (r3C1 == r3C2 && r3C2 == r3C3 && r3C3 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r3C1!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Pirmā rinda vertikāli
        } else if (r1C1 == r2C1 && r2C1 == r3C1 && r3C1 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C1!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Otrā rinda vertikāli
        } else if (r1C2 == r2C2 && r2C2 == r3C2 && r3C2 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C2!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Trešā rinda vertikāli
        } else if (r1C3 == r2C3 && r2C3 == r3C3 && r3C3 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C3!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Diagonāle no kreisās
        } else if (r1C1 == r2C2 && r2C2 == r3C3 && r3C3 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C1!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            // Diagonāle no labās
        } else if (r1C3 == r2C2 && r2C2 == r3C1 && r3C1 != "") {
            Toast.makeText(this@SingleplayerActivity,"Winner is: $r1C3!", Toast.LENGTH_LONG).show()
            restartGame()
            return
            //Neizsķirts
        } else if (count == 9) {

            Toast.makeText(this@SingleplayerActivity,"DRAW!", Toast.LENGTH_LONG).show()
            restartGame()
            return
        }
        aiClick()
    }

    private fun restartGame(){
        Handler(Looper.getMainLooper()).postDelayed({
            binding.r1c1.text = ""
            binding.r1c1.isClickable=true
            binding.r1c2.text = ""
            binding.r1c2.isClickable=true
            binding.r1c3.text = ""
            binding.r1c3.isClickable=true

            binding.r2c1.text = ""
            binding.r2c1.isClickable=true
            binding.r2c2.text = ""
            binding.r2c2.isClickable=true
            binding.r2c3.text = ""
            binding.r2c3.isClickable=true

            binding.r3c1.text = ""
            binding.r3c1.isClickable=true
            binding.r3c2.text = ""
            binding.r3c2.isClickable=true
            binding.r3c3.text = ""
            binding.r3c3.isClickable=true

            count=0
        },2000)

    }


}

