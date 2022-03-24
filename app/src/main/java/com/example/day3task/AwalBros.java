package com.example.day3task;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AwalBros extends ListActivity {

    String[] listAct = {
            "Call Center",
            "SMS Center",
            "Drive Direction",
            "Website",
            "Info di Google",
            "Exit"
    };

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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
            if (pilihan.equals(listAct[0])) {
                String phoneNum = "tel: 0761-73646347";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
            }
            else if (pilihan.equals(listAct[1])) {
                String smsTxt = "Dear Awal Bros";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081234567890"));
                a.putExtra("sms_body", smsTxt);
            }
            else if (pilihan.equals(listAct[2])) {
                String rsLoc = "google.navigation:q=0.463823, 101.390353";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(rsLoc));
            }
            else if (pilihan.equals(listAct[3])) {
                String webAdrs = "https://haloawalbros.com";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(webAdrs));
            }
            else if (pilihan.equals(listAct[4])) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Awal Bros Panam");
            }
            else if (pilihan.equals(listAct[5])) {
                finish();
                System.exit(0);
            }

            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
