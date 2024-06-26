import java.util.Scanner;

public class ArticulosDescuentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadArticulos, contadorArticulos = 0, contadorDescuento0 = 0, contadorDescuento5 = 0, contadorDescuento8 = 0, contadorDescuento10Mas = 0;
        double precioArticulo, valorPagar, descuento, totalVentas = 0.0;

        System.out.print("Ingrese la cantidad de artículos: ");
        cantidadArticulos = scanner.nextInt();

        for (int i = 0; i < cantidadArticulos; i++) {
            System.out.print("Ingrese el nombre del artículo: ");
            String nombreArticulo = scanner.nextLine();
            scanner.nextLine(); // Consumir salto de línea

            System.out.print("Ingrese el precio del artículo: ");
            precioArticulo = scanner.nextDouble();

            descuento = determinarDescuento(precioArticulo);

            valorPagar = precioArticulo * (1 - descuento);

            System.out.println("\nNombre del artículo: " + nombreArticulo);
            System.out.println("Precio original: " + precioArticulo);
            System.out.println("Descuento aplicado: " + descuento * 100 + "%");
            System.out.println("Valor a pagar: " + valorPagar);

            totalVentas += precioArticulo;
            contadorArticulos++;

            actualizarContadoresDescuento(descuento, contadorDescuento0, contadorDescuento5, contadorDescuento8, contadorDescuento10Mas);
        }

        System.out.println("\nTotales");
        System.out.println("Cantidad de artículos procesados: " + contadorArticulos);
        System.out.println("Cantidad de artículos con 0% de descuento: " + contadorDescuento0);
        System.out.println("Cantidad de artículos con 5% de descuento: " + contadorDescuento5);
        System.out.println("Cantidad de artículos con 8% de descuento: " + contadorDescuento8);
        System.out.println("Cantidad de artículos con 10% o más de descuento: " + contadorDescuento10Mas);
        System.out.println("Valor total en ventas: " + totalVentas);
    }

    public static double determinarDescuento(double precioArticulo) {
        if (precioArticulo >= 300000) {
            return 0.1;
        } else if (precioArticulo >= 200000) {
            return 0.08;
        } else if (precioArticulo >= 100000) {
            return 0.05;
        } else {
            return 0;
        }
    }

    public static void actualizarContadoresDescuento(double descuento, int contadorDescuento0, int contadorDescuento5, int contadorDescuento8, int contadorDescuento10Mas) {
        switch ((int) (descuento * 10)) {
            case 0:
                contadorDescuento0++;
                break;
            case 5:
                contadorDescuento5++;
                break;
            case 8:
                contadorDescuento8++;
                break;
            default:
                contadorDescuento10Mas++;
        }
    }
}
