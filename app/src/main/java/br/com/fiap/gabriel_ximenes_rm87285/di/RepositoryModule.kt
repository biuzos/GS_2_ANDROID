package br.com.fiap.gabriel_ximenes_rm87285.di

import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepository
import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserRepo(repository: UserRepositoryImpl): UserRepository
}