package com.example.daggertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject //의존성을 주입받을 필드에 Inject 에노테이션을 붙인다.
    SharedPreferences sharedPreferences;
    //앱의 간단한 데이터를 저장 관리하는 안드로이드 기본 제공 기능

    @Inject
    String activityName;
    MainActivityComponent component;
    //activityName과 component 필드를 주입받는다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = ((App)getApplication()).getAppComponent()
                .mainActivityComponentBuilder()
                .setModule(new MainActivityModule())
                .setActivity(this)
                .build();
        component.inject(this);
        //App으로부터 AppComponent 인스턴스를 가져와 메인액티비티 컴포넌트 빌더를 제공받아 액티비티 모듈과 인스턴스를 바인딩 하고 메인액티비티 컴포넌트를 생성 후 의존성 주입

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }

    public MainActivityComponent getComponent() {
        return component;
    }
}
