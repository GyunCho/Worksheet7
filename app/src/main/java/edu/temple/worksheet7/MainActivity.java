package edu.temple.worksheet7;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.PaletteInterface{

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paletteFragment = new PaletteFragment();
        canvasFragment = new CanvasFragment();
        addFragment(paletteFragment, R.id.frag1);
        addFragment(canvasFragment, R.id.frag2);
    }

    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void sendMessage(String message){
        canvasFragment.changeBackgroundColor(message);
    }

}
