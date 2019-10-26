package com.alejandro.labexer4_alejandrocalvin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] companyName, country,industry, ceoName, desc;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan,  R.drawable.chinaconstructionbank,  R.drawable.agriculturalbankofchina,  R.drawable.bankofamerica,
                  R.drawable.apple,  R.drawable.pinganinsurance, R.drawable.bankofchina, R.drawable.royaldutchshell, R.drawable.wellsfargo, R.drawable.exxonmobil,
                  R.drawable.atandt, R.drawable.samsung, R.drawable.citigroup};
    ListView lstCompany;
    ArrayList<Company> companies = new ArrayList<Company>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companyName = getResources().getStringArray(R.array.company_name);
        country = getResources().getStringArray(R.array.country);
        industry = getResources().getStringArray(R.array.industry);
        ceoName = getResources().getStringArray(R.array.ceo_name);
        desc = getResources().getStringArray(R.array.description);

        for(int i=0; i<companyName.length;i++)
        {
            companies.add(new Company(logo[i], companyName[i], country[i], industry[i], ceoName[i], desc[i]));
        }
        CompanyAdapter adapter = new CompanyAdapter(this, R.layout.item, companies);
        lstCompany = findViewById(R.id.lvCompany);
        lstCompany.setAdapter(adapter);
        lstCompany.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(companyName[i]);
        dialog.setMessage(desc[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int position) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, companyName[i], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}
