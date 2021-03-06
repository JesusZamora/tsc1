//Servidor - Registrar implementación  
//Tópicos Selectos de Computación I
//Luis Gerardo Montané Jiménez

import PCControlApp.PCControlPackage.*;
import PCControlApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class PCControlServer {

  public static void main(String args[]) {
    try{
      // crear e inicializar
      ORB orb = ORB.init(args, null);
	  
      // obtener referencia del rootpoa y activar el POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // Registar la implementación en el ORB
      PCControlImpl pcControlImpl = new PCControlImpl();
      pcControlImpl.setORB(orb); 

      // Obtener referencia de la invocación objetivo
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(pcControlImpl);
      PCControl href = PCControlHelper.narrow(ref);
	  
      // Obtener el nombre del conexto
      // NameService invoca el nombre del servicio
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Se usa NamingContextExt cuando es parte de la especificación Interoperable Naming Service (INS).
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // Enlazar en objeto
      String name = "PCControl";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("El servidor con el componente CORBA está listo...!");
   
      orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Cerrando servidor...");
	
  }
}
 