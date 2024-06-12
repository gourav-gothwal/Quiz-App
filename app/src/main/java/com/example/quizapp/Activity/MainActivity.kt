package com.example.quizapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.Domain.QuestionModel
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply(){

            singleBtn.setOnClickListener{
                val intent = Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))


                
                startActivity(intent)
            }
            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener{
                if(it == R.id.Board){
                    startActivity(Intent(this@MainActivity,LeaderActivity::class.java))
                }
            }
        }
    }
    private fun questionList():MutableList<QuestionModel>{
        val question:MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "which planet is largest planet in the solar sysytem?",
                "earth",
                "mars",
                "neptune",
                "jupiter",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                2,
                "which country is largest country in th world?",
                "russia",
                "canada",
                "khalistan",
                "china",
                "a",
                5,
                "q_2",
                null
            )
        )
        question.add(
            QuestionModel(
                3,
                "which of following substance is used as an anti-cancer medication",
                "cheese",
                "lemon juice",
                "cannabis",
                "paspalum",
                "c",
                5,
                "q_3",
                null
            )
        )
        question.add(
            QuestionModel(
                4,
                "which moon is the earth's solar system has an atmosphere?",
                "luna",
                "phobos",
                "venus",
                "none of the above",
                "d",
                5,
                "q_4",
                null
            )
        )
        question.add(
            QuestionModel(
                5,
                "which of the following symbols represents the chemical element with the atomic number 6?",
                "o",
                "h",
                "c",
                "n",
                "c",
                5,
                "q_5",
                null
            )
        )
        question.add(
            QuestionModel(
                6,
                "who is credited with inventing theatre?",
                "shakespeare",
                "arthur miller",
                "ashkouri",
                "ancient greeks",
                "d",
                5,
                "q_6",
                null
            )
        )
        question.add(
            QuestionModel(
                7,
                "which ocean is largest ocean in the world?",
                "pacific ocean",
                "atlantic ocean",
                "indian ocean",
                "arctic ocean",
                "a",
                5,
                "q_7",
                null
            )
        )
        question.add(
            QuestionModel(
                8,
                "which religion is most practiced in the world?",
                "islam christianity judaism",
                "buddhism hinduism sikhism",
                "zoroastrianism yazdanism",
                "taoism shintoism confucianism",
                "a",
                5,
                "q_8",
                null
            )
        )
        question.add(
            QuestionModel(
                9,
                "which continent has most independent countries?",
                "asia",
                "europe",
                "africa",
                "america",
                "c",
                5,
                "q_9",
                null
            )
        )
        question.add(
            QuestionModel(
                10,
                "which ocean has greatest average depth?",
                "pacific ocean",
                "atlantic ocean",
                "indian ocean",
                "southern ocean",
                "d",
                5,
                "q_10",
                null
            )
        )
        return question
    }
}