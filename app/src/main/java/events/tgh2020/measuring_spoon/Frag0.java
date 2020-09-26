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
        final EditText editText = (EditText) view.findViewById(R.id.amount0);
        final DecimalFormat format = new DecimalFormat("0.###");

        final CircleView frameView=new CircleView(globalContext,false);
        final FrameLayout frameLayout01 = (FrameLayout) view.findViewById(R.id.fragment_layout01);
        frameLayout01.addView(frameView);

        final CircleView contentView = new CircleView(globalContext, false);
        final FrameLayout frameLayout02 = (FrameLayout) view.findViewById(R.id.fragment_layout02);
        frameLayout02.addView(contentView);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //体積を半径に変換
                String str = editText.getText().toString();
                boolean run = true;
                double amount = 0;
                try{
                    amount = MyMath.parse(str);
                    if(amount<0 || amount>1) {
                        throw new IndexOutOfBoundsException();
                    }
                }catch (IndexOutOfBoundsException e) {
                    Toast.makeText(getActivity(), "0~1の範囲で入力して下さい",Toast.LENGTH_LONG).show();
                    run = false;
                }catch (Exception e){
                    Toast.makeText(getActivity(), "無効な値です",Toast.LENGTH_LONG).show();
                    run = false;
                }

                //アニメーションの表示
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

