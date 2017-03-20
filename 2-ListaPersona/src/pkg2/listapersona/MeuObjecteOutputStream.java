/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 *
 * @author vicent
 */
public class MeuObjecteOutputStream extends ObjectOutputStream{
     /** Constructor que rep OutputStream */
    public MeuObjecteOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor sense paràmetres */
    protected MeuObjecteOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinició del mètode d'escriure la capçalera per a que no faci res. */
    protected void writeStreamHeader() throws IOException
    {
    }
    
}