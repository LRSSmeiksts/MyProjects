package com.example.tictactoels


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoels.databinding.ActivityMultiplayerBinding

class MultiplayerActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMultiplayerBinding
    
    private var flag = 0
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMultiplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun clicked(view: View) {
        val currentButton = view as Button
        count++

            if (flag == 0) {
                currentButton.text = "X"
                currentButton.isClickable = false
                binding.turnText.setText("Turn O")
                flag = 1
            } else {
                currentButton.text = "O"
                currentButton.isClickable = false
                binding.turnText.setText("Turn X")
                flag = 0
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
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C1", Toast.LENGTH_LONG).show()
                restartGame()
            // Otrā rinda horizontāli
            } else if (r2C1 == r2C2 && r2C2 == r2C3 && r2C3 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r2C1!", Toast.LENGTH_LONG).show()
                restartGame()
            // Trešā rinda horizontāli
            } else if (r3C1 == r3C2 && r3C2 == r3C3 && r3C3 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r3C1!", Toast.LENGTH_LONG).show()
                restartGame()
            // Pirmā rinda vertikāli
            } else if (r1C1 == r2C1 && r2C1 == r3C1 && r3C1 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C1!", Toast.LENGTH_LONG).show()
                restartGame()
            // Otrā rinda vertikāli
            } else if (r1C2 == r2C2 && r2C2 == r3C2 && r3C2 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C2!", Toast.LENGTH_LONG).show()
                restartGame()
            // Trešā rinda vertikāli
            } else if (r1C3 == r2C3 && r2C3 == r3C3 && r3C3 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C3!", Toast.LENGTH_LONG).show()
                restartGame()
            // Diagonāle no kreisās
            } else if (r1C1 == r2C2 && r2C2 == r3C3 && r3C3 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C1!", Toast.LENGTH_LONG).show()
                restartGame()
            // Diagonāle no labās
            } else if (r1C3 == r2C2 && r2C2 == r3C1 && r3C1 != "") {
                Toast.makeText(this@MultiplayerActivity,"Winner is: $r1C3!", Toast.LENGTH_LONG).show()
                restartGame()
            //Neizsķirts
            } else if (count == 9) {

                Toast.makeText(this@MultiplayerActivity,"DRAW!", Toast.LENGTH_LONG).show()

                restartGame()
            }
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

            binding.turnText.setText("Turn X")

            flag=0
            count=0
        },2000)

    }


}

