/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Correo {
    private String Usuario ;
    private String Contrasena;

    public Correo(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }
    public Correo() {
        this.Usuario = "tareaprogra00@gmail.com";
        this.Contrasena = "Tarea12345";
    }
 public void enviarGmail(String subject, String msg, String usuario) throws MessagingException{

     
// Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
  Properties props = new Properties();

  // Nombre del host de correo, es smtp.gmail.com
  props.setProperty("mail.smtp.host", "smtp.gmail.com");

  // TLS si está disponible
  props.setProperty("mail.smtp.starttls.enable", "true");

  // Puerto de gmail para envio de correos
  props.setProperty("mail.smtp.port","587");

  // Nombre del usuario
  props.setProperty("mail.smtp.user", Usuario);

  // Si requiere o no usuario y password para conectarse.
  props.setProperty("mail.smtp.auth", "true");

  Session session = Session.getDefaultInstance(props);

  // Para obtener un log de salida más extenso
  session.setDebug(true);

        MimeMessage message = new MimeMessage(session);

    // Quien envia el correo
    message.setFrom(new InternetAddress(Usuario));

    // A quien va dirigido
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario));

    message.setSubject(subject);
    message.setText(msg);
    
    
    Transport t = session.getTransport("smtp");

  //Aqui usuario y password de gmail
    t.connect(Usuario,Contrasena);
    t.sendMessage(message,message.getAllRecipients());
    t.close();
    
}


}