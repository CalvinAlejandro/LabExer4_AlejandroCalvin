package com.alejandro.labexer4_alejandrocalvin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {

    private Context context;
    private int resource;

    public CompanyAdapter(@NonNull Context context, int resource, @NonNull List<Company> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
       int logo = getItem(i).getLogo();
        String name = getItem(i).getName();
        String country = getItem(i).getCountry();
        String industry = getItem(i).getIndustry();
        String CEO = getItem(i).getCEO();
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.ivCompanyLogo);
        TextView tvCompName = convertView.findViewById(R.id.tvCompanyName);
        TextView tvCountry = convertView.findViewById(R.id.tvCountry);
        TextView tvIndustry = convertView.findViewById(R.id.tvIndustry);
        TextView tvCEO = convertView.findViewById(R.id.tvCEO);

        img.setImageResource(logo);
        tvCompName.setText(name);
        tvCountry.setText("Country: " + country);
        tvIndustry.setText("Industry: " + industry);
        tvCEO.setText("CEO: " + CEO);
        return convertView;
    }
}
