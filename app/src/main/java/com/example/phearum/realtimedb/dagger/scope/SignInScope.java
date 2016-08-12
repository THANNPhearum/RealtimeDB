package com.example.phearum.realtimedb.dagger.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by phearum on 8/12/16.
 */

@Scope
@Retention(RUNTIME)
public @interface SignInScope {
}
