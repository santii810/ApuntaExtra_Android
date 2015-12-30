package sgomez.ejercicios.apuntaextra.Model;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import sgomez.ejercicios.apuntaextra.Activities.MainActivity;

/**
 * Created by sgomez on 29/12/2015.
 */
public class ParseLocalRepository {
    private final String DBNAME = "Locales";
    private final String T_ID = "objectId";
    private final String T_NOMBRE = "nombreLocal";
    private final String T_DIRECCION = "direccionLocal";
    private final String T_LATITUDE = "latitude";
    private final String T_LONGITUDE = "longitude";
    private final String T_INSERCION = "insertadoPor";

    public void addLocal(Local local) {
        ParseObject parseObject = new ParseObject(DBNAME);
        parseObject.put(T_NOMBRE, local.getNombre());
        parseObject.put(T_DIRECCION, local.getDireccion());
        parseObject.put(T_LATITUDE, local.getLatitude());
        parseObject.put(T_LONGITUDE, local.getLongitude());
        parseObject.put(T_INSERCION, MainActivity.getUsuario().getObjectId());

        parseObject.saveInBackground();
    }


    public ArrayList<Local> getLocales() {
        ArrayList<Local> locales = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                locales.add(rellenaLocal(object));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locales;
    }


    private Local rellenaLocal(ParseObject result) {
        Local local = new Local();
        local.setObjectId(result.getObjectId());
        local.setNombre(result.getString(T_NOMBRE));
        local.setDireccion(result.getString(T_DIRECCION));
        local.setLatitude(result.getDouble(T_LATITUDE));
        local.setLongitude(result.getDouble(T_LONGITUDE));
        return local;
    }
}