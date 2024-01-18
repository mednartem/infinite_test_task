package com.infinite.main.jupiter.annotation;

import com.infinite.main.dictionary.Engine;
import com.infinite.main.jupiter.extension.EngineExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(EngineExtension.class)
public @interface SearchEngine {
    Engine engine();
}
