package com.example.kanwal_laptop.layout_lecture_04

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*

class LayoutExample2 : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var userPassword: EditText
    private lateinit var noneRadioButton: RadioButton
    private lateinit var donRadioButton: RadioButton
    private lateinit var leoRadioButton: RadioButton
    private lateinit var mikeRadioButton: RadioButton
    private lateinit var raphRadioButton: RadioButton
    private lateinit var displayCharacter : ImageView
    private var tmntString =""

    private lateinit var rateTMNT: RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_example)

        noneRadioButton = findViewById(R.id.none_rb)
        noneRadioButton.isChecked = true

        displayCharacter = findViewById(R.id.display_tmnt_character)
        displayCharacter.visibility =View.GONE

        rateTMNT = findViewById(R.id.rate_tmnt)
        rateTMNT.setOnRatingBarChangeListener { _, rating, _ ->
            rateTMNT.rating = rating
        }

//        ratingBar.onRatingBarChangeListener = OnRatingBarChangeListener { _, rating, _ -> ratingBar.rating=rating  }
    }

    fun okButtonPressed(view : View){
        userName = findViewById(R.id.UserName)
        userPassword = findViewById(R.id.UserPwd)
        if(userName.text.toString().trim().isEmpty() || userPassword.text.toString().trim().isEmpty()){
            Toast.makeText(this@LayoutExample2, "Please enter username and password",
                                Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@LayoutExample2, "User Name: ${userName.text} \n" +
                    "Password : ${userPassword.text} \n" +
                    "Character: $tmntString \n" +
                    "Rating: ${rateTMNT.rating}",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun tmntSelectionFunction(view : View){
        donRadioButton = findViewById(R.id.don_rb)
        leoRadioButton =findViewById(R.id.leo_rb)
        mikeRadioButton = findViewById(R.id.mike_rb)
        raphRadioButton = findViewById(R.id.raph_rb)
        var id :Int = 0

        if(donRadioButton.isChecked || leoRadioButton.isChecked || mikeRadioButton.isChecked
                        || raphRadioButton.isChecked){
            displayCharacter.visibility = View.VISIBLE
        }

        when(view){
            donRadioButton->{
                id =R.drawable.tmntdon
                tmntString = donRadioButton.text.toString()
            }
            leoRadioButton->{
                id=R.drawable.tmntleo
                tmntString = leoRadioButton.text.toString()
            }
            mikeRadioButton->{
                id = R.drawable.tmntmike
                tmntString = mikeRadioButton.text.toString()
            }
            raphRadioButton->{
                id = R.drawable.tmntraph
                tmntString = raphRadioButton.text.toString()
            }
            else->{
                displayCharacter.visibility =View.GONE
                tmntString = noneRadioButton.text.toString()
            }
        }
        displayCharacter.setImageResource(id)
    }
}