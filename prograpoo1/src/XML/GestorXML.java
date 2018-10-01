/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import prograpoo1.Chofer;
import prograpoo1.Licencia;
import prograpoo1.Mantenimiento;
import prograpoo1.Pasajero;
import prograpoo1.Vehiculo;

/**
 *
 * @author Javith
 */
public class GestorXML {

    private Document document = null;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private String ruta;

    public GestorXML(Vehiculo vehiculo) {
        this.ruta = "BaseDatos//Vehiculos//Vehiculo_" + vehiculo.getPlaca() + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Vehiculo");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("Placa");
            Element atributo1 = document.createElement("Color");
            Element atributo2 = document.createElement("Marca");
            Element atributo3 = document.createElement("AgnoFabricacion");
            Element atributo4 = document.createElement("Capacidad");
            Element atributo5 = document.createElement("Kilometraje");
            Element atributo6 = document.createElement("Vin");
            Element atributo7 = document.createElement("Sede");
            Element atributo8 = document.createElement("Estado");
            Element atributo9 = document.createElement("historialMantenimiento");
            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(vehiculo.getPlaca());
            Text valoAtributo1 = document.createTextNode(vehiculo.getColor());
            Text valoAtributo2 = document.createTextNode(vehiculo.getMarca());
            Text valoAtributo3 = document.createTextNode(String.valueOf(vehiculo.getAgnoFabricacion()));
            Text valoAtributo4 = document.createTextNode(String.valueOf(vehiculo.getCapacidad()));
            Text valoAtributo5 = document.createTextNode(String.valueOf(vehiculo.getKilometraje()));
            Text valoAtributo6 = document.createTextNode((vehiculo.getVin()));
            Text valoAtributo7 = document.createTextNode(vehiculo.getSede());
            Text valoAtributo8 = document.createTextNode(String.valueOf(vehiculo.getEstado()));

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
            tipoObjeto.appendChild(atributo2);
            tipoObjeto.appendChild(atributo3);
            tipoObjeto.appendChild(atributo4);
            tipoObjeto.appendChild(atributo5);
            tipoObjeto.appendChild(atributo6);
            tipoObjeto.appendChild(atributo7);
            tipoObjeto.appendChild(atributo8);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);
            atributo5.appendChild(valoAtributo5);
            atributo6.appendChild(valoAtributo6);
            atributo7.appendChild(valoAtributo7);
            atributo8.appendChild(valoAtributo8);

            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GestorXML(Pasajero pasajero) {
        this.ruta = "BaseDatos//Pasajeros//Pasajero_" + String.valueOf(pasajero.getCedula()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Pasajero");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("Nombre");
            Element atributo1 = document.createElement("Cedula");
            Element atributo2 = document.createElement("Direccion");
            Element atributo3 = document.createElement("Correo");
            Element atributo4 = document.createElement("Telefono");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(pasajero.getNombre());
            Text valoAtributo1 = document.createTextNode(String.valueOf(pasajero.getCedula()));
            Text valoAtributo2 = document.createTextNode(pasajero.getDireccion().getID());
            Text valoAtributo3 = document.createTextNode(pasajero.getCorreo());
            Text valoAtributo4 = document.createTextNode(String.valueOf(pasajero.getTelefono()));

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
            tipoObjeto.appendChild(atributo2);
            tipoObjeto.appendChild(atributo3);
            tipoObjeto.appendChild(atributo4);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);

            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GestorXML(Chofer chofer) {
        this.ruta = "BaseDatos//Pasajeros//Pasajero_" + String.valueOf(chofer.getCedula()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Chofer");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("Nombre");
            Element atributo1 = document.createElement("Cedula");
            Element atributo2 = document.createElement("Licencias");
            Element atributo3 = document.createElement("Correo");
            Element atributo4 = document.createElement("Telefono");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(chofer.getNombre());
            Text valoAtributo1 = document.createTextNode(String.valueOf(chofer.getCedula()));

            String msg = "";
            for (int i = 0; chofer.getListaLicencias().size() > i; i++) {
                msg += chofer.getListaLicencias().get(i).getNumero() + ";";
            }
            Text valoAtributo2 = document.createTextNode(msg);

            Text valoAtributo3 = document.createTextNode(chofer.getCorreo());
            Text valoAtributo4 = document.createTextNode(String.valueOf(chofer.getTelefono()));

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
            tipoObjeto.appendChild(atributo2);
            tipoObjeto.appendChild(atributo3);
            tipoObjeto.appendChild(atributo4);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);

            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GestorXML(Licencia licencia) {
        this.ruta = "BaseDatos//Licencias//Licencia_" + String.valueOf(licencia.getNumero()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Licencia");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("Numero");
            Element atributo1 = document.createElement("Tipo");
            Element atributo2 = document.createElement("Emision");
            Element atributo3 = document.createElement("Expiracion");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(String.valueOf(licencia.getNumero()));
            Text valoAtributo1 = document.createTextNode(String.valueOf(licencia.getTipo()));
            Text valoAtributo2 = document.createTextNode(licencia.getFechaEmision().toString());
            Text valoAtributo3 = document.createTextNode(licencia.getFechaExpiracion().toString());

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
            tipoObjeto.appendChild(atributo2);
            tipoObjeto.appendChild(atributo3);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);

            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GestorXML(Mantenimiento mantenimiento) {
        this.ruta = "BaseDatos//Mantenimieto//mantenimiento_" + String.valueOf(mantenimiento.getIdServicio()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("IDServicio");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("FechaInicio");
            Element atributo1 = document.createElement("FechaFin");
            Element atributo2 = document.createElement("MontoPagado");
            Element atributo3 = document.createElement("Detalle");
            Element atributo4 = document.createElement("TipoServicio");
            Element atributo5 = document.createElement("Empresa");
            Element atributo6 = document.createElement("Detalle");
            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(mantenimiento.getIdServicio());
            Text valoAtributo1 = document.createTextNode(mantenimiento.getFechaInicio().toString());
            Text valoAtributo2 = document.createTextNode(mantenimiento.getFechaFin().toString());
            Text valoAtributo3 = document.createTextNode(String.valueOf(mantenimiento.getMontoPagado()));
            Text valoAtributo4 = document.createTextNode(mantenimiento.getDetalle());
            Text valoAtributo5 = document.createTextNode(String.valueOf(mantenimiento.getTipoServicio()));
            Text valoAtributo6 = document.createTextNode(String.valueOf(mantenimiento.getEmpresa().getNumCedulaJuridica()));
//Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
            tipoObjeto.appendChild(atributo2);
            tipoObjeto.appendChild(atributo3);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);

            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public void guardaConFormato() {
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();

            //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
            transFact.setAttribute("indent-number", 3);
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

            //Hacemos la transformación
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource domSource = new DOMSource(this.document);
            trans.transform(domSource, sr);

            //Mostrar información a guardar por consola (opcional)
            //Result console= new StreamResult(System.out);
            //trans.transform(domSource, console);
            try {
                //Creamos fichero para escribir en modo texto
                PrintWriter writer = new PrintWriter(new FileWriter(this.ruta));

                //Escribimos todo el árbol en el fichero
                writer.println(sw.toString());

                //Cerramos el fichero
                writer.close();
            } catch (IOException e) {
            }
        } catch (IllegalArgumentException | TransformerException ex) {
        }
    }

}
