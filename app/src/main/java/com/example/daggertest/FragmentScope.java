package com.example.daggertest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
//커스텀 스코프 생성
@Retention(RetentionPolicy.SOURCE)
public @interface FragmentScope {
    //Fragment 스코프
}
