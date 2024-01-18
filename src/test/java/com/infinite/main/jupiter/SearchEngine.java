package com.infinite.main.jupiter;

import com.infinite.main.dictionary.Engine;
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
