package HolaApp;


/**
* HolaApp/HolaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hola.idl
* lunes 10 de febrero de 2014 07:53:33 AM CST
*/

public abstract class HolaPOA extends org.omg.PortableServer.Servant
 implements HolaApp.HolaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("saludar", new java.lang.Integer (0));
    _methods.put ("sumar", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // HolaApp/Hola/saludar
       {
         String $result = null;
         $result = this.saludar ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // HolaApp/Hola/sumar
       {
         int x = in.read_long ();
         int y = in.read_long ();
         int $result = (int)0;
         $result = this.sumar (x, y);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:HolaApp/Hola:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Hola _this() 
  {
    return HolaHelper.narrow(
    super._this_object());
  }

  public Hola _this(org.omg.CORBA.ORB orb) 
  {
    return HolaHelper.narrow(
    super._this_object(orb));
  }


} // class HolaPOA
