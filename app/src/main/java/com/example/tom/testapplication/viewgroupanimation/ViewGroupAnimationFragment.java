package com.example.tom.testapplication.viewgroupanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.tom.testapplication.R;

public class ViewGroupAnimationFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewgroupanimation_fragment, container, false);

        TextView textView = (TextView) v.findViewById(R.id.vga_text);
        textView.setText("Animation Fragment");

        Button btn = (Button) v.findViewById(R.id.vga_btn);
        btn.setOnClickListener(this);

        return v;
    }

    public void animateOut() {
        getView().animate().scaleX(0.5f).scaleY(0.5f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .translationX(200);
    }

    public void animateIn() {
        getView().animate().scaleX(1f).scaleY(1f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .translationX(0);
    }

    @Override
    public void onClick(View view) {
        if (getView().getScaleX() != 1f) {
            animateIn();
        } else {
            animateOut();
        }
    }
}
