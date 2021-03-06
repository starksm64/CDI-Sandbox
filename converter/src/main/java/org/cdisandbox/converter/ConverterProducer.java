package org.cdisandbox.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author Antoine Sabot-Durand
 */
public class ConverterProducer {


    @Produces
    @Convert
    @Dependent
    Object produceConverter(InjectionPoint ip) {
        String toConvert = ip.getAnnotated().getAnnotation(Convert.class).value();
        Class<?> toType = unwrapType(ip.getAnnotated().getBaseType());

        System.out.println("I have to convert " + toConvert + " to type: " + toType.toString());
        if (toType.equals(Integer.class))
            return new Integer(toConvert);
        else if (toType.equals(StringBuffer.class))
            return new StringBuffer(toConvert);
        else
            return null;

    }

    private <T> Class<T> unwrapType(Type type) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        return (Class<T>) type;
    }
}
