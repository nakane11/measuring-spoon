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


public class Frag0 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final Context globalContext = this.getActivity();
        final View view = inflater.inflate(R.layout.frag_layout0, container, false);
        Button button = view.findViewById(R.id.button0);

        final CircleView frameView=new CircleView(globalContext,false);
        final CircleView contentView = new CircleView(globalContext, false);

        final FrameLayout frameLayout01 = (FrameLayout) view.findViewById(R.id.fragment_layout01);
        frameLayout01.addView(frameView);

        final FrameLayout frameLayout02 = (FrameLayout) view.findViewById(R.id.fragment_layout02);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) view.findViewById(R.id.amount0);
                if(editText.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "入力されていません",Toast.LENGTH_LONG).show();
                }else{
                    double amount = Double.parseDouble(editText.getText().toString());
                    frameLayout02.removeAllViews();
                    contentView.showCircle(amount);
                    frameLayout02.addView(contentView);
                }

                //AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(globalContext, R.animator.scale);
                //set.setTarget(circleView);
                //set.start();
            }
        });

        return view;
    }
}
