package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit = late initialise, when dunno what to initialise
    private lateinit var binding: ActivityMainBinding
    //create an instance of the Contact class
    private var myContact:Contact = Contact("See","018-9570789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.contact=myContact
        binding.buttonDone.setOnClickListener{
                updateName()

        }
    }

    fun updateName(){
        //apply = multiple setter on a single object, like textView.visible & textView.Enable & textView.text
        //binding.contact?.name = ""
        //binding.contact?.phone = "" if not write apply
        binding.apply {
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()

            this.invalidateAll()
        } //? is nullable , invalidateall means refresh the ui show the latest

    }
}
