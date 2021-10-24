package com.example.jetnotes.base

import com.example.jetnotes.JetNotesApplication
import com.example.jetnotes.di.appModulesMock
import com.example.jetnotes.di.dataModulesMock
import com.example.jetnotes.di.domainModulesMock
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class JetNotesApplicationTest : JetNotesApplication() {

    override fun provideModules() = appModulesMock + domainModulesMock + dataModulesMock
}