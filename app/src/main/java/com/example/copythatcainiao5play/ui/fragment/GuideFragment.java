package com.example.copythatcainiao5play.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.copythatcainiao5play.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GuideFragment extends Fragment {

    public static final String IMG_ID = "IMG_ID";
    public static final String COLOR_ID = "COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";

    @BindView(R.id.imgView)
    ImageView imgView;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.rootView)
    LinearLayout rootView;

    private View view;

    public static GuideFragment newInstance(int imgResId, int bgColorResId, int textResId) {

        GuideFragment fragment = new GuideFragment();

        Bundle bundle = new Bundle();

        bundle.putInt(IMG_ID, imgResId);
        bundle.putInt(COLOR_ID, bgColorResId);
        bundle.putInt(TEXT_ID, textResId);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        Bundle args = getArguments();
        assert args != null;
        int colorId = args.getInt(COLOR_ID);
        int imgId = args.getInt(IMG_ID);
        int textId = args.getInt(TEXT_ID);

        rootView.setBackgroundColor(getResources().getColor(colorId));
        imgView.setImageResource(imgId);
        text.setText(textId);
    }
}