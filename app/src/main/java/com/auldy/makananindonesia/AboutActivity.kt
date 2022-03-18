package com.auldy.makananindonesia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ImageButton

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "About Me"

        val btnSendEmail: ImageButton = findViewById(R.id.btn_send_email)
        btnSendEmail.setOnClickListener(this)

        val btnCheckProfile: ImageButton = findViewById(R.id.btn_check_dicoding)
        btnCheckProfile.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_send_email -> {
                val emailDeveloper = "a1211560@bangkit.academy"
                val dialPhoneIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$emailDeveloper"))
                //Uri.parse("mailto:")
                startActivity(dialPhoneIntent)
            }
            R.id.btn_check_dicoding -> {
                val profileDeveloperURL = "https://www.dicoding.com/users/auldyansya"
                val checkDeveloperProfileIntent = Intent(Intent.ACTION_VIEW, Uri.parse(profileDeveloperURL))
                if (checkDeveloperProfileIntent.resolveActivity(packageManager) != null) {
                    startActivity(checkDeveloperProfileIntent)
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}