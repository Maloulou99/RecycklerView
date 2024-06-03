package edu.url.salle.malou.lundstrom.recycklerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;


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
        crimes.add(new Crime("Theft", "Description of theft", true, true));
        crimes.add(new Crime("Vandalism", "Description of vandalism", false, false));
        crimes.add(new Crime("Assault", "Description of assault", true, true));
        crimes.add(new Crime("Burglary", "Description of burglary", false, false));
        crimes.add(new Crime("Fraud", "Description of fraud", true, true));
        crimes.add(new Crime("Arson", "Description of arson", false, false));
        crimes.add(new Crime("Robbery", "Description of robbery", true, true));
        crimes.add(new Crime("Stalking", "Description of stalking", false, false));
        crimes.add(new Crime("Harassment", "Description of harassment", true, true));
        crimes.add(new Crime("Cybercrime", "Description of cybercrime", false, false));

        adapter = new CrimeAdapter(crimes);
        recyclerView.setAdapter(adapter);
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

        class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private TextView mTitleTextView;
            private TextView mDescriptionTextView;
            private CheckBox mSolvedCheckBox;
            private Crime mCrime;

            public CrimeHolder(View itemView) {
                super(itemView);
                mTitleTextView = itemView.findViewById(R.id.text_view_crime_title);
                mDescriptionTextView = itemView.findViewById(R.id.text_view_crime_description);
                mSolvedCheckBox = itemView.findViewById(R.id.check_box_crime_solved);
                itemView.setOnClickListener(this);
            }

            public void bind(Crime crime) {
                mCrime = crime;
                mTitleTextView.setText(crime.getTitle());
                mDescriptionTextView.setText(crime.getDescription());
                mSolvedCheckBox.setChecked(crime.isSolved());

                // Change the background color based on whether the crime is critical
                if (crime.isCritical()) {
                    itemView.setBackgroundColor(itemView.getResources().getColor(android.R.color.holo_red_light));
                } else {
                    itemView.setBackgroundColor(itemView.getResources().getColor(android.R.color.holo_green_light));
                }
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mCrime.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
