package events.tgh2020.measuring_spoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Frag0 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final Context globalContext = this.getActivity();
        int position = getArguments().getInt("position");

        View view = inflater.inflate(R.layout.frag_layout0, container, false);
        Button button = view.findViewById(R.id.button0);
        EditText amount = view.findViewById(R.id.amount0);

        final CircleView circleView=new CircleView(globalContext,false);
        final FrameLayout frameLayout01 = (FrameLayout) view.findViewById(R.id.fragment_layout01);
        frameLayout01.addView(circleView);

        final FrameLayout frameLayout02 = (FrameLayout) view.findViewById(R.id.fragment_layout02);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frameLayout02.removeAllViews();
                //CircleView circleView=new CircleView(globalContext);
                //AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(globalContext, R.animator.scale);
                //set.setTarget(circleView);
                //set.start();
                //frameLayout02.addView(circleView);
            }
        });

        return view;
    }
}
