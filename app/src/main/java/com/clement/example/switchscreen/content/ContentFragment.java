package com.clement.example.switchscreen.content;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.clement.example.switchscreen.R;

public class ContentFragment extends Fragment {
    //保存fragment的view
    private View rootView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设备旋转时保存Fragment的交互状态(activity重建时,fragment不执行onCreate和onDestroy)
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView = inflater.inflate(R.layout.fragment_content, container, false);
        }
        return rootView;
    }
}
