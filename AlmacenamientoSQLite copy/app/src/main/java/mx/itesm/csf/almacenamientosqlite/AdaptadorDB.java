package mx.itesm.csf.almacenamientosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//

public class AdaptadorDB {

    static final String LLAVE_IDFILA = "_id";
    static final String  LLAVE_NOMBRE = "nombre";
    static final String  LLAVE_APELLIDOPATERNO = "apellidoPaterno";
    static final String  LLAVE_APELLIDOMATERNO = "apellidoMaterno";
    static final String  LLAVE_TELEFONO = "telefono";
    static final String  LLAVE_EMAIL = "email";
    static final String ETIQUETA = "AdaptadorDB";

    static final String NOMBRE_BD = "Clientes";
    static final String BD_TABLA = "clientes";
    static final int VERSION_DB = 2;

    static final String CREAR_BD =
            "create table clientes (_id integer primary key autoincrement, " + "nombre text not null, email text not null,apellidoPaterno text not null,apellidoMaterno text not null,telefono text not null);";

    final Context contexto;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public AdaptadorDB(Context ctx)
    {
        this.contexto = ctx;
        DBHelper = new DatabaseHelper(contexto);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, NOMBRE_BD, null, VERSION_DB);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(CREAR_BD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(ETIQUETA, "Actualizando la version de la Base de Datos de " + oldVersion + " a "
                    + newVersion + ", este proceso eliminará los registros de la versión anterior");
            db.execSQL("DROP TABLE IF EXISTS clientes");
            onCreate(db);
        }
    }

    //--- Abrimos la BD ---
    public AdaptadorDB open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //--- Cerramos la BD ---
    public void close()
    {
        DBHelper.close();
    }

    //--- Insertamos registros a la tabla clientes ---
    public long insertaClientes(String nombre, String email,String apellidoPaterno,String apellidoMaterno,String telefono )
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(LLAVE_NOMBRE, nombre);
        initialValues.put(LLAVE_APELLIDOPATERNO , apellidoPaterno);
        initialValues.put(LLAVE_APELLIDOMATERNO , apellidoMaterno);
        initialValues.put(LLAVE_TELEFONO, telefono);
        initialValues.put(LLAVE_EMAIL, email);
        return db.insert(BD_TABLA, null, initialValues);
    }

    //--- Borra un cliente en particular ---
    public boolean borraCliente(String nombre)
    {
        return db.delete(BD_TABLA, LLAVE_NOMBRE + "=" + nombre, null) > 0;
    }

    //--- Recuperamos todos los registros de la tabla ---
    public Cursor obtenTodosLosClientes()
    {
        return db.query(BD_TABLA, new String[] {LLAVE_IDFILA, LLAVE_NOMBRE,
                LLAVE_EMAIL,LLAVE_APELLIDOPATERNO,LLAVE_APELLIDOMATERNO,LLAVE_TELEFONO}, null, null, null, null, null);
    }

    //--- Recuperamos un registro de cliente en particular ---
    public Cursor obtieneUnCliente(String name) throws SQLException
    {
        Cursor mCursor =
                db.query(true, BD_TABLA, new String[] {LLAVE_IDFILA, LLAVE_NOMBRE,
                        LLAVE_EMAIL,LLAVE_APELLIDOPATERNO,LLAVE_APELLIDOMATERNO,LLAVE_TELEFONO}, LLAVE_NOMBRE + "=" + name, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //--- Actualizamos un registro  ---
    public boolean actualizaCliente( String nombre, String email,String apellidoPaterno,String apellidoMaterno,String telefono)
    {
        ContentValues args = new ContentValues();
        args.put(LLAVE_NOMBRE, nombre);
        args.put(LLAVE_APELLIDOPATERNO , apellidoPaterno);
        args.put(LLAVE_APELLIDOMATERNO , apellidoMaterno);
        args.put(LLAVE_TELEFONO, telefono);
        args.put(LLAVE_EMAIL, email);
        return db.update(BD_TABLA, args, LLAVE_NOMBRE + "=" + nombre, null) > 0;
    }

}
