package net.atos.cedre.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by abk on 01/04/2018.
 */

@Scope
@Retention(RUNTIME)
public @interface SUserScope {}
