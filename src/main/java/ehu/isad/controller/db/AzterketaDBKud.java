package ehu.isad.controller.db;

import ehu.isad.Datuak;
import ehu.isad.Mezuak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AzterketaDBKud {
    private static AzterketaDBKud azterketakud=new AzterketaDBKud();
    private AzterketaDBKud(){}
    public static AzterketaDBKud getAzterketakud(){
        return azterketakud;
    }


    public String getBertsioa(String md5){
    List<Datuak> emaitza=new ArrayList<>();
    String bertsioa=null;
    String query="select version FROM checksums where md5='" + md5 + "'";
        ResultSet rs=DBKudeatzaile.getInstantzia().execSQL(query);
        try{
                rs.next();
                String version=rs.getString("version");
                bertsioa=version;


            } catch (SQLException e) {
            e.printStackTrace();
        }

        return bertsioa;
    }
}
