package com.clement.example.switchscreen;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clement.example.switchscreen.content.ContentFragment;
import com.clement.example.switchscreen.menu.MenuFragment;

public class NavigationActivity extends AppCompatActivity {

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //初始化工作,绑定Fragment
        initVariables(savedInstanceState) ;
    }

    /**绑定fragment
     * @param savedInstanceState
     */
    private void initVariables(Bundle savedInstanceState){
        //初始化
        if(savedInstanceState==null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            contentFragment = new ContentFragment();
            menuFragment = new MenuFragment();
            fragmentTransaction.add(R.id.ly_content, contentFragment,ContentFragment.class.getSimpleName());
            fragmentTransaction.add(R.id.ly_menu,menuFragment,MenuFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
        //屏幕旋转之后
        else{
            FragmentManager fragmentManager = getFragmentManager();
            contentFragment = (ContentFragment) fragmentManager.findFragmentByTag(ContentFragment.class.getSimpleName());
            menuFragment = (MenuFragment)fragmentManager.findFragmentByTag(MenuFragment.class.getSimpleName());
        }
    }
}
