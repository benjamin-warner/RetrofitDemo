package com.benjaminnwarner.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benjaminnwarner.retrofitdemo.ui.photorecords.PhotoRecordsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PhotoRecordsFragment.newInstance())
                .commitNow()
        }
    }
}
