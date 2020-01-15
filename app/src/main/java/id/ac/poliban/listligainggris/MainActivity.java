package id.ac.poliban.listligainggris;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<LigaInggris> clubs = new ArrayList<>();
    private ListView lvClub;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvClub = findViewById(R.id.listview);

        clubs.addAll(LigaInggrisData.getAllClub());

        adapter = new ClubAdapter(clubs);

        lvClub.setAdapter(adapter);

        lvClub.setOnItemClickListener(((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Negara Yang Anda Pilih")
                    .setMessage("Anda Memilih: " +
                            clubs.get(position).getNamaLogo())
                    .setPositiveButton("OK", null).show();
        }));
    }
}