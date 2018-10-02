/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

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
import prograpoo1.Chofer;
import prograpoo1.Direccion;
import prograpoo1.Empresa;
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
    private ArrayList<String> lista =new ArrayList<>();
    
    public GestorXML(String r)
    {
        this.ruta=r;
    }
    
    public GestorXML(Vehiculo vehiculo) {
        this.ruta = "BaseDatos//Vehiculos//Vehiculo_" + vehiculo.getPlaca() + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "Vehiculo", null);

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
            document = implementation.createDocument(null, "Pasajero", null);

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
        this.ruta = "BaseDatos//Choferes//Chofer_" + String.valueOf(chofer.getCedula()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "Chofer", null);

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

    public GestorXML(Direccion direccion) {
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
            atributo3.appendChild(valoAtributo4);
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
//Añadimos valor
        } catch (ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e);
        }
    }

    public GestorXML(Empresa empresa) {
        this.ruta = "BaseDatos//Empresa//Empresa_" + String.valueOf(empresa.getNumCedulaJuridica()) + ".xml";
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "Empresa", null);

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

    public void CargarXML(String ruta) throws SAXException {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(ruta);
            //Obtener el elemento raíz del documento
            
            Element raiz = documento.getDocumentElement();

            //Obtener la lista de nodos que tienen etiqueta "EMPLEADO"
            NodeList listaAtributos = raiz.getElementsByTagName(raiz.getTagName());
            //Recorrer la lista de empleados
            for (int i = 0; i < listaAtributos.getLength(); i++) {
                //Obtener de la lista un empleado tras otro
                Node objeto = listaAtributos.item(i);

                //Obtener la lista de los datos que contiene ese empleado
                NodeList datosEmpleado = objeto.getChildNodes();
                //Recorrer la lista de los datos que contiene el empleado
                for (int j = 0; j < datosEmpleado.getLength(); j++) {
                    //Obtener de la lista de datos un dato tras otro
                    Node dato = datosEmpleado.item(j);

                    //Comprobar que el dato se trata de un nodo de tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        //Mostrar el nombre del tipo de dato
                        System.out.print(dato.getNodeName() + ": ");
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
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public String getTitulo() {
        Element raiz = document.getDocumentElement();
       

        return "2";
    }
}
