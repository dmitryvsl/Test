package euroapp.sdeaz.presentation.utils;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StringResourceExtracter {

    Context context;

    @Inject
    public StringResourceExtracter(Context context) {
        this.context = context;
    }

    public String extractStringResource(int stringId){
        return context.getResources().getString(stringId);
    }
}
