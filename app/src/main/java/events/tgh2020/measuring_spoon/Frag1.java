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


public class Frag1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final Context globalContext = this.getActivity();
        int position = getArguments().getInt("position");

        View view = inflater.inflate(R.layout.frag_layout1, container, false);
        Button button = view.findViewById(R.id.button1);
        EditText amount = view.findViewById(R.id.amount1);

        final CircleView circleView=new CircleView(globalContext, true);
        final FrameLayout frameLayout11 = (FrameLayout) view.findViewById(R.id.fragment_layout11);
        frameLayout11.addView(circleView);

        final FrameLayout frameLayout12 = (FrameLayout) view.findViewById(R.id.fragment_layout12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frameLayout12.removeAllViews();
                //CircleView circleView=new CircleView(globalContext);
                //AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(globalContext, R.animator.scale);
                //set.setTarget(circleView);
                //set.start();
            }
        });

        return view;
    }

}
