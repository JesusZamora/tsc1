package PCControlApp;

/**
* PCControlApp/PCControlHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PCControl.idl
* martes 11 de febrero de 2014 11:34:31 AM CST
*/

public final class PCControlHolder implements org.omg.CORBA.portable.Streamable
{
  public PCControlApp.PCControl value = null;

  public PCControlHolder ()
  {
  }

  public PCControlHolder (PCControlApp.PCControl initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PCControlApp.PCControlHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PCControlApp.PCControlHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PCControlApp.PCControlHelper.type ();
  }

}
