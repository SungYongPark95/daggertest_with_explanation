package com.example.daggertest;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
//액티비티와 동일하게 서브컴포넌트 정의후 프래그먼트 범위 내에서 의존성 주입이 가능하다.
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface  Builder {
        MainFragmentComponent.Builder setModule(MainFragmentModule module);
        @BindsInstance
        MainFragmentComponent.Builder setFragment(MainFragment fragment);
        MainFragmentComponent build();
    }

//    @Subcomponent.Factory
//    interface Factory {
//        MainFragmentComponent create(@BindsInstance MainFragment fragment,
//                                     MainFragmentModule module);
//    }
}
