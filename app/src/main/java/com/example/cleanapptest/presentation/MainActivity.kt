package com.example.cleanapptest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanapptest.R
import com.example.cleanapptest.domain.models.SaveUserNameParam
import com.example.cleanapptest.domain.models.UserName
import com.example.cleanapptest.domain.usecase.GetUserNameUseCase
import com.example.cleanapptest.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    //создаем объекты, подключаем usecase в активити
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val getButton = findViewById<Button>(R.id.getButton)
        val saveButton = findViewById<Button>(R.id.saveButton)

        getButton.setOnClickListener {
            //обрабатываем клик на кнопку Get Data

            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"


        }

        saveButton.setOnClickListener {

            //обрабатываем клик на кнопку Save Data

            //берем данные из поля ввода
            val text = dataEditText.text.toString()
            //создаем объект, кладем информацию из поля ввода
            val params = SaveUserNameParam(name = text)
            //передаем этот объект в юзкейс
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Saved result = $result"

        }


    }
}