package com.testback.utils;

public class Querys {

    private Querys() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CANDIDATES_BY_TECHNOLOGIES = "SELECT c.NOMBRE,c.APELLIDO,c.TIPO_DNI,c.NUMERO_DNI,c.FECHA_NACIMIENTO,t.NOMBRE_TECNOLOGIA,ct.EXPERIENCIA " +
            "FROM CANDIDATOS_TECNOLOGIAS As ct INNER JOIN CANDIDATOS As c ON ct.ID_CANDIDATO = c.ID_CANDIDATOS " +
            "INNER JOIN TECNOLOGIAS As t ON ct.ID_TECNOLOGIA = t.ID_TECNOLOGIAS WHERE t.NOMBRE_TECNOLOGIA = ?1";
}
