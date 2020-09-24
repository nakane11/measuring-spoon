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

import java.text.DecimalFormat;

import static events.tgh2020.measuring_spoon.Scale.startScale;


public class Frag1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final Context globalContext = this.getActivity();
        final View view = inflater.inflate(R.layout.frag_layout1, container, false);
        Button button = view.findViewById(R.id.button1);
        final EditText editText = (EditText) view.findViewById(R.id.amount1);
        final DecimalFormat format = new DecimalFormat("0.###");

        final CircleView frameView=new CircleView(globalContext,true);
        final FrameLayout frameLayout11 = (FrameLayout) view.findViewById(R.id.fragment_layout11);
        frameLayout11.addView(frameView);

        final CircleView contentView = new CircleView(globalContext, true);
        final FrameLayout frameLayout12 = (FrameLayout) view.findViewById(R.id.fragment_layout12);
        frameLayout12.addView(contentView);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String str = editText.getText().toString();
                boolean run = true;
                double amount = 0;
                try{
                    amount = MyMath.parse(str);
                    if(amount<0) {
                        throw new IndexOutOfBoundsException();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "無効な値です",Toast.LENGTH_LONG).show();
                    run = false;
                }

                if(run){
                    editText.setText(format.format(amount));
                    contentView.showCircle();
                    startScale(contentView,(float)MyMath.ratio(amount));
                }
            }
        });

        return view;
    }


}