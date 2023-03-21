package com.example.myapplication.Models.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.Models.match.Match;
import com.example.myapplication.Models.match.MatchList;
import com.example.myapplication.Models.standing.Standing;
import com.example.myapplication.Models.standing.StandingTeam;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LaligaBinding;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class LaLigaFragment extends Fragment {

    private LaligaBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = LaligaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startAsyncTask(view,"standing");
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LaLigaFragment.this)
                        .navigate(R.id.action_laLigaFragment_to_HomepageFragment);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncTask(view,"matches");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LaLigaFragment.this)
                        .navigate(R.id.action_laLigaFragment_self);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void startAsyncTask(View view, String dataDetail) {
        if(dataDetail.equals("matches")){
            com.example.myapplication.Helper.LeaguesAsyncTask<MatchList> leaguesAsyncTask = new com.example.myapplication.Helper.LeaguesAsyncTask();
            leaguesAsyncTask.execute("matches","la_liga");

            try {
                MatchList listOfMatches = (MatchList) leaguesAsyncTask.get();

                List<Match> tableOfMatches = listOfMatches.getMatches();

                TableLayout table = view.findViewById(R.id.myTable);
                table.removeAllViews();
                table.setVerticalScrollBarEnabled(true);
                table.setVerticalScrollbarPosition(1);
                for (Match match : tableOfMatches) {
                    TableRow row = new TableRow(getActivity());

                    TextView tv2 = new TextView(getActivity());
                    tv2.setText(match.getHomeTeam().getName());
                    tv2.setTextSize(16);
                    tv2.setWidth(550);

                    TextView tv3 = new TextView(getActivity());
                    tv3.setText(match.getScore().getFullTime().getHomeTeam());
                    tv3.setTextSize(16);

                    TextView tv4 = new TextView(getActivity());
                    tv4.setText(match.getScore().getFullTime().getAwayTeam());
                    tv4.setTextSize(16);
                    tv4.setWidth(40);

                    TextView tv5 = new TextView(getActivity());
                    tv5.setText(match.getAwayTeam().getName());
                    tv5.setTextSize(16);
                    tv5.setWidth(550);

                    TextView tv6=new TextView(getActivity());
                    tv6.setTextSize(16);
                    tv6.setText("-");

                    row.addView(tv2);
                    row.addView(tv3);
                    row.addView(tv6);
                    row.addView(tv4);
                    row.addView(tv5);

                    View v = new View(getActivity());
                    v.setLayoutParams(new TableRow.LayoutParams(3, 4));
                    v.setBackgroundColor(Color.BLACK);

                    table.setShrinkAllColumns(true);
                    table.setStretchAllColumns(true);
                    table.setScrollbarFadingEnabled(false);
                    table.addView(row);
                    table.addView(v);
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (dataDetail.equals("standing")) {
            com.example.myapplication.Helper.LeaguesAsyncTask<Standing> leaguesAsyncTask = new com.example.myapplication.Helper.LeaguesAsyncTask();
            leaguesAsyncTask.execute("standing", "la_liga");
            try {
                Standing result = (Standing) leaguesAsyncTask.get();
                List<StandingTeam> premierLeagueTable = result.getStandings().get(0).getTable();

                TableLayout table = (TableLayout) view.findViewById(R.id.myTable);

                for (int i = 0; i < premierLeagueTable.size(); i++) {
                    TableRow row = new TableRow(getActivity());

                    TextView tv1 = new TextView(getActivity());
                    tv1.setTextSize(16);
                    tv1.setText(Integer.toString(i + 1));

                    TextView tv2 = new TextView(getActivity());
                    tv2.setText(premierLeagueTable.get(i).getTeam().getName());
                    tv2.setTextSize(16);

                    TextView tv3 = new TextView(getActivity());
                    tv3.setText(premierLeagueTable.get(i).getPlayedGames());
                    tv3.setTextSize(16);

                    TextView tv4 = new TextView(getActivity());
                    tv4.setText(premierLeagueTable.get(i).getPoints());
                    tv4.setTextSize(16);

                    TextView tv5 = new TextView(getActivity());
                    tv5.setText(premierLeagueTable.get(i).getWon());
                    tv5.setTextSize(16);

                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv3);
                    row.addView(tv4);
                    row.addView(tv5);
                    View v = new View(getActivity());
                    v.setLayoutParams(new TableRow.LayoutParams(3, 4));
                    v.setBackgroundColor(Color.BLACK);
                    table.addView(row);
                    table.addView(v);
                }

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}