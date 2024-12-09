package com.example.part3.chapter7.di

import com.example.part3.chapter7.data.dao.ContentDao
import com.example.part3.chapter7.repository.ContentRepository
import com.example.part3.chapter7.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao): ContentRepository = ContentRepositoryImpl(contentDao)

}