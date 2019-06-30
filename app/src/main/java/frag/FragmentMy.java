package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tranquil.LoginActivity;
import com.example.tranquil.R;
import com.example.tranquil.SetMyActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FragmentMy extends Fragment implements View.OnClickListener {

    @ViewInject(R.id.more)
    public TextView setmy;
    public Button exitmy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_my,null);
        ViewUtils.inject(getActivity());
        setmy = view.findViewById(R.id.more);
        setmy.setOnClickListener(this);
        exitmy = view.findViewById(R.id.exitBtn);
        exitmy.setOnClickListener(this);
        return view;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more:
                startActivity(new Intent(getActivity(), SetMyActivity.class));
                break;
            case R.id.exitBtn:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                break;
                default:
                    break;
        }
    }

}
