package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class objectsAn extends AppCompatActivity {
    //initialize variable
   private ViewPager vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
//    int[] images = {R.drawable.backpack, R.drawable.chair, R.drawable.drum
//            , R.drawable.hammer, R.drawable.pillow, R.drawable.pc, R.drawable.bed, R.drawable.clock, R.drawable.book, R.drawable.ball, R.drawable.keys, R.drawable.shoes};
//

    int[] vocals = {R.raw.backpack, R.raw.chair, R.raw.drums, R.raw.hammer, R.raw.pillow, R.raw.computer, R.raw.bed, R.raw.clock, R.raw.book, R.raw.ball, R.raw.keys, R.raw.shoes
    };

//    //Create String array
//    String[] Names = {"backpack", "chair", "drums", "hammer", "pillow", "computer", "bed", "clock", "book", "ball", "keys", "shoes"};
//
//    MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_an);
        ImageView im = findViewById(R.id.speakerfan1);


        //assign variable
        vpHorizontal = findViewById(R.id.vp_horizontal2fan);

        //initialize main adapter
//        adapter = new MainAdapter3(images, Names);

////        set clip padding
//        vpHorizontal.setClipToPadding(false);
//        //set clip children
//        vpHorizontal.setClipChildren(false);
//        //set page limit
//        vpHorizontal.setOffscreenPageLimit(3);
//        //set default start position
//        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
//        vpHorizontal.setAdapter(adapter);

         loadcards();
        //initialize composite page transformer
//        CompositePageTransformer transformer = new CompositePageTransformer();
//        //add margin between page
//        transformer.addTransformer(new MarginPageTransformer(8));
//        //increase selected page size
//        transformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float v = 1 - Math.abs(position);
//                //set scale y
//                page.setScaleY(0.8f + v * 0.2f);
//            }
//        });
//        //set page transform
//        vpHorizontal.setPageTransformer(transformer);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(objectsAn.this, vocals[vpHorizontal.getCurrentItem()]);

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
    private void loadcards(){

        aymenmodelArrayList=new ArrayList<>();

        aymenmodelArrayList.add(new aymenmodel("Backpack",R.drawable.backpack));
        aymenmodelArrayList.add(new aymenmodel("chair",R.drawable.chair));
        aymenmodelArrayList.add(new aymenmodel("Drums",R.drawable.drum));
        aymenmodelArrayList.add(new aymenmodel("Hammer", R.drawable.hammer));
        aymenmodelArrayList.add(new aymenmodel("Pillow",R.drawable.pillow));
        aymenmodelArrayList.add(new aymenmodel("Computer",R.drawable.pc));
        aymenmodelArrayList.add(new aymenmodel("Bed",R.drawable.bed));
        aymenmodelArrayList.add(new aymenmodel("Clock",R.drawable.clock));
        aymenmodelArrayList.add(new aymenmodel("Book",R.drawable.book));
        aymenmodelArrayList.add(new aymenmodel("Ball",R.drawable.ball));
        aymenmodelArrayList.add(new aymenmodel("Keys",R.drawable.keys));
        aymenmodelArrayList.add(new aymenmodel("Shoes",R.drawable.shoes));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
