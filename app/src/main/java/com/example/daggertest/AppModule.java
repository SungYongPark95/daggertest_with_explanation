package com.example.daggertest;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainActivityComponent.class)
//Module, 의존성을 제공하는 클래스
public class AppModule {

    @Provides
    //의존성을 제공하는 메서드
    @Singleton
    //최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴
    //애플리케이션 생명주기 동안 싱글턴으로 취급할 SharedPreference 재공, 매번 제공하고 싶다면 제거하면 된다.
    SharedPreferences provideSharedPreferences(App app){
        return app.getSharedPreferences(
                "default",
                Context.MODE_PRIVATE
        );
    }
}
