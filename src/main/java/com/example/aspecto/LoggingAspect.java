package com.example.aspecto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.repositorio.*.*(..)) || execution(* com.example.controladores.*.*(..))")
    public void todosLosMetodos() {}

    @Before("todosLosMetodos()")
    public void antesDeEjecutar(JoinPoint joinPoint) {
        System.out.println("========================================");
        System.out.println("Antes de ejecutar: " + joinPoint.getSignature().getName());
        System.out.println("Argumentos: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "todosLosMetodos()", returning = "resultado")
    public void despuesDeRetornar(JoinPoint joinPoint, Object resultado) {
        System.out.println("Método " + joinPoint.getSignature().getName() + " ejecutado con éxito");
        if (resultado != null) {
            System.out.println("Resultado: " + resultado);
        }
    }

    @AfterThrowing(pointcut = "todosLosMetodos()", throwing = "excepcion")
    public void despuesDeExcepcion(JoinPoint joinPoint, Exception excepcion) {
        System.out.println("Excepción en método " + joinPoint.getSignature().getName());
        System.out.println("Excepción: " + excepcion.getMessage());
    }

    @After("todosLosMetodos()")
    public void despuesDeEjecutar(JoinPoint joinPoint) {
        System.out.println("Después de ejecutar: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.repositorio.ProductoRepositorio.actualizarPrecio(..))")
    public Object logAlrededorActualizarPrecio(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=== Iniciando actualización de precio ===");
        Long idProducto = (Long) joinPoint.getArgs()[0];
        double nuevoPrecio = (double) joinPoint.getArgs()[1];

        System.out.println("Actualizando producto ID: " + idProducto);
        System.out.println("Nuevo precio: " + nuevoPrecio);

        long inicio = System.currentTimeMillis();

        Object resultado;
        try {
            resultado = joinPoint.proceed();
            System.out.println("Precio actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar el precio: " + e.getMessage());
            throw e;
        } finally {
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
            System.out.println("=== Operación de actualización finalizada ===");
        }
        return resultado;
    }
}