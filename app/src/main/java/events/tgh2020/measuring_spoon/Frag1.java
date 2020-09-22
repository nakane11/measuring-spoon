package events.tgh2020.measuring_spoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

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

        final View view = inflater.inflate(R.layout.frag_layout1, container, false);
        Button button = view.findViewById(R.id.button1);

        final CircleView frameView=new CircleView(globalContext,true);
        final CircleView contentView = new CircleView(globalContext, true);

        final FrameLayout frameLayout11 = (FrameLayout) view.findViewById(R.id.fragment_layout11);
        frameLayout11.addView(frameView);

        final FrameLayout frameLayout12 = (FrameLayout) view.findViewById(R.id.fragment_layout12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) view.findViewById(R.id.amount1);
                if(editText.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "入力されていません",Toast.LENGTH_LONG).show();
                }else{
                    double amount = Double.parseDouble(editText.getText().toString());
                    frameLayout12.removeAllViews();
                    contentView.showCircle(amount);
                    frameLayout12.addView(contentView);
                }

                //AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(globalContext, R.animator.scale);
                //set.setTarget(circleView);
                //set.start();
            }
        });

        return view;
    }
}