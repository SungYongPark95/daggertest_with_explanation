package com.example.daggertest;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    String provideActivityName(){
        return MainActivity.class.getSimpleName();
    }
}
