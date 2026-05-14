package co.edu.demopruebas;

public class ValidadorNotas {

    public boolean esAprobado(double nota) {
        validarRango(nota);
        return nota >= 3.0;
    }

    public String clasificarNota(double nota) {
        validarRango(nota);

        if (nota < 3.0) {
            return "Reprobado";
        } else if (nota < 4.0) {
            return "Aprobado";
        } else {
            return "Sobresaliente";
        }
    }

    public void validarRango(double nota) {
        if (nota < 0.0 || nota > 5.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }
    }
}