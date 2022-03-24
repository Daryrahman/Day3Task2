package com.example.day3task;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    String[] listRS = {
            "RS Awal Bros",
            "RS Eka Hospital",
            "RS Jiwa Tampan",
            "RS Tabrani"
    };

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, listRS));
    }

    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilPilihan(pilihan);
    }

    private void tampilPilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals(listRS[0])) {
                a = new Intent(this, AwalBros.class);
            }
            else if (pilihan.equals(listRS[1])) {
                a = new Intent(this, EkaHospital.class);
            }
            else if (pilihan.equals(listRS[2])) {
                a = new Intent(this, JiwaTampan.class);
            }
            else if (pilihan.equals(listRS[3])) {
                a = new Intent(this, Tabrani.class);
            }

            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
