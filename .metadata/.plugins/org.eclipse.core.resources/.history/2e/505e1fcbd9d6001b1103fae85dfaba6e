package modelado;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import org.json.JSONArray;
import org.json.JSONObject;
 
public class JsonUtiles 
{
    private final static String nombreArchivo = "test.json";

    public static void grabar(JSONArray array) {
        try {
            FileWriter file = new FileWriter(nombreArchivo);
            file.write(array.toString());
            file.flush();
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grabar(JSONObject jsonObject) {
        try {
            FileWriter file = new FileWriter(nombreArchivo);
            file.write(jsonObject.toString());
            file.flush();
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static String leer() 
    {
        String contenido = "";
        try 
        {
            contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return contenido;
    }
}
