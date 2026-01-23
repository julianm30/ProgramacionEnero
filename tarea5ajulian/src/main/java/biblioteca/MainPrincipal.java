package biblioteca;

import javax.swing.JOptionPane;

public class MainPrincipal {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {
                    "1. Gestión de Estudiantes",
                    "2. Gestión de Libros",
                    "3. Gestión de Préstamos",
                    "4. Salir"
            };


            //Mensaje con botones
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Selecciona un módulo:",
                    "Sistema de Biblioteca",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0:
                    MainEstudiantes.main(new String[] {});
                    break;
                case 1:
                    MainLibro.main(new String[] {});
                    break;
                case 2:
                    MainPrestamos.main(new String[] {});
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }
}
