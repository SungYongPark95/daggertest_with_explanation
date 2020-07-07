package com.example.daggertest;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.fragment.app.Fragment;

import java.util.Random;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {

    @Provides
    @FragmentScope
    Integer provideInt() {
        return  new Random().nextInt();
    }
}


