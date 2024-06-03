package edu.url.salle.malou.lundstrom.recycklerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.url.salle.malou.lundstrom.recycklerview.model.Crime;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CrimeAdapter adapter;
    private List<Crime> crimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_crime_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        crimes = new ArrayList<>();
        crimes.add(new Crime("Theft", "Description of theft", true));
        crimes.add(new Crime("Vandalism", "Description of vandalism", false));
        crimes.add(new Crime("Assault", "Description of assault", true));
        crimes.add(new Crime("Burglary", "Description of burglary", false));
        crimes.add(new Crime("Fraud", "Description of fraud", true));
        crimes.add(new Crime("Arson", "Description of arson", false));
        crimes.add(new Crime("Robbery", "Description of robbery", true));
        crimes.add(new Crime("Stalking", "Description of stalking", false));
        crimes.add(new Crime("Harassment", "Description of harassment", true));
        crimes.add(new Crime("Cybercrime", "Description of cybercrime", false));

        adapter = new CrimeAdapter(crimes);
        recyclerView.setAdapter(adapter);

        printAllCrimes(crimes);
    }

    private void printAllCrimes(List<Crime> crimes) {
        for (Crime crime : crimes) {
            Log.d("Crime", "Title: " + crime.getTitle() + ", Description: " + crime.getDescription());
        }
    }

    public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeHolder> {

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        class CrimeHolder extends RecyclerView.ViewHolder {

            private TextView mTitleTextView;
            private TextView mDescriptionTextView;

            public CrimeHolder(View itemView) {
                super(itemView);
                mTitleTextView = itemView.findViewById(R.id.text_view_crime_title);
                mDescriptionTextView = itemView.findViewById(R.id.text_view_crime_description);
            }

            public void bind(Crime crime) {
                mTitleTextView.setText(crime.getTitle());
                mDescriptionTextView.setText(crime.getDescription());
            }
        }
    }
}
