package com.example.app1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class IntentActivity : AppCompatActivity() {

    lateinit var buttonCamera:Button
    lateinit var buttonMpesa:Button
    lateinit var buttonShare:Button
    private lateinit var buttonEmail:Button
    lateinit var buttonCall:Button
    lateinit var buttonSms:Button
    lateinit var buttonDial:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        buttonSms=findViewById(R.id.btn_sms)
        buttonCamera=findViewById(R.id.btn_camera)
        buttonEmail=findViewById(R.id.btn_email)
        buttonCall=findViewById(R.id.btn_call)
        buttonMpesa=findViewById(R.id.btn_mpesa)
        buttonShare=findViewById(R.id.btn_share)


        buttonSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:YOUR_SMS_NUMBER")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)


        }
        buttonCamera.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)


        }
        buttonEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))


        }
        buttonCall.setOnClickListener {


            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0707640237"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }


        }
        buttonDial.setOnClickListener {
            val phone = "+254 707640237"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)


        }
        buttonMpesa.setOnClickListener {

            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }


        }
        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)

        }
    }
}