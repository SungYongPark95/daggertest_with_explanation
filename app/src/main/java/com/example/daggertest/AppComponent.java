package com.example.daggertest;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModule.class)
// App 컴포넌트 생성을 위한 AppComponent 코드, AppModule을 참조하는 컴포넌트
@Singleton
// 최초 고정 메모리 할당, 최초 생성 객체 재사용 - 범위 지정
public interface AppComponent {
//인터페이스 생성
    MainActivityComponent.Builder mainActivityComponentBuilder();
    //Builder 패턴
    void inject(App app);
    //멤버 인젝션 메서드, void를 반환하거나 빌더 패턴처럼 Method Chaining 이 가능한 메서드를 만들기 위해 매개 변수타입을 반환형으로 갖는 메서드를 선

    @Component.Factory
    //컴포넌트 객체, 팩토리를 정의
    interface Factory {
        AppComponent create(
                //create 메서드의 매개 변수로 Application component 의 모듈로 AppModule과 Application 클래스인 App을 받는다.
                @BindsInstance App app,
                AppModule appModule
                //해당 컴포넌트에 인스턴스를 넘겨 바인드시킨다, App 인스턴스는 시스템에 의해서만 생성될 수 있어, App이 생성된 후 팩토리의 BindsInstance 메서드를 통해 오브젝트 그래프에 바인딩 한다.
        );
    }
}
