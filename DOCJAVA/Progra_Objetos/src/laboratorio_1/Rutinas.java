
package laboratorio_1;


public class Rutinas {

    static int precioEstacion(String pEstacion) {
        int precio;
        if ("Verano".equals(pEstacion)) {
            precio = 300;
        } else {
            precio = 100;
        }

        return precio;

    }

    static int prodBotellas(int x, int pCantVacas, int pCantVacasCria) {
        int prodLeche;
        if (x == 1) {
            prodLeche = pCantVacas * 20 + pCantVacasCria * 32;
            return prodLeche;
        }
        if (x == 2) {
            prodLeche = pCantVacas * 15 + pCantVacasCria * 15;

            return prodLeche;
        }

        return 0;
    }

    static double ganancias(String pEstacion, int pCantVacas, int pCantVacasCria, double pArea) {

        double ganancias;
        if ("Primavera".equals(pEstacion)) {

            if (pArea > areaN(1, pCantVacas, pCantVacasCria) * 0.7) {
                ganancias = prodBotellas(1, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;
            } else {
                ganancias = prodBotellas(2, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;
            }
        }
        if ("Verano".equals(pEstacion)) {
            if (pArea > areaN(2, pCantVacas, pCantVacasCria) * 0.7) {
                ganancias = prodBotellas(1, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;
            } else {
                ganancias = prodBotellas(2, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;
            }

        }
        if (("Invierno".equals(pEstacion)
                || ("Oto;o".equals(pEstacion)))) {

            if (pArea > areaN(3, pCantVacas, pCantVacasCria) * 0.7) {
                ganancias = prodBotellas(1, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;

            } else {
                ganancias = prodBotellas(2, pCantVacas, pCantVacasCria) * precioEstacion(pEstacion);
                return ganancias;
            }

        }
        return 0;

    }

    static double areaN(int x, int pCantVacas, int pCantVacasCria) {
        double area;
        if (x == 1) {
            area = pCantVacas * 1.5 + pCantVacasCria * 2;
            return area;
        }
        if (x == 2) {
            area = pCantVacas * 3 + pCantVacasCria * 2;
            return area;
        }
        if (x == 3) {
            area = pCantVacas * 0.5 + pCantVacasCria * 2;
            return area;

        }

        return 0;

    }

}
