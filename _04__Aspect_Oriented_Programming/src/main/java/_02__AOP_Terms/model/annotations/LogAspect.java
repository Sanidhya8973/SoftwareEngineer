package _02__AOP_Terms.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAspect {

}

/*
-------------------------------
@Retention(RetentionPolicy.___)
-------------------------------
1) CLASS
2) RUNTIME
3) SOURCE
-------------------------------

---------------------
@Target(ElementType.)
---------------------
1) PACKAGE
2) MODULE
3) CONSTRUCTOR
4) LOCAL_VARIABLE
5) FIELD
6) METHOD
7) PARAMETER
8) RECORD_COMPONENT
9) TYPE
10) TYPE_PARAMETER
11) TYPE_USE
---------------------
 */