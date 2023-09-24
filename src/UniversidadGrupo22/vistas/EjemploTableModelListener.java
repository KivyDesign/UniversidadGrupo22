package UniversidadGrupo22.vistas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Ejemplo de uso del TableModelListener. Una tabla de 3 filas y 3 columnas con
 * numeros, de forma que la ultima columna es la suma de las dos columnas
 * anteriores y la ultima fila es la suma de las dos filas anteriores. Solo son
 * editables las celdas que no son de la ultima fila ni de la ultima columna. Se
 * usa TableModelListener para actualizar las sumas cuando el usuario modifica
 * el valor de alguna de las celdas.
 *
 *
 * @author Guido Sosa
 */
public class EjemploTableModelListener {

    public static void main(String[] args) {
        new EjemploTableModelListener();
    }

    public EjemploTableModelListener() {
        JTable tabla = creaVentanaConTabla();
        anadeListenerAlModelo(tabla);
    }

    /**
     * Se añade el listener al modelo y se llama a actualizaSumas(), que es el
     * método encargado de actualizar las sumas de las celdas no editables.
     */
    private void anadeListenerAlModelo(JTable tabla) {
        tabla.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent evento) {
                actualizaSumas(evento);
            }
        });
    }

    /**
     * Cuando cambie el valor de alguna celda, el JTable avisará a los listener
     * y nuestro listener llamará a este método.
     */
    protected void actualizaSumas(TableModelEvent evento) {
        // Solo se trata el evento UPDATE, correspondiente al cambio de valor
        // de una celda.
        if (evento.getType() == TableModelEvent.UPDATE) {

            // Se obtiene el modelo de la tabla y la fila/columna que han cambiado.
            TableModel modelo = ((TableModel) (evento.getSource()));
            int fila = evento.getFirstRow();
            int columna = evento.getColumn();

            // Los cambios en la ultima fila y columna se ignoran.
            // Este return es necesario porque cuando nuestro codigo modifique
            // los valores de las sumas en esta fila y columna, saltara nuevamente
            // el evento, metiendonos en un bucle recursivo de llamadas a este
            // metodo.
            if (fila == 2 || columna == 2) {
                return;
            }

            try {
                // Se actualiza la suma en la ultima columna de la fila que ha
                // cambiado.
                double valorPrimeraColumna = ((Number) modelo.getValueAt(fila,
                        0)).doubleValue();
                double valorSegundaColumna = ((Number) modelo.getValueAt(fila,
                        1)).doubleValue();
                modelo.setValueAt(valorPrimeraColumna + valorSegundaColumna,
                        fila, 2);

                // Se actualiza la suma en la ultima fila de la columna que ha
                // cambiado.
                double valorPrimeraFila = ((Number) modelo.getValueAt(0,
                        columna)).doubleValue();
                double valorSegundaFila = ((Number) modelo.getValueAt(1,
                        columna)).doubleValue();
                modelo.setValueAt(valorPrimeraFila + valorSegundaFila, 2,
                        columna);

                // Se actualiza la ultima fila y columna, que tiene la suma total
                // de todas las celdas.
                double valorPrimeraFilaUltimaColumna = ((Number) modelo
                        .getValueAt(0, 2)).doubleValue();
                double valorSegundaFilaUltimaColumna = ((Number) modelo
                        .getValueAt(1, 2)).doubleValue();
                modelo.setValueAt(valorPrimeraFilaUltimaColumna
                        + valorSegundaFilaUltimaColumna, 2, 2);

            } catch (NullPointerException e) {
                // La celda que ha cambiado esta vacia.
            }
        }
    }

    private JTable creaVentanaConTabla() {
        JFrame ventana = new JFrame();
        JTable tabla = new JTable(new MiModelo());
        tabla.setDefaultRenderer(Double.class, new MiRender());
        JScrollPane scroll = new JScrollPane(tabla);
        ventana.getContentPane().add(scroll);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        return tabla;
    }

    /**
     * Nuestro modelo de datos.
     *
     * @author Chuidiang
     */
    class MiModelo extends DefaultTableModel {

        /**
         * Se carga con tres filas y tres columnas con numeros.
         */
        public MiModelo() {
            super(new Object[][]{{1, 1, 2}, {1, 1, 2}, {2, 2, 4}},
                    new String[]{"A", "B", "C"});
        }

        /**
         * El contenido de las celdas sera Double.
         */
        @Override
        public Class<?> getColumnClass(int arg0) {
            return Double.class;
        }

        /**
         * Se hacen no editables la ultima fila y columna. Es decir, es editable
         * si no es la fila 2 ni la columna 2.
         */
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return fila < 2 && columna < 2;
        }
    }

    /**
     * Un Render para mostrar de un color distinto las celdas no editables.
     *
     * @author Chuidiang
     */
    class MiRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            // Se llama al metodo de la clase padre para que ponga bien los
            // colores de celda con/sin foco, celda de/seleccionada, dibuje el 
            // valor de la celda, etc.
            super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);

            // Y nosotros solo cambiamos el color de fondo.
            if (row == 2 || column == 2) {
                // Si es ultima fila o columna, es decir, celda no editable,
                // color amarillo.
                setBackground(Color.YELLOW);
            } else {
                // Si es editable, color blanco.
                setBackground(Color.WHITE);
            }

            // DefaultTableCellRenderer hereda de JLabel y es este el JLabel que
            // devolvemos.
            return this;
        }
    }

}
