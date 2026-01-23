package biblioteca;

import javax.swing.JOptionPane;

public class MainEstudiantes {
    // crear catalogo y agregar estudiantes

    public static void main(String[] args) {
        
        CarteraEstudiantes cartera = new CarteraEstudiantes();

        cartera.guardar(new Estudiante("Juan", "Pérez", "12345678A"));
        cartera.guardar(new Estudiante("Marta", "Gómez", "87654321B"));
        cartera.guardar(new Estudiante("Luis", "Martínez", "11223344C"));
        cartera.guardar(new Estudiante("Ana", "López", "44332211D"));
        cartera.guardar(new Estudiante("Carlos", "Sánchez", "55667788E"));
        cartera.guardar(new Estudiante("Laura", "Ramírez", "88776655F"));
        cartera.guardar(new Estudiante("Jorge", "Torres", "99887766G"));
        cartera.guardar(new Estudiante("Sofía", "Flores", "66554433H"));
        cartera.guardar(new Estudiante("Miguel", "Rivera", "33445566I"));
        cartera.guardar(new Estudiante("Elena", "Sánchez", "22113344J"));

        boolean continuar = true;
        
        while (continuar) {
            String[] opciones = {
                "1. Ver cantidad de estudiantes",
                "2. Ver lista de estudiantes",
                "3. Ver estudiante aleatorio",
                "4. Ordenar por nombre",
                "5. Buscar por nombre",
                "6. Ordenar por DNI",
                "7. Ver si cartera está vacía",
                "8. Salir"
            };
            
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Selecciona una opción:",
                    "Menú Cartera de Estudiantes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            
            switch (seleccion) {
                case 0: // Cantidad de estudiantes
                    JOptionPane.showMessageDialog(null, 
                            "Total de estudiantes: " + cartera.cantidad(),
                            "Cantidad",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case 1: // Lista de estudiantes
                    StringBuilder lista = new StringBuilder("Lista de estudiantes:\n\n");
                    cartera.imprimir();
                    cartera.ordenarPorNombre();
                    for (int i = 0; i < cartera.cantidad(); i++) {
                        lista.append(cartera.obtenerEstudiante()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, 
                            "Ver consola para la lista de estudiantes",
                            "Lista",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case 2: // Estudiante aleatorio
                    JOptionPane.showMessageDialog(null, 
                            cartera.obtenerEstudiante().toString(),
                            "Estudiante Aleatorio",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case 3: // Ordenar por nombre
                    cartera.ordenarPorNombre();
                    JOptionPane.showMessageDialog(null, 
                            "Cartera ordenada por nombre (ver consola)",
                            "Ordenar por Nombre",
                            JOptionPane.INFORMATION_MESSAGE);
                    cartera.imprimir();
                    break;
                    
                case 4: // Buscar por nombre
                    String nombre = JOptionPane.showInputDialog(null,
                            "Ingresa el nombre a buscar:",
                            "Buscar por Nombre",
                            JOptionPane.QUESTION_MESSAGE);
                    if (nombre != null && !nombre.isEmpty()) {
                        int posicion = cartera.buscarPorNombre(nombre);
                        if (posicion >= 0) {
                            JOptionPane.showMessageDialog(null, 
                                    "Estudiante encontrado en posición: " + posicion,
                                    "Búsqueda",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, 
                                    "Estudiante no encontrado",
                                    "Búsqueda",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    break;
                    
                case 5: // Ordenar por DNI
                    cartera.ordenarPorDNI();
                    JOptionPane.showMessageDialog(null, 
                            "Cartera ordenada por DNI (ver consola)",
                            "Ordenar por DNI",
                            JOptionPane.INFORMATION_MESSAGE);
                    cartera.imprimir();
                    break;
                    
                case 6: // ¿Cartera vacía?
                    String estado = cartera.estaVacia() ? "SÍ está vacía" : "NO está vacía";
                    JOptionPane.showMessageDialog(null, 
                            "La cartera " + estado,
                            "Estado de Cartera",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case 7: // Salir
                    JOptionPane.showMessageDialog(null, 
                            "¡Hasta luego!",
                            "Salir",
                            JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
                    break;
                    
                default:
                    continuar = false;
                    break;
            }
        }
    }
}
