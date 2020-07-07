package com.example.daggertest;

import android.app.Application;


public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory()
                .create(this, new AppModule());
        //AppComponent 에서 팩토리를 정의 하였다.

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
