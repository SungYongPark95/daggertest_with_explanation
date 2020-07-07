package com.example.daggertest;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainActivityModule.class)
//서브 컴포넌트로 상위 컴포넌트의 바인딩된 모든 의존성을 제공받는다. 빌더 또는 팩토리를 반드시 정의해야한다.
//dependencies 를 추가해 상속 받는 경우도 있다.
@ActivityScope
//Application 과 범위를 구분짓도록 사용자 정의 스코프를 사용하였습니다. 동일한 스코프를 가진 바인딩 메서드 들은 생명주기동안 동일한 인스턴스 제공을 보장받을 수 있다.
public interface MainActivityComponent {
    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder{
        Builder setModule(MainActivityModule module);
        @BindsInstance
        //컴포넌트 빌더의 세터 메서드 또는 컴포넌트 팩토리의 매개변수에 붙일 수 있으며, 외부로부터 생성된 인스턴스를 빌더 또는 팩토리에 넘겨줌으로 컴포넌트가 해당 인스턴스를 바인드한다.
        //엑티비티 인스턴스 또한 시스템에 의해서 생성되므로 생명주기 콜백 내에서 서브 멐포넌트 빌드시 바인딩 할 수 있도록 메서드를 통해 인스턴스 바인딩
        Builder setActivity(MainActivity activity);
        MainActivityComponent build();
    }

}
