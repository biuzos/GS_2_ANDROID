package br.com.fiap.gabriel_ximenes_rm87285.di

import android.content.Context
import androidx.room.Room
import br.com.fiap.gabriel_ximenes_rm87285.db.UsersDao
import br.com.fiap.gabriel_ximenes_rm87285.db.UsersDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): UsersDataBase {
        return Room.databaseBuilder(
            appContext,
            UsersDataBase::class.java,
            "users.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun providesUsersDao(db: UsersDataBase): UsersDao = db.getUsersDao()
}