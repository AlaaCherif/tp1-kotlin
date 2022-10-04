package com.example.tp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WelcomeActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    private var pickImage=100
    private var imageUri: Uri?=null
    lateinit var emailView:TextView
    lateinit var addButton:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        imageView=findViewById(R.id.imageView)
        val email=intent.getStringExtra("email")
        addButton=findViewById(R.id.floatingActionButton)
        addButton.setOnClickListener{
            var gallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery,pickImage)
        }
        emailView=findViewById(R.id.textView)
        emailView.text="Welcome $email"

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK && requestCode==pickImage)
        {
            imageUri=data?.data
            imageView.setImageURI((imageUri))
        }
    }
}