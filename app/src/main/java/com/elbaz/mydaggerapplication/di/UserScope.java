package com.elbaz.mydaggerapplication.di;


import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


import javax.inject.Scope;

/**
 * Created by abk on 01/04/2018.
 */

@Scope
@Retention(RUNTIME)
public @interface UserScope {}
