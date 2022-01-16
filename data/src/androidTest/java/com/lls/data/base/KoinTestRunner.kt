package com.example.jetnotes.base

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.lls.data.base.JetNotesApplicationTest
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class KoinTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, JetNotesApplicationTest::class.java.name, context)
    }
}