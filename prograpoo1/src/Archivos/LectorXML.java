/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Javith
 */
public class LectorXML {
     private String ruta;
     private String tipo;
     private ArrayList<String> lista;

    public LectorXML() {
        lista= new ArrayList<>();
    }
     
     
     
     public ArrayList<String> getListaElementos(String _ruta,String _tipo) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(_ruta);
            //Obtener el elemento raíz del documento
            Element raiz = documento.getDocumentElement();

            //Obtener la lista de nodos que tienen etiqueta
            NodeList listaEmpleados = raiz.getElementsByTagName(_tipo);
            //Recorrer la lista de empleados
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                //Obtener de la lista un empleado tras otro
                Node empleado = listaEmpleados.item(i);
                

                //Obtener la lista de los datos que contiene ese empleado
                NodeList datosEmpleado = empleado.getChildNodes();
                //Recorrer la lista de los datos que contiene el empleado
                for (int j = 0; j < datosEmpleado.getLength(); j++) {
                    //Obtener de la lista de datos un dato tras otro
                    Node dato = datosEmpleado.item(j);

                    //Comprobar que el dato se trata de un nodo de tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        //Mostrar el nombre del tipo de dato
                        //System.out.print(dato.getNodeName() + ": ");
                        //El valor está contenido en un hijo del nodo Element
                        Node datoContenido = dato.getFirstChild();
                        //Mostrar el valor contenido en el nodo que debe ser de tipo Text
                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            lista.add(datoContenido.getNodeValue());
                        }
                    }
                }
                //Se deja un salto de línea de separación entre cada empleado
                System.out.println();
            }

        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n" + ex.getMessage());
            ex.printStackTrace();
        }
     return lista;   
    }
}
