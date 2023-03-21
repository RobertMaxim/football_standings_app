package com.example.myapplication.Models.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LeaguesPageBinding;

public class HomepageFragment extends Fragment {

    private LeaguesPageBinding binding;
    public static String PACKAGE_NAME;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        PACKAGE_NAME = getContext().getPackageName();

        binding = LeaguesPageBinding.inflate(inflater, container, false);

        String path = "android.resource://" +
                PACKAGE_NAME + "/"
                + R.raw.video;

        VideoView videoView = binding.getRoot().findViewById(R.id.videoView);
        videoView.setVideoPath(path);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setVolume(0.05f, 0.05f);
            }
        });
        videoView.start();

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSerieA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomepageFragment.this)
                        .navigate(R.id.action_HomepageFragment_to_serieAFragment);
            }
        });

        binding.buttonLigue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomepageFragment.this)
                        .navigate(R.id.action_HomepageFragment_to_ligueUneFragment);
            }
        });
        binding.buttonBundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomepageFragment.this)
                        .navigate(R.id.action_HomepageFragment_to_bundesligaFragment);
            }
        });
        binding.buttonPremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomepageFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.buttonLaLiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomepageFragment.this)
                        .navigate(R.id.action_HomepageFragment_to_laLigaFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}