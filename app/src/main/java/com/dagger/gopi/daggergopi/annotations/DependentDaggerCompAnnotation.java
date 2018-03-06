package com.dagger.gopi.daggergopi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by gopi on 06/03/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DependentDaggerCompAnnotation {

}
