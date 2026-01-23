package biblioteca;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class MainPrestamos {
    public static void main(String[] args) {
        
        // Crear estudiantes
        Estudiante est1 = new Estudiante("Juan", "Pérez", "12345678A");
        Estudiante est2 = new Estudiante("Marta", "Gómez", "87654321B");
        Estudiante est3 = new Estudiante("Luis", "Martínez", "11223344C");

        // Crear libros
        Libro lib1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "1111", Genero.NOVELA, true);
        Libro lib2 = new Libro("Don Quijote", "Miguel de Cervantes", 1605, "2222", Genero.NOVELA, true);
        Libro lib3 = new Libro("1984", "George Orwell", 1949, "4444", Genero.FICCION, true);

        // Crear lista de préstamos
        ListaPrestamos listaPrestamos = new ListaPrestamos();

        // Crear y agregar préstamos
        Prestamo prest1 = new Prestamo(1, est1, lib1, LocalDate.now().minusDays(20));
        Prestamo prest2 = new Prestamo(2, est2, lib2, LocalDate.now().minusDays(10));
        Prestamo prest3 = new Prestamo(3, est3, lib3, LocalDate.now().minusDays(5));
        Prestamo prest4 = new Prestamo(4, est1, lib2, LocalDate.now());

        listaPrestamos.guardarPrestamo(prest1);
        listaPrestamos.guardarPrestamo(prest2);
        listaPrestamos.guardarPrestamo(prest3);
        listaPrestamos.guardarPrestamo(prest4);

        System.out.println("=== PRÉSTAMOS INICIALES ===");
        listaPrestamos.imprimir();
        System.out.println("\nTotal de préstamos: " + listaPrestamos.cantidad());

        boolean continuar = true;
        
        while (continuar) {
            String[] opciones = {
                    "1. Guardar nuevo préstamo",
                    "2. Borrar préstamo por posición",
                    "3. Buscar préstamo por ID",
                    "4. Buscar préstamos por estudiante",
                    "5. Ver préstamos vencidos",
                    "6. Ver todos los préstamos",
                    "7. Ordenar por ID",
                    "8. Modificar libro de un préstamo",
                    "9. Salir"
            };
            
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Selecciona una opción:",
                    "Menú de Lista de Préstamos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            
            switch (seleccion) {
                case 0:
                    guardarPrestamo(listaPrestamos, est1, est2, est3, lib1, lib2, lib3);
                    break;
                case 1:
                    borrarPrestamo(listaPrestamos);
                    break;
                case 2:
                    buscarPorID(listaPrestamos);
                    break;
                case 3:
                    buscarPrestamosEstudiante(listaPrestamos, est1, est2, est3);
                    break;
                case 4:
                    verPrestamosVencidos(listaPrestamos);
                    break;
                case 5:
                    verTodosPrestamos(listaPrestamos);
                    break;
                case 6:
                    ordenarPorID(listaPrestamos);
                    break;
                case 7:
                    modificarLibroPrestamo(listaPrestamos, lib1, lib2, lib3);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }

    private static void guardarPrestamo(ListaPrestamos listaPrestamos, Estudiante est1, Estudiante est2, Estudiante est3, Libro lib1, Libro lib2, Libro lib3) {
        try {
            String idStr = JOptionPane.showInputDialog("Ingresa el ID del préstamo:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr);

            String[] estudiantes = {est1.getNombre(), est2.getNombre(), est3.getNombre()};
            int indexEst = JOptionPane.showOptionDialog(null, "Selecciona el estudiante:", "Estudiante",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, estudiantes, estudiantes[0]);
            if (indexEst < 0) return;

            String[] libros = {lib1.getTitulo(), lib2.getTitulo(), lib3.getTitulo()};
            int indexLib = JOptionPane.showOptionDialog(null, "Selecciona el libro:", "Libro",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, libros, libros[0]);
            if (indexLib < 0) return;

            Estudiante estSeleccionado = new Estudiante[]{est1, est2, est3}[indexEst];
            Libro libSeleccionado = new Libro[]{lib1, lib2, lib3}[indexLib];

            Prestamo nuevoPrestamo = new Prestamo(id, estSeleccionado, libSeleccionado);
            listaPrestamos.guardarPrestamo(nuevoPrestamo);
            JOptionPane.showMessageDialog(null, "✓ Préstamo guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void borrarPrestamo(ListaPrestamos listaPrestamos) {
        try {
            String posStr = JOptionPane.showInputDialog("Ingresa la posición del préstamo a borrar:");
            if (posStr == null) return;
            int pos = Integer.parseInt(posStr);

            listaPrestamos.borrarPrestamo(pos);
            JOptionPane.showMessageDialog(null, "✓ Préstamo borrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Posición inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void modificarLibroPrestamo(ListaPrestamos listaPrestamos, Libro lib1, Libro lib2, Libro lib3) {
        try {
            String idStr = JOptionPane.showInputDialog("Ingresa el ID del préstamo a modificar:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr);

            String[] libros = {lib1.getTitulo(), lib2.getTitulo(), lib3.getTitulo()};
            int indexLib = JOptionPane.showOptionDialog(null, "Selecciona el nuevo libro:", "Libro",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, libros, libros[0]);
            if (indexLib < 0) return;

            Libro libSeleccionado = new Libro[]{lib1, lib2, lib3}[indexLib];
            listaPrestamos.modificarLibroPrestamo(id, libSeleccionado);
            JOptionPane.showMessageDialog(null, "✓ Libro del préstamo modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarPorID(ListaPrestamos listaPrestamos) {
        try {
            String idStr = JOptionPane.showInputDialog("Ingresa el ID del préstamo a buscar:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr);

            Prestamo prestamo = listaPrestamos.buscarPrestamoID(id);
            if (prestamo != null) {
                JOptionPane.showMessageDialog(null, "Préstamo encontrado:\n" + prestamo, "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Préstamo no encontrado", "No Encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarPrestamosEstudiante(ListaPrestamos listaPrestamos, Estudiante est1, Estudiante est2, Estudiante est3) {
        String[] estudiantes = {est1.getNombre(), est2.getNombre(), est3.getNombre()};
        int indexEst = JOptionPane.showOptionDialog(null, "Selecciona el estudiante:", "Estudiante",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, estudiantes, estudiantes[0]);
        if (indexEst < 0) return;

        Estudiante estSeleccionado = new Estudiante[]{est1, est2, est3}[indexEst];
        var prestamosEst = listaPrestamos.buscarPrestamosEstudiante(estSeleccionado);

        if (!prestamosEst.isEmpty()) {
            StringBuilder sb = new StringBuilder("Préstamos del estudiante '" + estSeleccionado.getNombre() + "':\n\n");
            for (Prestamo p : prestamosEst) {
                sb.append(p).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay préstamos de este estudiante", "No Encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void verPrestamosVencidos(ListaPrestamos listaPrestamos) {
        var prestamosVencidos = listaPrestamos.buscarPrestamosVencidos();

        if (!prestamosVencidos.isEmpty()) {
            StringBuilder sb = new StringBuilder("Préstamos vencidos:\n\n");
            for (Prestamo p : prestamosVencidos) {
                sb.append(p).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Préstamos Vencidos", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay préstamos vencidos", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void ordenarPorID(ListaPrestamos listaPrestamos) {
        listaPrestamos.ordenarPorID();
        System.out.println("=== PRÉSTAMOS ORDENADOS POR ID ===");
        listaPrestamos.imprimir();
        JOptionPane.showMessageDialog(null, "Préstamos ordenados por ID (ver consola)", "Ordenamiento", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void verTodosPrestamos(ListaPrestamos listaPrestamos) {
        if (listaPrestamos.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay préstamos", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("========== TODOS LOS PRÉSTAMOS ==========\n\n");
        for (int i = 0; i < listaPrestamos.cantidad(); i++) {
            sb.append(String.format("[Posición %d] %s\n\n", i, listaPrestamos.obtener(i)));
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Préstamos", JOptionPane.INFORMATION_MESSAGE);
    }
}
