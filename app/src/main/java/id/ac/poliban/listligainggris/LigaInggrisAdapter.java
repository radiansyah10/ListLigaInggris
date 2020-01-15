package id.ac.poliban.listligainggris;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ClubAdapter extends BaseAdapter {
    private List<LigaInggris> data = new ArrayList<>();

    public ClubAdapter(List<LigaInggris> data){
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img_flag;
        TextView tvClubName;
        TextView tvClubDesc;

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_liga_inggris, parent, false);

        img_flag = convertView.findViewById(R.id.img_gambar);
        tvClubName = convertView.findViewById(R.id.tvNamaLogo);
        tvClubDesc = convertView.findViewById(R.id.tvDesc);

        Glide.with(parent.getContext())
                .load(data.get(position).getGambar())
                .apply(new RequestOptions().override(60,60))
                .into(img_flag);
        tvClubName.setText(data.get(position).getNamaLogo());
        tvClubDesc.setText(data.get(position).getLogoDesc());

        return convertView;
    }
}