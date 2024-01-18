package com.infinite.main.jupiter;

import com.infinite.main.dictionary.Engine;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class EngineExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter()
                .getType()
                .isAssignableFrom(Engine.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return extensionContext.getElement()
                .map(element -> element.getAnnotation(SearchEngine.class))
                .map(SearchEngine::engine)
                .orElseThrow(() -> new IllegalStateException("No @Engine annotation found"));
    }
}
