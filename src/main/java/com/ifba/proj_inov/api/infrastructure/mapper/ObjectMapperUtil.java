package com.ifba.proj_inov.api.infrastructure.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 * Componente útil para conversão de uma classe para outra.
 */
@Component
public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    static{
        MODEL_MAPPER = new ModelMapper();
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * Pega um objeto de entrada e converte-o para um objeto de saída.
     * @param object O objeto que será convertido para Class<T>.
     * @param clazz O tipo de dado para o qual serão convertidos.
     * @return uma instância de clazz com os dados de object.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Output map(final Input object,
                                      final Class<Output> clazz){

        MODEL_MAPPER.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);


        Output c =  MODEL_MAPPER.map(object, clazz);

        return c;

    }

    /**
     * Copia dados de uma origem para um objeto de destino.
     *
     * @author Giovane Neves.
     * @since V1.0.1
     * @param s O objeto de origem.
     * @param t O objeto de destino.
     * @return instância do objeto de destino com dados do objeto de origem.
     * @param <Source> O tipo de origem.
     * @param <Target> O tipo de saída.
     */
    public <Source, Target> Target map(final Source s, Target t){

        // TODO: Remover logs

        System.out.println("Convertendo source: " + s.toString());
        System.out.print("para t " + t.toString());
        System.out.println();

        try{

            System.out.println("Source possui a seguinte lista de atributos : " + s.getClass().getDeclaredFields().toString());

            // Criando Foreach na lista de atributos da classe Source.
            for(Field sourceField : s.getClass().getDeclaredFields()){

                boolean fieldExists = Arrays.stream(t.getClass().getDeclaredFields())
                        .anyMatch(f -> f.getName().equals(sourceField.getName()));

                System.out.println("O atributo com o nome '" + sourceField.getName() + (fieldExists ? "' existe" : "' não existe"));

                // Salta a iteração caso ambas as classes não possuem o atributo com o mesmo nome.
                if(!fieldExists)
                    continue;

                // Pega o campo do Target que receberá o valor do campo com o mesmo nome em Source.
                Field targetField = t.getClass().getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                targetField.setAccessible(true);

                // Verifica se o atributo atual de Source é um Record.
                if(isRecord(sourceField.getType())){

                    System.out.println("O atributo é um Record agregado!");

                    Object sourceAggregateObject = sourceField.get(s);

                    Object targetAggregateObject = targetField.getType().getDeclaredConstructor().newInstance();
                    // Copia os atributos do Record para os atributos do objeto agregado de mesmo nome com uma chamada recursiva.
                    targetField.set(t, map(sourceAggregateObject, targetAggregateObject));

                    continue;
                }

                System.out.println("O atributo agregado não é um Record!");
                // Atribui o valor do atributo atual de source para o atributo de mesmo nome em Target.
                Object value = sourceField.get(s);

                targetField.set(t, value);

            }

        } catch(Exception ex){

            ex.printStackTrace();

        }


        return t;

    }

    /**
     * Verifica se uma classe é um record ou não.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param clazz A classe a ser verificada.
     * @return 'true' caso a classe seja um record, 'false' caso contrário.
     */
    private boolean isRecord(Class<?> clazz){

        return clazz.isRecord();

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Faz conversão de um objeto de um tipo para o outro no contexto funcional.
     *
     * @param clazz O tipo de para o qual o objeto será convertido.
     * @return ma instância de clazz com os dados do objeto de entrada.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Function<Input, Output> mapFn(final Class<Output> clazz){

        return object -> MODEL_MAPPER.map(object, clazz);

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * Converte uma lista de objetos de um tipo para uma lista de objetos Class<T>.
     * @param objectList A lista de objetos a ser convertida.
     * @param out O tipo de dado para o qual serão convertidos.
     * @return uma lista de objectList convertida para o tipo clazz.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> List<Output> mapAll(final Collection<Input> objectList, Class<Output> out){

        MODEL_MAPPER.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return objectList.stream()
                .map(obj -> MODEL_MAPPER.map(obj, out))
                .toList();
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * @param clazz O tipo para o qual a lista será convertida.
     * @return uma lista de Class<T>.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Function<List<Input>, List<Output>> mapAllFn(final Class<Output> clazz){

        return objectList -> objectList.stream()
                .map(object -> MODEL_MAPPER.map(object, clazz))
                .toList();
    }
}