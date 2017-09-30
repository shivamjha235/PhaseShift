package phaseshift.com.demophase;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.heinrichreimersoftware.materialintro.app.*;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

/**
 * Created by Rohan on 19-07-2017.
 */

public class SplashIntroActivity extends IntroActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setButtonBackVisible(true);
        setButtonBackFunction(BUTTON_BACK_FUNCTION_SKIP);
        //setButtonBackFunction(BUTTON_BACK_FUNCTION_BACK);
        setButtonNextVisible(true);
        //setButtonNextFunction(BUTTON_NEXT_FUNCTION_NEXT_FINISH);
        //setButtonNextFunction(BUTTON_NEXT_FUNCTION_NEXT);
        setButtonCtaVisible(false);
        //setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_material_metaphor)
                .description(R.string.description_material_metaphor)
                .image(0)
                .background(R.color.color_material_metaphor)
                .backgroundDark(R.color.color_dark_material_metaphor)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_material_motion)
                .description(R.string.description_material_motion)
                .image(0)
                .background(R.color.color_material_motion)
                .backgroundDark(R.color.color_dark_material_motion)
                .build());
        addSlide(new Slide() {

            @Override
            public Fragment getFragment() {
                return SliderFragment.newInstance();
            }

            @Override
            public int getBackground() {
                return R.color.color_primary_light;
            }

            @Override
            public int getBackgroundDark() {
                return R.color.color_primary;
            }

            @Override
            public boolean canGoForward() {
                return true;
            }

            @Override
            public boolean canGoBackward() {
                return true;
            }
        });
    }
}
