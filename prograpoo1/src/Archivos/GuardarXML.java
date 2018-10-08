/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import LogicaNegocios.Chofer;
import LogicaNegocios.Direccion;
import LogicaNegocios.Empresa;
import LogicaNegocios.Licencia;
import LogicaNegocios.Mantenimiento;
import LogicaNegocios.Pasajero;
import LogicaNegocios.Vehiculo;
import LogicaNegocios.Viaje;
import java.text.SimpleDateFormat;

/**
 *
 * @author Javith
 */
public class GuardarXML {

    private Document document = null;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private String ruta;
    private SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");

    public GuardarXML(Vehiculo vehiculo) {
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
            this.guardaConFormato();
            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Pasajero pasajero) {
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
            Element atributo3 = document.createElement("Correo");
            Element atributo4 = document.createElement("Telefono");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(pasajero.getNombre());
            Text valoAtributo1 = document.createTextNode(String.valueOf(pasajero.getCedula()));
            
            Text valoAtributo3 = document.createTextNode(pasajero.getCorreo());
            Text valoAtributo4 = document.createTextNode(String.valueOf(pasajero.getTelefono()));

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0");
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(tipoObjeto);
            //Añadimos el elemento hijo a la raíz
            tipoObjeto.appendChild(atributo0);
            tipoObjeto.appendChild(atributo1);
           
            tipoObjeto.appendChild(atributo3);
            tipoObjeto.appendChild(atributo4);

            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
          
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);
            this.guardaConFormato();
            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Chofer chofer) {
        this.ruta = "BaseDatos//Choferes//Chofer_" + String.valueOf(chofer.getCedula()) + ".xml";
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
            this.guardaConFormato();
            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Licencia licencia) {
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
            Text valoAtributo2 = document.createTextNode(formatoString.format(licencia.getFechaEmision()));
            Text valoAtributo3 = document.createTextNode(formatoString.format(licencia.getFechaExpiracion()));

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
            this.guardaConFormato();
            //Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Direccion direccion) {
        this.ruta = "BaseDatos//Direcciones//Direccion_" + String.valueOf(direccion.getID()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Direccion");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("ID");
            Element atributo1 = document.createElement("Provincia");
            Element atributo2 = document.createElement("Canton");
            Element atributo3 = document.createElement("Distrito");
            Element atributo4 = document.createElement("Segnas");
            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(String.valueOf(direccion.getID()));
            Text valoAtributo1 = document.createTextNode(direccion.getProvincia());
            Text valoAtributo2 = document.createTextNode(direccion.getCanton());
            Text valoAtributo3 = document.createTextNode(direccion.getDistrito());
            Text valoAtributo4 = document.createTextNode(direccion.getSegnas());
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
            this.guardaConFormato();
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Mantenimiento mantenimiento) {
        this.ruta = "BaseDatos//Mantenimientos//mantenimiento_" + String.valueOf(mantenimiento.getIdServicio()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Mantenimiento");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("IDServicio");
            Element atributo1 = document.createElement("FechaInicio");
            Element atributo2 = document.createElement("FechaFin");
            Element atributo3 = document.createElement("MontoPagado");
            Element atributo4 = document.createElement("Detalle");
            Element atributo5 = document.createElement("TipoServicio");
            Element atributo6 = document.createElement("Empresa");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(mantenimiento.getIdServicio());
            Text valoAtributo1 = document.createTextNode(formatoString.format(mantenimiento.getFechaInicio()));
            Text valoAtributo2 = document.createTextNode(formatoString.format((mantenimiento.getFechaFin())));
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
            tipoObjeto.appendChild(atributo4);
            tipoObjeto.appendChild(atributo5);
            tipoObjeto.appendChild(atributo6);
            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);
            atributo5.appendChild(valoAtributo5);
            atributo6.appendChild(valoAtributo6);
            this.guardaConFormato();
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GuardarXML(Empresa empresa) {
        this.ruta = "BaseDatos//Empresas//Empresa_" + String.valueOf(empresa.getNumCedulaJuridica()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Empresa");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("RazonSocial");
            Element atributo1 = document.createElement("CedulaJuridica");
            Element atributo2 = document.createElement("Telefono");
            Element atributo3 = document.createElement("Direccion");

            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(empresa.getRazonSocial());
            Text valoAtributo1 = document.createTextNode(String.valueOf(empresa.getNumCedulaJuridica()));
            Text valoAtributo2 = document.createTextNode(String.valueOf(empresa.getTelefono()));
            Text valoAtributo3 = document.createTextNode(empresa.getDireccion().getID());

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
            this.guardaConFormato();

//Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }
    
    public GuardarXML(Viaje viaje) {
        this.ruta = "BaseDatos//Viajes//viaje_" + String.valueOf(viaje.getID()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element tipoObjeto = document.createElement("Viaje");
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element atributo0 = document.createElement("ID");
            Element atributo1 = document.createElement("Pasajeros");
            Element atributo2 = document.createElement("Solicitud");
            Element atributo3 = document.createElement("inicioDate");
            Element atributo4 = document.createElement("finDate");
            Element atributo5 = document.createElement("Vehiculo");
            Element atributo6 = document.createElement("Chofer");
            Element atributo7 = document.createElement("Estado");
            
            
            String fecha;
            //Ingresamos la info. El color de esta habitación es azul
            Text valoAtributo0 = document.createTextNode(viaje.getID());
            String msg="";
            System.err.println(viaje.getListaPasajeros());
            for( int i=0 ; i < viaje.getListaPasajeros().size() ;i++ ){
                msg += viaje.getListaPasajeros().get(i).getCedula()+";";
            }
            Text valoAtributo1 = document.createTextNode(msg);
            Text valoAtributo2 = document.createTextNode(formatoString.format(viaje.getSolicitud()));
            Text valoAtributo3 = document.createTextNode(formatoString.format(viaje.getInicioDate()));           
            Text valoAtributo4 = document.createTextNode(formatoString.format(viaje.getFinDate()));
            Text valoAtributo5 = document.createTextNode(" ");
            Text valoAtributo6 = document.createTextNode(" ");
            if(!"En Confeccion".equals(viaje.getEstado())){
             valoAtributo5 = document.createTextNode(viaje.getVehiculo().getPlaca());
             valoAtributo6 = document.createTextNode(String.valueOf(viaje.getChofer().getCedula()));
            }
            Text valoAtributo7 = document.createTextNode(viaje.getEstado());
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
            //Añadimos elemento
            atributo0.appendChild(valoAtributo0);
            atributo1.appendChild(valoAtributo1);
            atributo2.appendChild(valoAtributo2);
            atributo3.appendChild(valoAtributo3);
            atributo4.appendChild(valoAtributo4);
            atributo5.appendChild(valoAtributo5);
            atributo6.appendChild(valoAtributo6);
            atributo7.appendChild(valoAtributo7);
            this.guardaConFormato();

//Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }
    
    private void guardaConFormato() {
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
